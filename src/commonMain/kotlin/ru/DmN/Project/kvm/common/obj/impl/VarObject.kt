package ru.DmN.Project.kvm.common.obj.impl

import ru.DmN.Project.core.obj.IVObject
import ru.DmN.Project.core.obj.ObjType
import ru.DmN.Project.kvm.common.obj.KawaiiType

@Suppress("OVERRIDE_BY_INLINE")
class VarObject(override inline val name: String, override var value: Any?) : IVObject {
    override inline val type: ObjType get() = KawaiiType.VAR
}