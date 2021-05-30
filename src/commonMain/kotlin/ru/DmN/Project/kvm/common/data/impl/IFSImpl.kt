package ru.DmN.Project.kvm.common.data.impl

import ru.DmN.Project.core.obj.api.v1.ICO
import ru.DmN.Project.kvm.common.data.api.IFS

class IFSImpl<VM, O> : IFS<VM, O> {
    val data = ArrayList<ICO<VM, O>>()
    override val size: Int
        get() = data.size

    override fun add(obj: ICO<VM, O>) { data.add(obj) }
    override fun get(name: String): ICO<VM, O>? = data.find { it.name == name }
    override fun set(obj: ICO<VM, O>, name: String) {
        data.forEachIndexed { i, it ->
            if (it.name == name)
                data[i] = obj
        }
    }
    override fun remove(name: String): ICO<VM, O>? {
        data.forEachIndexed { i, it ->
            if (it.name == name)
                return data.removeAt(i)
        }
        return null
    }

    override fun asArray(): Array<ICO<VM, O>> = data.toTypedArray()
    override fun asList(): List<ICO<VM, O>> = data
    override fun asArrayList(): ArrayList<ICO<VM, O>> = data
}