package ru.DmN.Project.core.data.api

import ru.DmN.Project.core.obj.IObject

/**
 * Extends Storage
 */
interface IES<T : IObject> : Iterable<T> {
    /**
     * Return size
     */
    val size: Int

    /**
     * Adds an object
     * @param obj Object to add
     */
    fun add(obj: T)

    /**
     * Getting object with name
     * @param name Name of object
     */
    operator fun get(name: String): T?

    /**
     * Removing object with name
     * @param name Name of object
     */
    fun remove(name: String): T?


    /**
     * Convert THIS to Array
     */
    fun asArray(): Array<T>

    /**
     * Convert THIS to List
     */
    fun asList(): List<T>

    /**
     * Convert THIS to ArrayList
     */
    fun asArrayList(): ArrayList<T>
}