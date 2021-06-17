package ru.DmN.Project.kvm

import ru.DmN.Project.core.vm.VirtualMachineProject

object KawaiiVM : VirtualMachineProject() {
    override val name: String
        get() = "DmNPKVM"
    override val version: String
        get() = "1.0.0"
    override val license: String
        get() = "Apache-2.0"
    override val authors: ArrayList<String>
        get() = arrayListOf("DomamaN202", "levkopo")
}