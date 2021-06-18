//package ru.DmN.Project.lvm.obj
//
//import ru.DmN.Project.core.data.api.IDS
//import ru.DmN.Project.core.data.impl.IDSImpl
//import ru.DmN.Project.core.obj.IDO
//import ru.DmN.Project.kvm.common.data.api.IFS
//import ru.DmN.Project.kvm.common.data.impl.IFSImpl
//import ru.DmN.Project.lvm.data.FunctionStorage
//import ru.DmN.Project.lvm.vm.LightVirtualMachine
//
//open class LightObject (
//    override inline val name: String,
//    override inline val type: LightType,
//    var extend: LightObject? = null,
//    val implementations: ArrayList<LightObject> = ArrayList(),
//    override val defines: IDS<LightObject> = IDSImpl(),
//    val functions: IFS<ByteArray, LightVirtualMachine, LightObject> = IFSImpl(),
//) : IDO<LightObject>