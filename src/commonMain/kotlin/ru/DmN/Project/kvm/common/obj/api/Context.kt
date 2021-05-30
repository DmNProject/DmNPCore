package ru.DmN.Project.kvm.common.obj.api

import ru.DmN.Project.core.data.obj.api.IDS
import ru.DmN.Project.core.data.obj.impl.IDSImpl
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.obj.ObjType
import ru.DmN.Project.core.obj.IDO
import ru.DmN.Project.core.obj.IEO
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