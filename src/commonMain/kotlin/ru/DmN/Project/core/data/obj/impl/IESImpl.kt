package ru.DmN.Project.core.data.obj.impl

import ru.DmN.Project.core.data.obj.api.IES
import ru.DmN.Project.core.obj.IObject

class IESImpl<T : IObject> : IES<T> {
    val data = ArrayList<T>()
    override val size: Int
        get() = data.size

    constructor()
    constructor(vararg os: T) {
        for (o in os)
            data.add(o)
    }

    override fun iterator(): Iterator<T> = data.iterator()
    override fun add(obj: T) { data.add(obj) }
    override fun get(name: String): T? = data.find { it.name == name }
    override fun remove(name: String): T? {
        data.forEachIndexed { i, it ->
            if (it.name == name)
                return data.removeAt(i)
        }
        return null
    }

    override fun asArray(): Array<T> = data.toTypedArray<IObject>() as Array<T>
    override fun asList(): List<T> = data
    override fun asArrayList(): ArrayList<T> = data
}