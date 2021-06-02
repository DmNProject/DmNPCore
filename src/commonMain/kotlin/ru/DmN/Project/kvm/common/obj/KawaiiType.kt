package ru.DmN.Project.kvm.common.obj

import ru.DmN.Project.core.obj.ObjType

class KawaiiType : ObjType {
    companion object {
        /**
         * VirtualMachine
         */
        val VM get() = KawaiiType()

        /**
         * Special
         */
        val SPC get() = KawaiiType()

        /**
         * Variable
         */
        val VAR get() = KawaiiType()

        /**
         * Function
         */
        val FUN get() = KawaiiType()

        /**
         * Object
         */
        val OBJ get() = KawaiiType()
    }
}