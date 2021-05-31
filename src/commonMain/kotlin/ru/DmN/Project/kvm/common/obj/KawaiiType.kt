package ru.DmN.Project.kvm.common.obj

import ru.DmN.Project.core.obj.ObjType

class KawaiiType : ObjType {
    companion object {
        /**
         * VirtualMachine
         */
        val VM = KawaiiType()

        /**
         * Special
         */
        val SPC = KawaiiType()

        /**
         * Variable
         */
        val VAR = KawaiiType()

        /**
         * Function
         */
        val FUN = KawaiiType()

        /**
         * Object
         */
        val OBJ = KawaiiType()
    }
}