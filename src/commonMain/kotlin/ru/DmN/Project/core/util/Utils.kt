package ru.DmN.Project.core.util

import ru.DmN.Project.core.obj.IEO
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.kvm.common.utils.AtomicInt

fun objectEquals(o1: IEO<*>, o2: IObject, start: Boolean = true, c: AtomicInt = AtomicInt()): Boolean {
    if (start)
        c.inc()

    if (o1.name == o2.name)
        return true
    for (e in o1.extends)
        if ((e is IEO<*> && objectEquals(e, o2, false, c)) || e.name == o2.name)
            return true
    return false
}