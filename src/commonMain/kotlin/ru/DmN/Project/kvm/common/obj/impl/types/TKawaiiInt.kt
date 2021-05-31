package ru.DmN.Project.kvm.common.obj.impl.types

import ru.DmN.Project.core.data.obj.impl.IDSImpl
import ru.DmN.Project.core.data.obj.impl.IESImpl
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.kvm.common.data.impl.IFSImpl
import ru.DmN.Project.kvm.common.obj.KawaiiType
import ru.DmN.Project.kvm.common.obj.api.KObject

class TKawaiiInt(parent: IObject) : KObject("ru.DmN.Project.kvm.Int", KawaiiType.OBJ, IDSImpl(), IFSImpl(), IESImpl(parent))