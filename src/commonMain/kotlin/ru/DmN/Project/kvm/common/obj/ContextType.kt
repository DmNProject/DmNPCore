package ru.DmN.Project.kvm.common.obj

import ru.DmN.Project.core.obj.ObjType

class ContextType : ObjType {
    companion object {
        val CONTEXT = ContextType()
        val MAIN_CONTEXT = ContextType()
        val FUNCTION_CONTEXT = ContextType()
    }
}