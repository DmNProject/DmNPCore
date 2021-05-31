package ru.DmN.Project.kvm.common.vm

import ru.DmN.Project.core.data.obj.api.IDS
import ru.DmN.Project.core.data.obj.api.IES
import ru.DmN.Project.core.obj.IDO
import ru.DmN.Project.core.obj.IEO
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.obj.ObjType
import ru.DmN.Project.core.vm.IVirtualMachine
import ru.DmN.Project.kvm.common.data.api.IFS
import ru.DmN.Project.kvm.common.obj.KawaiiType
import ru.DmN.Project.kvm.common.obj.api.IFunctionsContainer
import ru.DmN.Project.kvm.common.obj.impl.SpecValueObject
import ru.DmN.Project.kvm.common.utils.getUndefined

open class DynamicVirtualMachine(
    override val defines: IDS<IObject>,
    override val functions: IFS<DynamicVirtualMachine, IObject>,
    override val extends: IES<IObject>,
    override val name: String = "DynamicVirtualMachine"
) : IVirtualMachine<ByteArray>, IEO<IObject>, IDO<IObject>, IFunctionsContainer<DynamicVirtualMachine, IObject> {
    override val type: ObjType = KawaiiType.VM

    override fun init() {
        defines.add(SpecValueObject("null", null))
        defines.add(SpecValueObject("undefined", getUndefined()))
    }

    override fun eval(code: ByteArray) {
        TODO("Not yet implemented")
    }
}