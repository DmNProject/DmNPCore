package ru.DmN.Project.core.obj.api.v1

import ru.DmN.Project.core.obj.api.v0.IObject

/**
 * Callable Object
 */
interface ICO<VM, I> : IObject {
    fun call(vm: VM, instance: I)
}