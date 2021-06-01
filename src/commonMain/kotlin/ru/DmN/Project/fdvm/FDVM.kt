package ru.DmN.Project.fdvm

import ru.DmN.Project.core.vm.VirtualMachineProject

object FDVM : VirtualMachineProject<Unit, Unit, Unit, Unit>() {
    override val name: String
        get() = "Fast Disabled Virtual Machine"
    override val version: String
        get() = "1.0.0"
    override val authors: ArrayList<String>
        get() = arrayListOf("DomamaN202")
    override val license: String
        get() = "MIT"

}