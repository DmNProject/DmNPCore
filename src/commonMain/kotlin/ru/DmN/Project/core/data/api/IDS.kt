package ru.DmN.Project.core.data.api

import ru.DmN.Project.core.obj.IObject

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
    // Removing
    fun remove(name: String): T?
    // As *Type*
    fun asArray(): Array<T>
    fun asList(): List<T>
    fun asArrayList(): ArrayList<T>
}