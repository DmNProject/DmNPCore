package ru.DmN.Project.kvm.common.obj.impl.types

import ru.DmN.Project.core.data.obj.api.IDS
import ru.DmN.Project.core.data.obj.impl.IDSImpl
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.obj.IDO
import ru.DmN.Project.kvm.common.data.api.IFS
import ru.DmN.Project.kvm.common.data.impl.IFSImpl
import ru.DmN.Project.kvm.common.obj.KawaiiType
import ru.DmN.Project.kvm.common.obj.api.Function
import ru.DmN.Project.kvm.common.obj.api.IFunctionsContainer
import ru.DmN.Project.kvm.common.vm.Call

class TKawaiiObject : IDO<IObject>, IFunctionsContainer {
    override val name: String = "ru.DmN.Project.kvm.Object"
    override val type: KawaiiType = KawaiiType.OBJ
    override val defines: IDS<IObject> = IDSImpl()
    override val functions: IFS = IFSImpl()

    init {
        functions.add(object : Function() {
            override val name: String = "toString"
            override val args: Iterable<IObject> = arrayListOf<IObject>().iterator() as Iterable<IObject>

            override fun call(call: Call) {
                TODO("Not yet implemented")
            }
        })
    }
}