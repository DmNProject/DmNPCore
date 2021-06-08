package ru.DmN.Project.core.util

import ru.DmN.Project.core.obj.IEO
import ru.DmN.Project.core.obj.IObject

object Utils {
    fun objectEquals(o1: IEO<*>, o2: IObject): Boolean {
        if (o1 == o2)
            return true
        for (e in o1.extends)
            if (e == o2 || (e is IEO<*> && objectEquals(e, o2)))
                return true
        return false
    }

    fun objectEquals(o1: IEO<*>, o2: IObject, i: AtomicInt): Boolean {
        if (o1 == o2)
            return true
        i.value++
        for (e in o1.extends)
            if (e == o2)
                return true
        i.value++
        for (e in o1.extends)
            if (e is IEO<*> && objectEquals(e, o2))
                return true
        i.value -= 2
        return false
    }
}