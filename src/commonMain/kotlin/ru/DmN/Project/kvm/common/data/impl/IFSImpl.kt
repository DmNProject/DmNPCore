package ru.DmN.Project.kvm.common.data.impl

import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.kvm.common.data.api.IFS
import ru.DmN.Project.kvm.common.obj.api.IFunction

class IFSImpl<VM, O> : IFS<VM, O> {
    val data = ArrayList<IFunction<VM, O>>()
    override val size: Int
        get() = data.size

    override fun add(obj: IFunction<VM, O>) { data.add(obj) }
    override fun get(name: String, args: Iterable<IObject>): IFunction<VM, O>? = data.find { it.name == name && it.argEquals(args.iterator()) }
    override fun remove(name: String): IFunction<VM, O>? {
        data.forEachIndexed { i, it ->
            if (it.name == name)
                return data.removeAt(i)
        }
        return null
    }

    override fun asArray(): Array<IFunction<VM, O>> = data.toTypedArray()
    override fun asList(): List<IFunction<VM, O>> = data
    override fun asArrayList(): ArrayList<IFunction<VM, O>> = data
}