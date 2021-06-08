package ru.DmN.Project.lvm.vm

import ru.DmN.Project.core.data.impl.IDSImpl
import ru.DmN.Project.core.data.impl.IESImpl
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.kvm.common.data.impl.IFSImpl
import ru.DmN.Project.kvm.common.obj.KawaiiType
import ru.DmN.Project.kvm.common.obj.api.KObject

class Thread(name: String) : KObject(name, KawaiiType.OBJ, IDSImpl(), IFSImpl(), IESImpl()) {
    val callStack = CallStack()
    var stack: MutableList<IObject>? = null
}