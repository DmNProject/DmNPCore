package ru.DmN.Project.core.data.obj

import ru.DmN.Project.core.obj.IDPO

/**
 * Extends Storage
 */
interface IES<T : IDPO> : Iterable<T> {
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