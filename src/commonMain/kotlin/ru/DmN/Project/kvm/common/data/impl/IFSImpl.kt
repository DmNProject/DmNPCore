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
        val functions = ArrayList<Pair<IFunction, AtomicInt>>()

        data.forEach {
            val i = AtomicInt()
            val func = Pair(it, i)

            if (it.name == name && it.argEquals(args.iterator(), i))
                functions.add(func)
        }

        var func: Pair<IFunction?, AtomicInt> = Pair(null, AtomicInt(-1))
        for (e in functions)
            if (e.second.i > func.second.i)
                func = e
        return func.first
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