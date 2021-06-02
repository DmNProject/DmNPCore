package ru.DmN.Project.kvm.common.vm

import ru.DmN.Project.core.data.api.IDS
import ru.DmN.Project.core.data.api.IES
import ru.DmN.Project.core.data.impl.IDSImpl
import ru.DmN.Project.core.data.impl.IESImpl
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.vm.IVirtualMachine
import ru.DmN.Project.kvm.common.data.api.IFS
import ru.DmN.Project.kvm.common.data.impl.IFSImpl
import ru.DmN.Project.kvm.common.obj.KawaiiType
import ru.DmN.Project.kvm.common.obj.api.IFunction
import ru.DmN.Project.kvm.common.obj.api.IFunctionsContainer
import ru.DmN.Project.kvm.common.obj.api.KObject
import ru.DmN.Project.kvm.common.obj.impl.SpecValueObject
import ru.DmN.Project.kvm.common.obj.impl.types.TKawaiiNumber
import ru.DmN.Project.kvm.common.obj.impl.types.TKawaiiObject
import ru.DmN.Project.kvm.common.obj.impl.types.TKawaiiString
import ru.DmN.Project.kvm.common.utils.getUndefined

open class DynamicVirtualMachine(
    name: String = "DynamicVirtualMachine",
    defines: IDS<IObject> = IDSImpl(),
    functions: IFS = IFSImpl(),
    extends: IES<IObject> = IESImpl()
) : IVirtualMachine<ByteArray>, KObject(name, KawaiiType.VM, defines, functions, extends) {
    inline val tNULL        get() = defines["null"]!!
    inline val tUNDEFINED   get() = defines["undefined"]!!
    inline val tOBJECT      get() = defines["ru.DmN.Project.kvm.Object"]!!
    inline val tSTRING      get() = defines["ru.DmN.Project.kvm.String"]!!
    inline val tNUMBER      get() = defines["ru.DmN.Project.kvm.Number"]!!
    //
    val mainThread = Thread("MainThread")

    override fun init() {
        defines.add(SpecValueObject("null", null))
        defines.add(SpecValueObject("undefined", getUndefined()))
        defines.add(TKawaiiObject())
        defines.add(TKawaiiString(tOBJECT))
        defines.add(TKawaiiNumber(tOBJECT))
        //
        extends.add(tOBJECT)
    }

    override fun eval(code: ByteArray) {
        TODO("Not yet implemented")
    }

    fun callFunction(instance: IObject, func: IFunction, args: Iterable<IObject>, thread: Thread = Thread("_")): Call {
        val cs = thread.callStack
        val call = Call(this, cs, instance, func, args)
        cs.addCall(call)

        func.call(call)

        cs.removeCall(call)
        return call
    }

    fun callFunction(instance: IFunctionsContainer, name: String, args: Iterable<IObject>, thread: Thread = Thread("_")): Call? {
        val func = instance.functions[name, args]

        return if (func == null)
            null
        else {
           callFunction(instance, func, args, thread)
        }
    }
}