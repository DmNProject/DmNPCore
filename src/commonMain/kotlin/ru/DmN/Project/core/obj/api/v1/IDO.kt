package ru.DmN.Project.core.obj.api.v1

import ru.DmN.Project.core.data.obj.api.v1.IDS
import ru.DmN.Project.core.obj.api.v0.IObject
import ru.DmN.Project.core.data.obj.api.v0.DP

/**
 * Defines Object
 */
interface IDO<T : IObject> : IObject, DP {
    val defines: IDS<T>
}