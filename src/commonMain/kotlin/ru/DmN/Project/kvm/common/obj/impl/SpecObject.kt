package ru.DmN.Project.kvm.common.obj.impl

import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.obj.ObjType
import ru.DmN.Project.kvm.common.obj.KawaiiType

class SpecObject(override val name: String) : IObject {
    override val type: ObjType = KawaiiType.SPC
}