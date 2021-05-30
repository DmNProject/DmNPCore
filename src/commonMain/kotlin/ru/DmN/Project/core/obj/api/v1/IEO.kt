package ru.DmN.Project.core.obj.api.v1

import ru.DmN.Project.core.data.obj.api.v1.IES
import ru.DmN.Project.core.data.obj.api.v0.DP
import ru.DmN.Project.core.obj.api.v0.IObject

/**
 * Extendable Object
 */
interface IEO<T : IObject> : IObject, DP {
    val extends: IES<T>
}