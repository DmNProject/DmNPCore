package ru.DmN.Project.kvm.common.vm

import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.kvm.common.obj.api.IFunction

class Call(val vm: DynamicVirtualMachine, val thread: Thread, val instance: IObject, val function: IFunction, val args: Iterable<IObject>) {
    var result: IObject = vm.defines["null"]!!
}