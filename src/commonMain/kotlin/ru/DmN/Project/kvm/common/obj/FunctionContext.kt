package ru.DmN.Project.kvm.common.obj

import ru.DmN.Project.core.data.obj.api.v1.IES
import ru.DmN.Project.core.data.obj.impl.v1.IESImpl
import ru.DmN.Project.core.obj.api.v0.IObject
import ru.DmN.Project.core.obj.api.v0.ObjType

class FunctionContext(override val name: String, override val extends: IES<IObject> = IESImpl()) : Context() {
    override val type: ObjType
        get() = ContextType.FUNCTION_CONTEXT
}