package ru.DmN.Project.kvm.common.obj.impl.types

import ru.DmN.Project.core.data.impl.IDSImpl
import ru.DmN.Project.core.data.impl.IESImpl
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.kvm.common.data.impl.IFSImpl
import ru.DmN.Project.kvm.common.obj.KawaiiType
import ru.DmN.Project.kvm.common.obj.api.KObject

class TKawaiiString(parent: IObject) : KObject("ru.DmN.Project.kvm.String", KawaiiType.OBJ, IDSImpl(), IFSImpl(), IESImpl(parent))