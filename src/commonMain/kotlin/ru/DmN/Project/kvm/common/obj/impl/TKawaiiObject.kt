package ru.DmN.Project.kvm.common.obj.impl

import ru.DmN.Project.core.data.obj.api.IDS
import ru.DmN.Project.core.data.obj.impl.IDSImpl
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.obj.IDO
import ru.DmN.Project.core.obj.ObjType
import ru.DmN.Project.kvm.common.data.api.IFS
import ru.DmN.Project.kvm.common.data.impl.IFSImpl
import ru.DmN.Project.kvm.common.obj.KawaiiType
import ru.DmN.Project.kvm.common.obj.api.IFunction
import ru.DmN.Project.kvm.common.obj.api.IFunctionsContainer
import ru.DmN.Project.kvm.common.vm.Call
import ru.DmN.Project.kvm.common.vm.DynamicVirtualMachine

class TKawaiiObject : IDO<IObject>, IFunctionsContainer<TKawaiiObject> {
    override val name: String
        get() = "ru.DmN.Project.kvm.Object"
    override val type: KawaiiType
        get() = KawaiiType.OBJ

    override val defines: IDS<IObject> = IDSImpl()
    override val functions: IFS<TKawaiiObject> = IFSImpl()

    init {
        functions.add(object : Function<TKawaiiObject>() {
            override val name: String = "toString"
            override val args: Iterable<IObject> = arrayListOf<IObject>().iterator() as Iterable<IObject>

            override fun call(call: Call) {
                TODO("Not yet implemented")
            }
        })
    }
}