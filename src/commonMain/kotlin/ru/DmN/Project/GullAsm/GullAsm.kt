package ru.DmN.Project.GullAsm

import ru.DmN.Project.core.obj.api.v0.IObject
import ru.DmN.Project.core.obj.api.v1.IDO
import ru.DmN.Project.core.obj.api.v1.IEO
import ru.DmN.Project.core.obj.api.v1.IVObject
import ru.DmN.Project.core.vm.VirtualMachineProject

object GullAsm : VirtualMachineProject<IObject, IVObject, IEO<*>, IDO<*>>() {
    override val name: String
        get() = "GullAsm"
    override val version: String
        get() = "1.0.0"
    override val authors: ArrayList<String>
        get() = arrayListOf("DomamaN202")
    override val license: String
        get() = "MIT"

    override fun toIObject(obj: IObject): IObject = obj
    override fun toIVObject(obj: IVObject): IVObject = obj
    override fun toIEP(obj: IEO<*>): IEO<*> = obj
    override fun toIFMP(obj: IDO<*>): IDO<*> = obj

    override fun ofIObject(obj: IObject): IObject = obj
    override fun ofIVObject(obj: IVObject): IVObject = obj
    override fun ofIEP(obj: IEO<*>): IEO<*> = obj
    override fun ofIFMP(obj: IDO<*>): IDO<*> = obj
}