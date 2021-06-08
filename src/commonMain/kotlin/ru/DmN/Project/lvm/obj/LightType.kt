package ru.DmN.Project.lvm.obj

import ru.DmN.Project.core.obj.ObjType

class LightType : ObjType {
    companion object {
        val VAR     = LightType()
        val FUN     = LightType()

        val INF     = LightType()
        val OBJ     = LightType()
        val OBJ_VAR = LightType()

        val SPEC    = LightType()
        val VM      = LightType()
    }
}