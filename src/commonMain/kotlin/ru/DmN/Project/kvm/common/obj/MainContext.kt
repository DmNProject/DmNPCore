package ru.DmN.Project.kvm.common.obj

import ru.DmN.Project.core.data.obj.api.v1.IES
import ru.DmN.Project.core.data.obj.impl.v1.IESImpl
import ru.DmN.Project.core.obj.api.v0.IObject

class MainContext(override val extends: IES<IObject> = IESImpl()) : Context() {
    override val name: String = "MainContext"
}