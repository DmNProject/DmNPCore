package ru.DmN.Project.lvm

import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.vm.VirtualMachineProject

object LightVM : VirtualMachineProject() {
    override val name: String
        get() = "DmNPLVM"
    override val version: String
        get() = "1.0.0"
    override val authors: ArrayList<String>
        get() = arrayListOf("DomamaN202")
    override val license: String
        get() = "MIT"
}