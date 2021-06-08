package ru.DmN.Project.lvm.obj

import ru.DmN.Project.core.obj.IEO
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.obj.ObjType
import ru.DmN.Project.core.util.AtomicInt
import ru.DmN.Project.core.util.Utils
import ru.DmN.Project.kvm.common.obj.KawaiiType
import ru.DmN.Project.lvm.vm.Call

abstract class LightFunction : IObject {
    override val type: ObjType = KawaiiType.FUN
    open val code: ByteArray? = null
    open val args: List<IObject> = emptyList()

    open fun call(call: Call) = code?.let { call.vm.eval(it) }

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
            if (o is IEO<*> && Utils.objectEquals(o, args[x]))
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