package ru.DmN.Project.core.obj

import ru.DmN.Project.core.data.obj.IES

/**
 * Extends Provider
 */
interface IEP<T : IObject> : DP {
    val extends: IES<T>
}