package ru.DmN.Project.kvm.common.data.impl

import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.kvm.common.data.api.IFS
import ru.DmN.Project.kvm.common.obj.api.IFunction
import ru.DmN.Project.kvm.common.obj.impl.Function
import ru.DmN.Project.kvm.common.utils.AtomicInt

class IFSImpl<I : IObject> : IFS<I> {
    val data = ArrayList<IFunction<I>>()
    override val size: Int
        get() = data.size

    override fun add(obj: Function<I>) { data.add(obj) }
    override fun get(name: String, args: Iterable<IObject>): IFunction<I>? {
        val functions = ArrayList<Pair<IFunction<I>, AtomicInt>>()

        data.forEach {
            val i = AtomicInt()
            val func = Pair(it, i)

            if (it.name == name && it.argEquals(args.iterator(), i))
                functions.add(func)
        }

        var func: Pair<IFunction<I>?, AtomicInt> = Pair(null, AtomicInt(-1))
        for (e in functions)
            if (e.second.i > func.second.i)
                func = e
        return func.first
    }
    override fun remove(name: String): IFunction<I>? {
        data.forEachIndexed { i, it ->
            if (it.name == name)
                return data.removeAt(i)
        }
        return null
    }

    override fun asArray(): Array<IFunction<I>> = data.toTypedArray()
    override fun asList(): List<IFunction<I>> = data
    override fun asArrayList(): ArrayList<IFunction<I>> = data
}