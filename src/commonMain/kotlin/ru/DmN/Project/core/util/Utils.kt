package ru.DmN.Project.core.util

import ru.DmN.Project.core.obj.IEO
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.kvm.common.utils.AtomicInt

object Utils {
    fun objectEquals(o1: IEO<*>, o2: IObject): Boolean {
        if (o1.name == o2.name)
            return true
        for (e in o1.extends)
            if (e.name == o2.name || (e is IEO<*> && objectEquals(e, o2)))
                return true
        return false
    }

    fun objectEquals(o1: IEO<*>, o2: IObject, i: AtomicInt): Boolean {
        if (o1.name == o2.name)
            return true
        i.inc()
        for (e in o1.extends)
            if (e.name == o2.name)
                return true
        i.inc()
        for (e in o1.extends)
            if (e is IEO<*> && objectEquals(e, o2))
                return true
        i.i -= 3
        return false
    }
}