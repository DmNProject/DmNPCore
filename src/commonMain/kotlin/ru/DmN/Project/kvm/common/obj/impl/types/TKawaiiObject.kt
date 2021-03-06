package ru.DmN.Project.kvm.common.obj.impl.types

import ru.DmN.Project.core.data.api.IDS
import ru.DmN.Project.core.data.impl.IDSImpl
import ru.DmN.Project.core.obj.IDO
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.kvm.common.data.api.IFS
import ru.DmN.Project.kvm.common.data.impl.IFSImpl
import ru.DmN.Project.kvm.common.obj.KawaiiType
import ru.DmN.Project.kvm.common.obj.api.Function
import ru.DmN.Project.kvm.common.obj.api.IFunctionsContainer
import ru.DmN.Project.kvm.common.utils.Utils
import ru.DmN.Project.kvm.common.vm.Call
import ru.DmN.Project.kvm.common.vm.api.IKTSVM

@Suppress("OVERRIDE_BY_INLINE", "UNCHECKED_CAST")
class TKawaiiObject<C, V : IKTSVM<C, V, O>, O : IObject> : IDO<IObject>, IFunctionsContainer<C, V, O> {
    override inline val name: String get() = "ru.DmN.Project.kvm.Object"
    override inline val type: KawaiiType get() = KawaiiType.OBJ
    override val defines: IDS<IObject> = IDSImpl()
    override val functions: IFS<C, V, O> = IFSImpl()

    init {
        functions.add(object : Function<C, V, O>() {
            override inline val name: String get() = "toString"
            override val args: List<IObject> = arrayListOf()

            override fun call(call: Call<C, V, O>) {
                call.result = Utils.createString(call.vm, "_result_", this@TKawaiiObject.toString()) as O
            }
        })
    }
}