package ru.DmN.Project.kvm.common.obj.api

import ru.DmN.Project.core.data.api.IDS
import ru.DmN.Project.core.data.api.IES
import ru.DmN.Project.core.obj.IDO
import ru.DmN.Project.core.obj.IEO
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.obj.ObjType
import ru.DmN.Project.kvm.common.data.api.IFS

open class KObject (
    override inline val name: String,
    override inline val type: ObjType,
    override val defines: IDS<IObject>,
    override val functions: IFS,
    override val extends: IES<IObject>
) : IEO<IObject>, IDO<IObject>, IFunctionsContainer