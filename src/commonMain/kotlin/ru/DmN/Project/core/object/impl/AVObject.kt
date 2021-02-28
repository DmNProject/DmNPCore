package ru.DmN.Project.core.`object`.impl

import ru.DmN.Project.core.`object`.ObjType
import ru.DmN.Project.core.`object`.api.*
import ru.DmN.Project.core.data.api.IES
import ru.DmN.Project.core.data.api.IFMS

data class AVObject(
    override val extends: IES<IDPO>,
    override val fields: IFMS<IObject>,
    override val methods: IFMS<IVObject>,
    override val name: String,
    override val type: ObjType,
    override var value: Any?
) : IVObject, IFMP, IEP