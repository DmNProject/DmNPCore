package ru.DmN.Project.kvm.common.obj.api

import ru.DmN.Project.core.data.api.IDS
import ru.DmN.Project.core.data.api.IES
import ru.DmN.Project.core.data.impl.IDSImpl
import ru.DmN.Project.core.data.impl.IESImpl
import ru.DmN.Project.core.obj.IDO
import ru.DmN.Project.core.obj.IEO
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.obj.ObjType
import ru.DmN.Project.kvm.common.data.api.IFS
import ru.DmN.Project.kvm.common.data.impl.IFSImpl

open class KObject (
    override inline val name: String,
    override inline val type: ObjType,
    override val defines: IDS<IObject> = IDSImpl(),
    override val functions: IFS = IFSImpl(),
    override val extends: IES<IObject> = IESImpl()
) : IEO<IObject>, IDO<IObject>, IFunctionsContainer