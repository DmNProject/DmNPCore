//package ru.DmN.Project.kvm.common.vm
//
//import ru.DmN.Project.core.obj.IObject
//import ru.DmN.Project.core.util.AtomicInt
//import ru.DmN.Project.kvm.common.obj.api.IFunction
//import ru.DmN.Project.kvm.common.utils.Utils
//
//class CachedVirtualMachine : DynamicVirtualMachine() {
//    private val cache0 = HashMap<Triple<Int, AtomicInt, Int>, IFunction>()
//
//    override fun eval(code: ByteArray) {
//        var i = 0
//        while (i < code.size) {
//            when (code[i]) {
//                9 -> {
//                    val si = code[++i]
//                    val j = AtomicInt(++i)
//                    val size = code[j.value++]
//                    val key = Triple(si, j, size)
//                    val func = if (cache0.containsKey(key)) cache0[key] else {
//                        val n = Utils.getByteArrayOfIntArray(code, j, size).decodeToString()
//                        val f = functions[n, mainThread.stack]
//                        cache0[key] = f!!
//                        f
//                    }
//                    mainThread.stack[si] = callFunction(this, func!!, mainThread.stack, mainThread).result
//                    i = j.value - 1
//                }
//                else -> super.eval(code)
//            }
//
//            i++
//        }
//    }
//}