package ru.DmN.Project.lvm.vm

import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.lvm.obj.LightFunction
import ru.DmN.Project.lvm.obj.LightObject

class Call(val vm: LightVirtualMachine, val thread: Thread, val instance: LightObject, val function: LightFunction, val args: Iterable<IObject>) {
    var result: IObject = vm.defines["null"]!!
}