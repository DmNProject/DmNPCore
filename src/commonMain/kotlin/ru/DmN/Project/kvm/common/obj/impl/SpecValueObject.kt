package ru.DmN.Project.kvm.common.obj.impl

import ru.DmN.Project.core.obj.IVObject
import ru.DmN.Project.core.obj.ObjType
import ru.DmN.Project.kvm.common.obj.KawaiiType

class SpecValueObject(override val name: String, override var value: Any?) : IVObject {
    override val type: ObjType = KawaiiType.SPC
}