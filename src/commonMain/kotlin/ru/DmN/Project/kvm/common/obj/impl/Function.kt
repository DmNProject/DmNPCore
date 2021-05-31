package ru.DmN.Project.kvm.common.obj.impl

import ru.DmN.Project.core.obj.ObjType
import ru.DmN.Project.kvm.common.obj.KawaiiType
import ru.DmN.Project.kvm.common.obj.api.IFunction

abstract class Function<VM, I> : IFunction<VM, I> {
    override val type: ObjType = KawaiiType.VM
    override val code: ByteArray? = null
}