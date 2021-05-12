package ru.DmN.Project.core.obj.api.v0

/**
 * Level 0 object interface
 */
interface IObject {
    /**
     * Object name
     */
    val name: String

    /**
     * Object type
     */
    val type: ObjType
}