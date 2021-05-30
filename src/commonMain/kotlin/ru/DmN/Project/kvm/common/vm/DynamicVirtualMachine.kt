package ru.DmN.Project.kvm.common.vm

import ru.DmN.Project.core.obj.api.v0.IObject
import ru.DmN.Project.core.vm.v0.IVirtualMachine
import ru.DmN.Project.kvm.common.obj.impl.context.MainContext

open class DynamicVirtualMachine : IVirtualMachine<ByteArray> {
    open var context = MainContext()

    override fun init() {
        TODO("Not yet implemented")
    }

    override fun eval(code: ByteArray) {
        TODO("Not yet implemented")
    }
}