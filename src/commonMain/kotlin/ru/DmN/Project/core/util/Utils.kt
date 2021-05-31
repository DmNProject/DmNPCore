package ru.DmN.Project.core.util

import ru.DmN.Project.core.obj.IEO
import ru.DmN.Project.core.obj.IObject

fun objectEquals(o1: IEO<*>, o2: IObject): Boolean {
    if (o1.name == o2.name)
        return true
    for (e in o1.extends)
        if ((e is IEO<*> && objectEquals(e, o2)) || e.name == o2.name)
            return true
    return false
}