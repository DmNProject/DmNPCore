package ru.DmN.Project.kvm.common.obj

import ru.DmN.Project.core.obj.api.v0.ObjType

class KawaiiType : ObjType {
    companion object {
        val VAR = KawaiiType()
        val FUN = KawaiiType()
        val OBJ = KawaiiType()
    }
}