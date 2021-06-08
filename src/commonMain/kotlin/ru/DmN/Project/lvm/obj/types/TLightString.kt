package ru.DmN.Project.lvm.obj.types

import ru.DmN.Project.core.data.impl.IESImpl
import ru.DmN.Project.kvm.common.obj.KawaiiType
import ru.DmN.Project.lvm.obj.LightObject

class TLightString(parent: LightObject) : LightObject("ru.DmN.Project.lvm.String", KawaiiType.OBJ, extends = IESImpl(parent))