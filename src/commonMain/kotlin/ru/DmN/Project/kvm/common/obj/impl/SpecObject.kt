package ru.DmN.Project.kvm.common.obj.impl

import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.obj.ObjType
import ru.DmN.Project.kvm.common.obj.KawaiiType

@Suppress("OVERRIDE_BY_INLINE")
class SpecObject(override inline val name: String) : IObject {
    override inline val type: ObjType get() = KawaiiType.SPC
}