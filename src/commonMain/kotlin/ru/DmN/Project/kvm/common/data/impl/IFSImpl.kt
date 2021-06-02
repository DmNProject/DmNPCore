package ru.DmN.Project.kvm.common.data.impl

import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.kvm.common.data.api.IFS
import ru.DmN.Project.kvm.common.obj.api.IFunction
import ru.DmN.Project.kvm.common.obj.api.Function
import ru.DmN.Project.core.util.AtomicInt

@Suppress("OVERRIDE_BY_INLINE")
class IFSImpl : IFS {
    val data = ArrayList<IFunction>()
    override inline val size: Int
        get() = data.size

    constructor()
    constructor(vararg os: IFunction) {
        for (o in os)
            data.add(o)
    }

    override inline fun add(obj: Function) { data.add(obj) }
    override fun get(name: String, args: Iterable<IObject>?): IFunction? {
        var func: IFunction? = null
        var i = AtomicInt(Int.MAX_VALUE)

        for (x in 0 until data.size) {
            val it = data[x]
            val j = AtomicInt()

            if (it.name == name) {
                if (args == null) {
                    if (!it.args.iterator().hasNext())
                        return it
                } else if (it.name == name && it.argEquals(args.iterator(), j) && j.value < i.value) {
                    func = it
                    i = j
                }
            }
        }

        return func
    }
    override fun remove(name: String): IFunction? {
        for (i in 0 until data.size)
            if (data[i].name == name)
                return data.removeAt(i)
        return null
    }

    override inline fun asArray(): Array<IFunction> = data.toTypedArray()
    override inline fun asList(): List<IFunction> = data
    override inline fun asArrayList(): ArrayList<IFunction> = data
}