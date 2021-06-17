package ru.DmN.Project.core.vm

import ru.DmN.Project.core.obj.IDO
import ru.DmN.Project.core.obj.IEO
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.obj.IVObject

/**
 * Template for virtual machine projects
 */
abstract class VirtualMachineProject {
    /**
     * Project name
     */
    abstract val name: String

    /**
     * Project version
     */
    abstract val version: String

    /**
     * Authors of the project
     */
    abstract val authors: ArrayList<String>

    /**
     * Project license
     */
    abstract val license: String
}