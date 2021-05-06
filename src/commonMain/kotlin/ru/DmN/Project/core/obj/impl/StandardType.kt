package ru.DmN.Project.core.obj.impl

import ru.DmN.Project.core.obj.api.v0.ObjType

class StandardType : ObjType {
    val Void    = StandardType()
    val Boolean = StandardType()
    val Byte    = StandardType()
    val Short   = StandardType()
    val Char    = StandardType()
    val Int     = StandardType()
    val Long    = StandardType()
    val Float   = StandardType()
    val Double  = StandardType()
}