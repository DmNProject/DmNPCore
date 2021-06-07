package ru.DmN.Project.kvm.common.obj.impl.types

import ru.DmN.Project.core.data.api.IDS
import ru.DmN.Project.core.data.impl.IDSImpl
import ru.DmN.Project.core.data.impl.IESImpl
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.obj.IDO
import ru.DmN.Project.kvm.common.data.api.IFS
import ru.DmN.Project.kvm.common.data.impl.IFSImpl
import ru.DmN.Project.kvm.common.obj.KawaiiType
import ru.DmN.Project.kvm.common.obj.api.Function
import ru.DmN.Project.kvm.common.obj.api.IFunctionsContainer
import ru.DmN.Project.kvm.common.utils.Utils
import ru.DmN.Project.kvm.common.vm.Call
import ru.DmN.Project.kvm.common.vm.Thread

@Suppress("OVERRIDE_BY_INLINE")
class TKawaiiObject : IDO<IObject>, IFunctionsContainer {
    override inline val name: String get() = "ru.DmN.Project.kvm.Object"
    override inline val type: KawaiiType get() = KawaiiType.OBJ
    override val defines: IDS<IObject> = IDSImpl()
    override val functions: IFS = IFSImpl()

    init {
        functions.add(object : Function() {
            override inline val name: String get() = "toString"
            override val args: List<IObject> = arrayListOf()

            override fun call(call: Call) {
                call.result = Utils.createString(call.vm, "_result_", this@TKawaiiObject.toString())!!
            }
        })
    }
}