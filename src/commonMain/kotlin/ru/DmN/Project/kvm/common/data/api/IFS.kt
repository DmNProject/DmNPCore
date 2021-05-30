package ru.DmN.Project.kvm.common.data.api

import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.obj.ICO
import ru.DmN.Project.kvm.common.obj.api.IFunction

interface IFS<VM, I> {
    // Size
    val size: Int
    // Adding
    fun add(obj: IFunction<VM, I>)
    // Getting
    operator fun get(name: String, args: Iterable<IObject>): IFunction<VM, I>?
    // Removing
    fun remove(name: String): IFunction<VM, I>?
    // As *Type*
    fun asArray(): Array<IFunction<VM, I>>
    fun asList(): List<IFunction<VM, I>>
    fun asArrayList(): ArrayList<IFunction<VM, I>>
}