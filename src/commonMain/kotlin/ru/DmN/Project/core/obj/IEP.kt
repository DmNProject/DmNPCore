package ru.DmN.Project.core.obj

import ru.DmN.Project.core.data.obj.IES

/**
 * Extends Provider
 */
interface IEP<T : IDPO> : DP {
    val extends: IES<T>
}