package ru.DmN.Project.kvm.common.obj.api

import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.obj.ObjType
import ru.DmN.Project.kvm.common.obj.KawaiiType
import ru.DmN.Project.kvm.common.vm.api.IVM
import ru.DmN.Project.kvm.common.vm.api.KVM

abstract class Function<C, V : IVM<C, V, O>, O : IObject> : IFunction<C, V, O> {
    override val type: ObjType = KawaiiType.FUN
    override val code: C? = null
    override val args: List<IObject> = emptyList()
}