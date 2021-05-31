package ru.DmN.Project.kvm.common.obj.api

import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.kvm.common.data.api.IFS

interface IFunctionsContainer<I : IObject> : IObject {
    val functions: IFS<I>
}