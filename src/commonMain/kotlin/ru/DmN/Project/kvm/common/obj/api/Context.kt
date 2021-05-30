package ru.DmN.Project.kvm.common.obj.api

import ru.DmN.Project.core.data.obj.api.v1.IDS
import ru.DmN.Project.core.data.obj.impl.v1.IDSImpl
import ru.DmN.Project.core.obj.api.v0.IObject
import ru.DmN.Project.core.obj.api.v0.ObjType
import ru.DmN.Project.core.obj.api.v1.ICO
import ru.DmN.Project.core.obj.api.v1.IDO
import ru.DmN.Project.core.obj.api.v1.IEO
import ru.DmN.Project.kvm.common.data.api.IFS
import ru.DmN.Project.kvm.common.data.impl.IFSImpl
import ru.DmN.Project.kvm.common.obj.ContextType
import ru.DmN.Project.kvm.common.obj.impl.context.FunctionContext
import ru.DmN.Project.kvm.common.vm.DynamicVirtualMachine

abstract class Context : IEO<IObject>, IDO<IObject>, IFunctionsContainer<DynamicVirtualMachine, FunctionContext> {
    override val type: ObjType
        get() = ContextType.CONTEXT

    override val defines: IDS<IObject> = IDSImpl()
    override val functions: IFS<DynamicVirtualMachine, FunctionContext> = IFSImpl()
}