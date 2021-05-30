package ru.DmN.Project.core.obj

/**
 * Callable Object
 */
interface ICO<VM, I> : IObject {
    fun call(vm: VM, instance: I)
}