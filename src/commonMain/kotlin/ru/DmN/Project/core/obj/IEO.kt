package ru.DmN.Project.core.obj

import ru.DmN.Project.core.data.api.IES

/**
 * Extendable Object
 */
interface IEO<T : IObject> : IObject {
    val extends: IES<T>

    /**
     * Auto Extend Equals Flag
     */
    val aEEF: Boolean get() = false

    /**
     * Extend Equals
     */
    fun eE(o: IObject): Boolean = false
}