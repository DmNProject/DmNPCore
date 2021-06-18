package ru.DmN.Project.kvm.common.vm

import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.kvm.common.obj.api.IFunction
import ru.DmN.Project.kvm.common.vm.api.IVM

class Call<C, V : IVM<C, V, O>, O : IObject>(val vm: V, val thread: Thread<C, V, O>, val instance: IObject, val function: IFunction<C, V, O>, val args: List<O>) {
    var result: O = vm.defines["null"]!!
}