package ru.DmN.Project.kvm.common.obj

import ru.DmN.Project.core.obj.api.v0.ObjType

class ContextType : ObjType {
    companion object {
        val CONTEXT = ContextType()
        val MAIN_CONTEXT = ContextType()
        val FUNCTION_CONTEXT = ContextType()
    }
}