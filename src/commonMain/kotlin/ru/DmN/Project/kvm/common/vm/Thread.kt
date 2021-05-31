package ru.DmN.Project.kvm.common.vm

import ru.DmN.Project.core.data.obj.impl.IDSImpl
import ru.DmN.Project.core.data.obj.impl.IESImpl
import ru.DmN.Project.kvm.common.data.impl.IFSImpl
import ru.DmN.Project.kvm.common.obj.KawaiiType
import ru.DmN.Project.kvm.common.obj.api.KObject

class Thread(name: String) : KObject(name, KawaiiType.OBJ, IDSImpl(), IFSImpl(), IESImpl()) {
    val callStack = CallStack()
}