package ru.DmN.Project.kvm.common.obj.impl.types

import ru.DmN.Project.core.data.obj.impl.IDSImpl
import ru.DmN.Project.core.data.obj.impl.IESImpl
import ru.DmN.Project.core.obj.IVObject
import ru.DmN.Project.kvm.common.data.impl.IFSImpl
import ru.DmN.Project.kvm.common.obj.KawaiiType
import ru.DmN.Project.kvm.common.obj.api.KObject
import ru.DmN.Project.kvm.common.vm.DynamicVirtualMachine

class TKawaiiString(vm: DynamicVirtualMachine, override var value: Any?) : KObject("ru.DmN.Project.kvm.String", KawaiiType.OBJ, IDSImpl(), IFSImpl(), IESImpl(vm.tOBJECT)), IVObject