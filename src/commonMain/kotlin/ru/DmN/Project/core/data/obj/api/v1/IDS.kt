package ru.DmN.Project.core.data.obj.api.v1

import ru.DmN.Project.core.obj.api.v0.IObject

/**
 * Defines Storage
 */
interface IDS<T : IObject> : Iterable<T> {
    // Size
    val size: Int
    // Adding
    fun add(obj: T)
    // Getting
    operator fun get(name: String): T?
    // Setting
    operator fun set(obj: T, name: String)
    // Removing
    fun remove(name: String): T?
    // As *Type*
    fun asArray(): Array<T>
    fun asList(): List<T>
    fun asArrayList(): ArrayList<T>
}