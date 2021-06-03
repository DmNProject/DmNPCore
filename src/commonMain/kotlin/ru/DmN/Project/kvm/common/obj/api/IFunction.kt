package ru.DmN.Project.kvm.common.obj.api

import ru.DmN.Project.core.obj.IEO
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.util.Utils.objectEquals
import ru.DmN.Project.core.util.AtomicInt
import ru.DmN.Project.kvm.common.vm.Call

interface IFunction : IObject {
    val args: List<IObject>
    val code: ByteArray?

    fun call(call: Call) = code?.let { call.vm.eval(it) }

    fun argEquals(args1: List<IObject>): Boolean {
        var i = 0
        var j = 0

        var x = 0
        while (x < args.size) {
            if (args1.size == x)
                return false
            i++
            //
            val o = args1[x]
            if (o is IEO<*> && objectEquals(o, args[x]))
                j++
            //
            x++
        }

        return i == j
    }

    fun argEquals(args1: List<IObject>, counter: AtomicInt): Boolean {
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
            if (o is IEO<*> && objectEquals(o, args[x], counter))
                j++
            //
            x++
        }

        return i == j
    }
}