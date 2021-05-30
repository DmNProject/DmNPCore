package ru.DmN.Project.core.data.obj.api

import ru.DmN.Project.core.obj.IObject

/**
 * Extends Storage
 */
interface IES<T : IObject> : Iterable<T> {
    // Fields
    val size: Int
    // Adding
    fun add(obj: T)
    // Getting
    operator fun get(name: String): T?
    // Removing
    fun remove(name: String): T?
    // As *Type*
    fun asArray(): Array<T>
    fun asList(): List<T>
    fun asArrayList(): ArrayList<T>
}