package ru.DmN.Project.core.obj

import ru.DmN.Project.core.data.api.IES

/**
 * Extendable Object
 */
interface IEO<T : IObject> : IObject {
    val extends: IES<T>
}