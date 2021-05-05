package ru.DmN.Project.core.obj.api.v1

import ru.DmN.Project.core.obj.api.v0.IObject

/**
 * Value Object
 */
interface IVObject : IObject {
    var value: Any?
}