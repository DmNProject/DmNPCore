package ru.DmN.Project.kvm.common.obj.api

import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.kvm.common.data.api.IFS
import ru.DmN.Project.kvm.common.vm.api.IVM

interface IFunctionsContainer<C, V : IVM<C, V, O>, O : IObject> : IObject {
    val functions: IFS<C, V, O>
}