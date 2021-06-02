package ru.DmN.Project.kvm.common.data.impl

import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.kvm.common.data.api.IFS
import ru.DmN.Project.kvm.common.obj.api.IFunction
import ru.DmN.Project.kvm.common.obj.api.Function
import ru.DmN.Project.kvm.common.utils.AtomicInt

class IFSImpl : IFS {
    val data = ArrayList<IFunction>()
    override val size: Int
        get() = data.size

    constructor()
    constructor(vararg os: IFunction) {
        for (o in os)
            data.add(o)
    }

    override fun add(obj: Function) { data.add(obj) }
    override fun get(name: String, args: Iterable<IObject>): IFunction? {
        var func: IFunction? = null
        var i = AtomicInt(Int.MAX_VALUE)

        data.forEach {
            val j = AtomicInt()

            if (it.argEquals(args.iterator(), j) && j.i < i.i) {
                func = it
                i = j
            }
        }

        return func
    }
    override fun remove(name: String): IFunction? {
        data.forEachIndexed { i, it ->
            if (it.name == name)
                return data.removeAt(i)
        }
        return null
    }

    override fun asArray(): Array<IFunction> = data.toTypedArray()
    override fun asList(): List<IFunction> = data
    override fun asArrayList(): ArrayList<IFunction> = data
}