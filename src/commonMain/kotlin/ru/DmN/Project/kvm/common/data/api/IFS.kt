package ru.DmN.Project.kvm.common.data.api

import ru.DmN.Project.core.obj.api.v1.ICO

interface IFS<VM, O> {
    // Size
    val size: Int
    // Adding
    fun add(obj: ICO<VM, O>)
    // Getting
    operator fun get(name: String): ICO<VM, O>?
    // Setting
    operator fun set(obj: ICO<VM, O>, name: String)
    // Removing
    fun remove(name: String): ICO<VM, O>?
    // As *Type*
    fun asArray(): Array<ICO<VM, O>>
    fun asList(): List<ICO<VM, O>>
    fun asArrayList(): ArrayList<ICO<VM, O>>
}