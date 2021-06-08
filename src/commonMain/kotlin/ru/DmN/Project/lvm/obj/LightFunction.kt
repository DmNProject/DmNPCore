package ru.DmN.Project.lvm.obj

import ru.DmN.Project.core.obj.IEO
import ru.DmN.Project.core.util.AtomicInt
import ru.DmN.Project.lvm.utils.Utils
import ru.DmN.Project.lvm.vm.Call

abstract class LightFunction(name: String) : LightObject(name, LightType.FUN) {
    open val code: ByteArray? = null
    open val args: List<LightObject> = emptyList()

    open fun call(call: Call) = code?.let { call.vm.eval(it) }

    fun argEquals(args1: List<LightObject>): Boolean {
        var i = 0
        var j = 0

        var x = 0
        while (x < args.size) {
            if (args1.size == x)
                return false
            i++
            //
            val o = args1[x]
            if (o is IEO<*> && Utils.objectEquals(o, args[x]))
                j++
            //
            x++
        }

        return i == j
    }

    fun argEquals(args1: List<LightObject>, counter: AtomicInt): Boolean {
        var i = 0
        var j = 0

        var x = 0
        while (x < args.size) {
            if (args1.size == x)
                return false
            //
            i++
            //
            val o = args1[x]
            if (o is IEO<*>)
                if (Utils.objectEquals(o, args[x], counter))
                    j++
                else
                    return false
            //
            x++
        }

        return i == j
    }
}