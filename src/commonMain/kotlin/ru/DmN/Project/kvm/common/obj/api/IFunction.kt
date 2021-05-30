package ru.DmN.Project.kvm.common.obj.api

import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.obj.ICO

interface IFunction<VM, I> : ICO<VM, I> {
    val args: Iterable<IObject>
}