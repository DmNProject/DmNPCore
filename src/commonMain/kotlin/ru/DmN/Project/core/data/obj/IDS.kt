package ru.DmN.Project.core.data.obj

import ru.DmN.Project.core.obj.IObject

/**
 * Defs Storage
 */
interface IDS<T : IObject, Args> : Iterable<T> {
    // Size
    val size: Int
    // Adding
    fun add(obj: T)
    // Getting
    operator fun get(name: String, args: Args): T?
    // Setting
    operator fun set(obj: T, name: String, args: Args)
    // Removing
    fun remove(name: String, args: Args): T?
    // As *Type*
    fun asArray(): Array<T>
    fun asList(): List<T>
    fun asArrayList(): ArrayList<T>
}