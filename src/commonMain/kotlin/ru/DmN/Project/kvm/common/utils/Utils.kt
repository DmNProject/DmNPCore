package ru.DmN.Project.kvm.common.utils

import ru.DmN.Project.core.data.impl.IESImpl
import ru.DmN.Project.core.obj.IDO
import ru.DmN.Project.core.obj.IEO
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.util.AtomicInt
import ru.DmN.Project.kvm.common.obj.KawaiiType
import ru.DmN.Project.kvm.common.obj.api.IFunction
import ru.DmN.Project.kvm.common.obj.api.IFunctionsContainer
import ru.DmN.Project.kvm.common.obj.impl.types.TInstance
import ru.DmN.Project.kvm.common.vm.DynamicVirtualMachine

object Utils {
    fun getDefine(obj: IObject, name: String): IObject {
        var le: IObject = obj
        while (le.name != name) {
            if (le is IDO<*>)
                le = le.defines[name] ?: le
            if (le.name != name && le is IEO<*>)
                for (e in le.extends)
                    if (e.name == name) {
                        return e
                    } else {
                        val founded = getDefine(e, name)
                        if (founded.name == name)
                            return founded
                    }
        }
        return le
    }

    fun getFunction(obj: IObject, name: String, args: ArrayList<IObject>, li: AtomicInt = AtomicInt(Int.MAX_VALUE)): IFunction? {
        var lf: IFunction? = null

        if (obj is IFunctionsContainer) {
            val i = AtomicInt(Int.MAX_VALUE)
            lf = validate(lf, li, obj.functions[name, args, i], i.value)
        }

        if (obj is IEO<*>)
            for (e in obj.extends)
                lf = getFunction(e, name, args, li)

        return lf
    }

    fun validate(lf: IFunction?, li: AtomicInt, nf: IFunction?, i: Int): IFunction? {
        if (i < li.value) {
            li.value = i
            return nf
        }
        return lf
    }

    inline fun createX(obj: IObject, name: String, value: Any?): TInstance =
        TInstance(name, KawaiiType.VAR, value, IESImpl(obj))

    fun createString(vm: DynamicVirtualMachine, name: String, value: String?): TInstance? {
        return try {
            createX(vm.tSTRING, name, value)
        } catch (ignored: Exception) {
            null
        }
    }

    fun createString(vm: DynamicVirtualMachine, name: String, value: ByteArray): TInstance? {
        return try {
            createX(vm.tSTRING, name, value.decodeToString())
        } catch (ignored: Exception) {
            null
        }
    }

    fun createInt(vm: DynamicVirtualMachine, name: String, value: Int?): TInstance? {
        return try {
            createX(vm.tNUMBER, name, value)
        } catch (ignored: Exception) {
            null
        }
    }
}