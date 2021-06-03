package ru.DmN.Project.kvm.common.obj.api

import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.obj.ObjType
import ru.DmN.Project.kvm.common.obj.KawaiiType

abstract class Function : IFunction {
    override val type: ObjType = KawaiiType.VM
    override val code: IntArray? = null
    override val args: Iterable<IObject> = object : Iterable<IObject> {
        override fun iterator(): Iterator<IObject> = object : Iterator<IObject> {
            override fun hasNext(): Boolean = false
            override fun next(): IObject = throw Exception()
        }
    }
}