package ru.DmN.Project.kvm.common.obj.impl.types

import ru.DmN.Project.core.data.impl.IDSImpl
import ru.DmN.Project.core.data.impl.IESImpl
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.kvm.common.data.impl.IFSImpl
import ru.DmN.Project.kvm.common.obj.KawaiiType
import ru.DmN.Project.kvm.common.obj.api.KObject
import ru.DmN.Project.kvm.common.vm.api.IKTSVM
import ru.DmN.Project.kvm.common.vm.api.KVM

class TKawaiiString<C, V : IKTSVM<C, V, O>, O : IObject>(parent: O) : KObject<C, V, O>("ru.DmN.Project.kvm.String", KawaiiType.OBJ, IDSImpl(), IFSImpl(), IESImpl(parent))