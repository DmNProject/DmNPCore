//package ru.DmN.Project.lvm.data
//
//import ru.DmN.Project.core.util.AtomicInt
//import ru.DmN.Project.lvm.obj.LightFunction
//import ru.DmN.Project.lvm.obj.LightObject
//
//class FunctionStorage {
//    val data = ArrayList<LightFunction>()
//    inline val size: Int get() = data.size
//
//    constructor()
//    constructor(vararg os: LightFunction) {
//        for (o in os)
//            data.add(o)
//    }
//
//    inline fun add(obj: LightFunction) { data.add(obj) }
//    operator fun get(name: String, args: List<LightObject>?): LightFunction? {
//        var func: LightFunction? = null
//        var i = AtomicInt(Int.MAX_VALUE)
//
//        for (x in 0 until data.size) {
//            val it = data[x]
//            val j = AtomicInt()
//
//            if (it.name == name) {
//                if (args == null) {
//                    if (it.args.isEmpty())
//                        return it
//                } else if (it.name == name && it.argEquals(args, j) && j.value < i.value) {
//                    func = it
//                    i = j
//                }
//            }
//        }
//
//        return func
//    }
//    fun remove(name: String): LightFunction? {
//        for (i in 0 until data.size)
//            if (data[i].name == name)
//                return data.removeAt(i)
//        return null
//    }
//}