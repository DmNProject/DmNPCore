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
import ru.DmN.Project.kvm.common.vm.api.IVM

open class KObject<C, V : IVM<C, V, O>, O : IObject> (
    override inline val name: String,
    override inline val type: ObjType,
    override val defines: IDS<O> = IDSImpl(),
    override val functions: IFS<C, V, O> = IFSImpl(),
    override val extends: IES<O> = IESImpl()
) : IEO<O>, IDO<O>, IFunctionsContainer<C, V, O>