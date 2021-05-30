package ru.DmN.Project.kvm.common.obj.api

import ru.DmN.Project.core.obj.api.v1.ICO

interface IFunctionsContainer<VM, O> {
    val functions: ArrayList<ICO<VM, O>>
}