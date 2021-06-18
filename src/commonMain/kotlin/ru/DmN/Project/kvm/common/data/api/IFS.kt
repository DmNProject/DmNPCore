package ru.DmN.Project.kvm.common.data.api

import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.util.AtomicInt
import ru.DmN.Project.kvm.common.obj.api.IFunction
import ru.DmN.Project.kvm.common.obj.api.Function
import ru.DmN.Project.kvm.common.vm.api.IVM
import ru.DmN.Project.kvm.common.vm.api.KVM

interface IFS<C, V : IVM<C, V, O>, O : IObject> {
    // Size
    val size: Int
    // Adding
    fun add(obj: Function<C, V, O>)
    // Getting
    operator fun get(name: String, args: List<IObject>?, i: AtomicInt = AtomicInt(Int.MAX_VALUE)): IFunction<C, V, O>?
    // Removing
    fun remove(name: String): IFunction<C, V, O>?
    // As *Type*
    fun asArray(): Array<IFunction<C, V, O>>
    fun asList(): List<IFunction<C, V, O>>
    fun asArrayList(): ArrayList<IFunction<C, V, O>>
}