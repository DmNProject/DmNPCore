package ru.DmN.Project.kvm.common.data.api

import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.kvm.common.obj.api.IFunction
import ru.DmN.Project.kvm.common.obj.api.Function

interface IFS {
    // Size
    val size: Int
    // Adding
    fun add(obj: Function)
    // Getting
    operator fun get(name: String, args: Iterable<IObject>?): IFunction?
    // Removing
    fun remove(name: String): IFunction?
    // As *Type*
    fun asArray(): Array<IFunction>
    fun asList(): List<IFunction>
    fun asArrayList(): ArrayList<IFunction>
}