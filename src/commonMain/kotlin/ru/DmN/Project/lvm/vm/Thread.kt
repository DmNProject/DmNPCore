//package ru.DmN.Project.lvm.vm
//
//import ru.DmN.Project.core.data.impl.IDSImpl
//import ru.DmN.Project.core.data.impl.IESImpl
//import ru.DmN.Project.kvm.common.data.impl.IFSImpl
//import ru.DmN.Project.kvm.common.obj.KawaiiType
//import ru.DmN.Project.kvm.common.obj.api.KObject
//import ru.DmN.Project.lvm.obj.LightObject
//
//class Thread(name: String) : KObject<ByteArray, LightVirtualMachine, LightObject>(name, KawaiiType.OBJ, IDSImpl(), IFSImpl(), IESImpl()) {
//    val callStack = CallStack()
//    var stack: MutableList<LightObject>? = null
//}