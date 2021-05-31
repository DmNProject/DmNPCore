package ru.DmN.Project.kvm.common.vm

import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.kvm.common.obj.api.IFunction

class Call<I : IObject>(val vm: DynamicVirtualMachine, stack: CallStack, val instance: I, val function: IFunction<I>, val args: Iterable<IObject>) {
    var result: IObject = vm.defines["null"]!!
}