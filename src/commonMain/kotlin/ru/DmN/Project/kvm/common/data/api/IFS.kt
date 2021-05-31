package ru.DmN.Project.kvm.common.data.api

import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.obj.ICO
import ru.DmN.Project.kvm.common.obj.api.IFunction

interface IFS<I> {
    // Size
    val size: Int
    // Adding
    fun add(obj: IFunction<I>)
    // Getting
    operator fun get(name: String, args: Iterable<IObject>): IFunction<I>?
    // Removing
    fun remove(name: String): IFunction<I>?
    // As *Type*
    fun asArray(): Array<IFunction<I>>
    fun asList(): List<IFunction<I>>
    fun asArrayList(): ArrayList<IFunction<I>>
}