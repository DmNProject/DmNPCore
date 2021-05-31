package ru.DmN.Project.kvm.common.vm

import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.kvm.common.obj.api.IFunction

class Call(val vm: DynamicVirtualMachine, stack: CallStack, val instance: IObject, val function: IFunction<IObject>, val args: Iterable<IObject>) {
    var result: IObject = vm.defines["null"]!!
}