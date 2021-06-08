package ru.DmN.Project.kvm.common.obj.api

import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.obj.ObjType
import ru.DmN.Project.kvm.common.obj.KawaiiType

abstract class Function : IFunction {
    override val type: ObjType = KawaiiType.FUN
    override val code: ByteArray? = null
    override val args: List<IObject> = emptyList()
}