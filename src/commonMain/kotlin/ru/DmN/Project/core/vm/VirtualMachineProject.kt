package ru.DmN.Project.core.vm

import ru.DmN.Project.core.obj.api.v1.IEP
import ru.DmN.Project.core.obj.api.v1.IDP
import ru.DmN.Project.core.obj.api.v0.IObject
import ru.DmN.Project.core.obj.api.v1.IVObject

abstract class VirtualMachineProject {
    abstract val name: String
    abstract val version: String
    abstract val authors: ArrayList<String>
    abstract val license: String

    abstract fun <T> toIObject(obj: T?): IObject?
    abstract fun <T> toIVObject(obj: T?): IVObject?
    abstract fun <T> toIEP(obj: T?): IEP<*>?
    abstract fun <T> toIFMP(obj: T?): IDP<*>?

    abstract fun <T> ofIObject(obj: IObject?): T?
    abstract fun <T> ofIVObject(obj: IVObject?): T?
    abstract fun <T> ofIEP(obj: IEP<*>?): T?
    abstract fun <T> ofIFMP(obj: IDP<*>?): T?
}