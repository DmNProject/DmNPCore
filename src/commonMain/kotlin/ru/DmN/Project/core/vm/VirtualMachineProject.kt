package ru.DmN.Project.core.vm

import ru.DmN.Project.core.obj.api.v0.IObject
import ru.DmN.Project.core.obj.api.v1.*

abstract class VirtualMachineProject<O1, O2, O3, O4> {
    abstract val name: String
    abstract val version: String
    abstract val authors: ArrayList<String>
    abstract val license: String

    abstract fun toIObject(obj: O1): IObject?
    abstract fun toIVObject(obj: O2): IVObject?
    abstract fun toIEP(obj: O3): IEO<*>?
    abstract fun toIFMP(obj: O4): IDO<*>?

    abstract fun ofIObject(obj: IObject): O1?
    abstract fun ofIVObject(obj: IVObject): O2?
    abstract fun ofIEP(obj: IEO<*>): O3?
    abstract fun ofIFMP(obj: IDO<*>): O4?
}