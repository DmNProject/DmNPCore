package ru.DmN.Project.kvm.common.obj.impl.context

import ru.DmN.Project.core.data.obj.api.IES
import ru.DmN.Project.core.data.obj.impl.IESImpl
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.obj.ObjType
import ru.DmN.Project.kvm.common.obj.ContextType
import ru.DmN.Project.kvm.common.obj.api.Context

open class FunctionContext(override val name: String, override val extends: IES<IObject> = IESImpl()) : Context() {
    override val type: ObjType = ContextType.FUNCTION_CONTEXT
}