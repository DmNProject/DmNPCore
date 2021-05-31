package ru.DmN.Project.kvm.common.obj.api

import ru.DmN.Project.kvm.common.data.api.IFS

interface IFunctionsContainer<VM, I> {
    val functions: IFS<VM, I>
}