package ru.DmN.Project.kvm.common.obj.impl.types

import ru.DmN.Project.core.data.impl.IDSImpl
import ru.DmN.Project.core.data.impl.IESImpl
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.kvm.common.data.impl.IFSImpl
import ru.DmN.Project.kvm.common.obj.KawaiiType
import ru.DmN.Project.kvm.common.obj.api.KObject

class TKawaiiNumber(parent: IObject) : KObject("ru.DmN.Project.kvm.Number", KawaiiType.OBJ, IDSImpl(), IFSImpl(), IESImpl(parent)) {
    inline override val aEEF: Boolean get() = true
    override fun eE(o: IObject): Boolean = o.name == name || o.name == (extends as IESImpl<IObject>).data[0].name
}