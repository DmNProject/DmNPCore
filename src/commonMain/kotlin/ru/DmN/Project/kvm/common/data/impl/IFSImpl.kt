package ru.DmN.Project.kvm.common.data.impl

import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.kvm.common.data.api.IFS
import ru.DmN.Project.kvm.common.obj.api.IFunction
import ru.DmN.Project.kvm.common.obj.impl.Function

class IFSImpl<I : IObject> : IFS<I> {
    val data = ArrayList<IFunction<I>>()
    override val size: Int
        get() = data.size

    override fun add(obj: Function<I>) { data.add(obj) }
    override fun get(name: String, args: Iterable<IObject>): IFunction<I>? = data.find { it.name == name && it.argEquals(args.iterator()) }
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