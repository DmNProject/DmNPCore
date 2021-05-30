package ru.DmN.Project.core.obj

import ru.DmN.Project.core.data.obj.api.IDS

/**
 * Defines Object
 */
interface IDO<T : IObject> : IObject {
    val defines: IDS<T>
}