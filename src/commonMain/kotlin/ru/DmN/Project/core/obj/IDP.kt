package ru.DmN.Project.core.obj

import ru.DmN.Project.core.data.obj.IDS

/**
 * Defs Provider
 */
interface IDP<T : IObject> : DP {
    val defs: IDS<T, Any>
}