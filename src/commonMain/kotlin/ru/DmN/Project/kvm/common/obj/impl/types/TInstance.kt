package ru.DmN.Project.kvm.common.obj.impl.types

import ru.DmN.Project.core.data.obj.api.IES
import ru.DmN.Project.core.obj.IEO
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.obj.IVObject
import ru.DmN.Project.core.obj.ObjType

class TInstance(override val name: String, override val type: ObjType, override var value: Any?, override val extends: IES<IObject>) : IVObject, IEO<IObject>