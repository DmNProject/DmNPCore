package ru.DmN.Project.kvm.common.vm

import ru.DmN.Project.core.data.impl.IDSImpl
import ru.DmN.Project.core.data.impl.IESImpl
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.kvm.common.data.impl.IFSImpl
import ru.DmN.Project.kvm.common.obj.KawaiiType
import ru.DmN.Project.kvm.common.obj.api.KObject
import ru.DmN.Project.kvm.common.vm.api.IVM

class Thread<C, V : IVM<C, V, O>, O : IObject>(name: String) : KObject<C, V, O>(name, KawaiiType.OBJ, IDSImpl(), IFSImpl(), IESImpl()) {
    val callStack = CallStack<C, V, O>()
    var stack: MutableList<IObject>? = null
}