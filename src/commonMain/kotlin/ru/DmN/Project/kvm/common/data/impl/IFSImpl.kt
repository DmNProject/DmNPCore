package ru.DmN.Project.kvm.common.data.impl

import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.util.AtomicInt
import ru.DmN.Project.kvm.common.data.api.IFS
import ru.DmN.Project.kvm.common.obj.api.Function
import ru.DmN.Project.kvm.common.obj.api.IFunction
import ru.DmN.Project.kvm.common.vm.api.IVM

@Suppress("OVERRIDE_BY_INLINE")
class IFSImpl<C, V : IVM<C, V, O>, O : IObject> : IFS<C, V, O> {
    val data = ArrayList<IFunction<C, V, O>>()
    override inline val size: Int
        get() = data.size

    constructor()
    constructor(vararg os: IFunction<C, V, O>) {
        for (o in os)
            data.add(o)
    }

    override inline fun add(obj: Function<C, V, O>) { data.add(obj) }
    override fun get(name: String, args: List<IObject>?, iA: AtomicInt): IFunction<C, V, O>? {
        var func: IFunction<C, V, O>? = null
        var i = iA

        for (x in 0 until data.size) {
            val it = data[x]
            val j = AtomicInt()

            if (it.name == name)
                if (args == null) {
                    if (it.args.isEmpty())
                        return it
                } else if (it.name == name && it.argEquals(args, j) && j.value < i.value) {
                    func = it
                    i = j
                }
        }

        return func
    }
    override fun remove(name: String): IFunction<C, V, O>? {
        for (i in 0 until data.size)
            if (data[i].name == name)
                return data.removeAt(i)
        return null
    }

    override inline fun asArray(): Array<IFunction<C, V, O>> = data.toTypedArray()
    override inline fun asList(): List<IFunction<C, V, O>> = data
    override inline fun asArrayList(): ArrayList<IFunction<C, V, O>> = data
}