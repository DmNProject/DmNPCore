package ru.DmN.Project.kvm.common.obj.impl

import ru.DmN.Project.core.data.obj.api.v1.IDS
import ru.DmN.Project.core.data.obj.impl.v1.IDSImpl
import ru.DmN.Project.core.obj.api.v0.IObject
import ru.DmN.Project.core.obj.api.v1.IDO
import ru.DmN.Project.kvm.common.data.api.IFS
import ru.DmN.Project.kvm.common.data.impl.IFSImpl
import ru.DmN.Project.kvm.common.obj.KawaiiType
import ru.DmN.Project.kvm.common.obj.api.IFunctionsContainer
import ru.DmN.Project.kvm.common.vm.DynamicVirtualMachine

class TKawaiiObject : IDO<IObject>, IFunctionsContainer<DynamicVirtualMachine, TKawaiiObject> {
    override val name: String
        get() = "ru.DmN.Project.kvm.Object"
    override val type: KawaiiType
        get() = KawaiiType.OBJ

    override val defines: IDS<IObject> = IDSImpl()
    override val functions: IFS<DynamicVirtualMachine, TKawaiiObject> = IFSImpl()

    init {

    }
}