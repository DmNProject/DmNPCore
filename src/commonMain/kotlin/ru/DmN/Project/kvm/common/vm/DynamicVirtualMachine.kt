package ru.DmN.Project.kvm.common.vm

import ru.DmN.Project.core.data.obj.api.IDS
import ru.DmN.Project.core.data.obj.api.IES
import ru.DmN.Project.core.data.obj.impl.IDSImpl
import ru.DmN.Project.core.data.obj.impl.IESImpl
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.vm.IVirtualMachine
import ru.DmN.Project.kvm.common.data.api.IFS
import ru.DmN.Project.kvm.common.data.impl.IFSImpl
import ru.DmN.Project.kvm.common.obj.KawaiiType
import ru.DmN.Project.kvm.common.obj.api.IFunction
import ru.DmN.Project.kvm.common.obj.api.IFunctionsContainer
import ru.DmN.Project.kvm.common.obj.api.KObject
import ru.DmN.Project.kvm.common.obj.impl.SpecValueObject
import ru.DmN.Project.kvm.common.utils.getUndefined

open class DynamicVirtualMachine(
    name: String = "DynamicVirtualMachine",
    defines: IDS<IObject> = IDSImpl(),
    functions: IFS<DynamicVirtualMachine> = IFSImpl(),
    extends: IES<IObject> = IESImpl()
) : IVirtualMachine<ByteArray>, KObject<DynamicVirtualMachine>(name, KawaiiType.VM, defines, functions, extends) {
    val tNULL get() = defines["null"]!!
    val tUNDEFINED get() = defines["undefined"]!!

    override fun init() {
        defines.add(SpecValueObject("null", null))
        defines.add(SpecValueObject("undefined", getUndefined()))
    }

    override fun eval(code: ByteArray) {
        TODO("Not yet implemented")
    }

    fun <I : IObject> callFunction(instance: I, func: IFunction<I>, args: Iterable<IObject>, stack: CallStack = CallStack()): Call<*> {
        val call = Call(this, stack, instance, func, args)
        stack.addCall(call)
        func.call(call)
        stack.removeCall(call)
        return call
    }

    fun <I : IObject> callFunction(instance: IFunctionsContainer<I>, name: String, args: Iterable<IObject>, stack: CallStack = CallStack()): Call<*>? {
        val func = instance.functions[name, args]

        return if (func == null)
            null
        else {
            val call = Call(this, stack, instance, func, args)
            stack.addCall(call)
            func.call(call)
            stack.removeCall(call)
            call
        }
    }
}