package ru.DmN.Project.kvm.common.vm.api

import ru.DmN.Project.core.obj.IObject

/**
 * Kawaii Types Storage Virtual Machine
 */
interface IKTSVM<C, V : IKTSVM<C, V, O>, O : IObject> : IVM<C, V, O> {
    val tNULL: O
    val tUNDEFINED: O
    val tOBJECT: O
    val tSTRING: O
    val tNUMBER: O
}