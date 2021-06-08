package ru.DmN.Project.lvm.utils

import ru.DmN.Project.core.obj.IEO
import ru.DmN.Project.core.util.AtomicInt
import ru.DmN.Project.lvm.obj.LightObject
import ru.DmN.Project.lvm.obj.LightType
import ru.DmN.Project.lvm.obj.types.TInstance
import ru.DmN.Project.lvm.vm.LightVirtualMachine

object Utils {
    fun objectEquals(o1: LightObject, o2: LightObject): Boolean {
        if (o1.name == o2.name || o1.extend == o2 || o2.extend == o1)
            return true
        for (e in o1.implementations)
            if (e.name == o2.name || (e is IEO<*> && objectEquals(e, o2)))
                return true
        return false
    }

    fun objectEquals(o1: LightObject, o2: LightObject, i: AtomicInt): Boolean {
        if (o1.name == o2.name)
            return true
        i.value++
        for (e in o1.implementations)
            if (e.name == o2.name)
                return true
        i.value++
        for (e in o1.implementations)
            if (objectEquals(e, o2))
                return true
        i.value -= 2
        return false
    }

    inline fun createX(obj: LightObject, name: String, value: Any?): TInstance =
        TInstance(name, LightType.OBJ, value, obj)

    fun createString(vm: LightVirtualMachine, name: String, value: String?): TInstance? {
        return try {
            createX(vm.tSTRING, name, value)
        } catch (ignored: Exception) {
            null
        }
    }

    fun createString(vm: LightVirtualMachine, name: String, value: ByteArray): TInstance? {
        return try {
            createX(vm.tSTRING, name, value.decodeToString())
        } catch (ignored: Exception) {
            null
        }
    }

    fun createInt(vm: LightVirtualMachine, name: String, value: Int?): TInstance? {
        return try {
            createX(vm.tNUMBER, name, value)
        } catch (ignored: Exception) {
            null
        }
    }
}