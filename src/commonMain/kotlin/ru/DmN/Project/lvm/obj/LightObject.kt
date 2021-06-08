package ru.DmN.Project.lvm.obj

import ru.DmN.Project.core.data.api.IDS
import ru.DmN.Project.core.data.api.IES
import ru.DmN.Project.core.data.impl.IDSImpl
import ru.DmN.Project.core.data.impl.IESImpl
import ru.DmN.Project.core.obj.IDO
import ru.DmN.Project.core.obj.IEO
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.obj.ObjType
import ru.DmN.Project.lvm.data.FunctionStorage

open class LightObject (
    override inline val name: String,
    override inline val type: ObjType,
    override val defines: IDS<IObject> = IDSImpl(),
    val functions: FunctionStorage = FunctionStorage(),
    override val extends: IES<LightObject> = IESImpl()
) : IEO<LightObject>, IDO<IObject>