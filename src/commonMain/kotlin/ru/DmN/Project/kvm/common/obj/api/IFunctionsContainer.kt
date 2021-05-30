package ru.DmN.Project.kvm.common.obj.api

import ru.DmN.Project.core.data.obj.api.v0.DP
import ru.DmN.Project.kvm.common.data.api.IFS

interface IFunctionsContainer<VM, I> : DP {
    val functions: IFS<VM, I>
}