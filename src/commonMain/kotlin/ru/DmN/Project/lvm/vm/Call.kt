package ru.DmN.Project.lvm.vm

import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.lvm.obj.LightFunction

class Call(val vm: LightVirtualMachine, val thread: Thread, val instance: IObject, val function: LightFunction, val args: Iterable<IObject>) {
    var result: IObject = vm.defines["null"]!!
}