package ru.DmN.Project.core.obj

import ru.DmN.Project.core.data.api.IDS

/**
 * Defines Object
 */
interface IDO<T : IObject> : IObject {
    val defines: IDS<T>
}