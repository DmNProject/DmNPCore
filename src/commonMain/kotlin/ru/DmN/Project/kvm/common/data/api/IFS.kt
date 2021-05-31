package ru.DmN.Project.kvm.common.data.api

import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.obj.ICO
import ru.DmN.Project.kvm.common.obj.api.IFunction
import ru.DmN.Project.kvm.common.obj.api.KObject
import ru.DmN.Project.kvm.common.obj.impl.Function

interface IFS<I : IObject> {
    // Size
    val size: Int
    // Adding
    fun add(obj: Function<I>)
    // Getting
    operator fun get(name: String, args: Iterable<IObject>): IFunction<I>?
    // Removing
    fun remove(name: String): IFunction<I>?
    // As *Type*
    fun asArray(): Array<IFunction<I>>
    fun asList(): List<IFunction<I>>
    fun asArrayList(): ArrayList<IFunction<I>>
}