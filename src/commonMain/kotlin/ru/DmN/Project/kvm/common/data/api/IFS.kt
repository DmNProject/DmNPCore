package ru.DmN.Project.kvm.common.data.api

import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.obj.ICO

interface IFS<VM, I> {
    // Size
    val size: Int
    // Adding
    fun add(obj: ICO<VM, I>)
    // Getting
    operator fun get(name: String, args: Iterable<IObject>): ICO<VM, I>?
    // Removing
    fun remove(name: String): ICO<VM, I>?
    // As *Type*
    fun asArray(): Array<ICO<VM, I>>
    fun asList(): List<ICO<VM, I>>
    fun asArrayList(): ArrayList<ICO<VM, I>>
}