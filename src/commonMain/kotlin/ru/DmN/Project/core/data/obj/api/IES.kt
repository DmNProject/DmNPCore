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
    operator fun get(index: Int): T?
    operator fun get(name: String): T?
    // Setting
    operator fun set(obj: T, index: Int)
    operator fun set(obj: T, name: String)
    // Removing
    fun remove(name: String): T?
    // As *Type*
    fun asArray(): Array<T>
    fun asList(): List<T>
    fun asArrayList(): ArrayList<T>
}