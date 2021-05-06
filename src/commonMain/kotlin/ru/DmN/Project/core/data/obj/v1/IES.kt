package ru.DmN.Project.core.data.obj.v1

import ru.DmN.Project.core.obj.api.v0.IObject

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
    // Setting
    operator fun set(obj: T, name: String)
    // Removing
    fun remove(name: String): T?
}