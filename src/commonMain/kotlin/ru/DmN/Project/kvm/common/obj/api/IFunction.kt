package ru.DmN.Project.kvm.common.obj.api

import ru.DmN.Project.core.obj.IEO
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.util.objectEquals
import ru.DmN.Project.kvm.common.utils.AtomicInt
import ru.DmN.Project.kvm.common.vm.Call

interface IFunction<out I : IObject> : IObject {
    val args: Iterable<IObject>
    val code: ByteArray?

    fun call(call: Call) = code?.let { call.vm.eval(it) }

    fun argEquals(args1: Iterator<IObject>, c: AtomicInt = AtomicInt()): Boolean {
        var i = 0
        var j = 0

        val iterator = args.iterator()
        while (iterator.hasNext()) {
            if (!args1.hasNext())
                return false
            //
            i++
            //
            val o1 = iterator.next()
            val o2 = iterator.next()
            if ((o1 is IEO<*> && objectEquals(o1, o2, true, c)) || o1.name == o2.name)
                j++
        }

        return i == j
    }
}