package ru.DmN.Project.kvm.common.obj.api

import ru.DmN.Project.core.obj.IEO
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.util.Utils.objectEquals
import ru.DmN.Project.core.util.AtomicInt
import ru.DmN.Project.kvm.common.vm.Call

interface IFunction : IObject {
    val args: Iterable<IObject>
    val code: IntArray?

    fun call(call: Call) = code?.let { call.vm.eval(it) }

    fun argEquals(args1: Iterator<IObject>): Boolean {
        var i = 0
        var j = 0

        val iterator = args.iterator()
        while (iterator.hasNext()) {
            if (!args1.hasNext())
                return false
            i++
            //
            val o1 = iterator.next()
            val o2 = args1.next()
            //
            if (o2 is IEO<*> && objectEquals(o2, o1))
                j++
        }

        return i == j
    }

    fun argEquals(args1: Iterator<IObject>, counter: AtomicInt): Boolean {
        var i = 0
        var j = 0

        val iterator = args.iterator()
        while (iterator.hasNext()) {
            if (!args1.hasNext())
                return false
            i++
            //
            val o1 = iterator.next()
            val o2 = args1.next()
            //
            if (o2 is IEO<*> && objectEquals(o2, o1, counter))
                j++
        }

        return i == j
    }
}