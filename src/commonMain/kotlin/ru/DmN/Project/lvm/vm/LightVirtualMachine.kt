package ru.DmN.Project.lvm.vm

import ru.DmN.Project.core.data.api.IDS
import ru.DmN.Project.core.data.api.IES
import ru.DmN.Project.core.data.impl.IDSImpl
import ru.DmN.Project.core.data.impl.IESImpl
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.obj.IVObject
import ru.DmN.Project.core.vm.IVirtualMachine
import ru.DmN.Project.kvm.common.obj.impl.SpecValueObject
import ru.DmN.Project.kvm.common.utils.getUndefined
import ru.DmN.Project.lvm.data.FunctionStorage
import ru.DmN.Project.lvm.obj.LightFunction
import ru.DmN.Project.lvm.obj.LightObject
import ru.DmN.Project.lvm.obj.LightType
import ru.DmN.Project.lvm.obj.types.TLightNumber
import ru.DmN.Project.lvm.obj.types.TLightObject
import ru.DmN.Project.lvm.obj.types.TLightSpecial
import ru.DmN.Project.lvm.obj.types.TLightString
import ru.DmN.Project.lvm.utils.Utils

class LightVirtualMachine (
    name: String = "LightVirtualMachine",
    defines: IDS<LightObject> = IDSImpl(),
    functions: FunctionStorage = FunctionStorage(),
    extend: LightObject? = null,
    implements: ArrayList<LightObject> = ArrayList()
) : IVirtualMachine<ByteArray>, LightObject(name, LightType.VM, extend, implements, defines, functions) {
    val tNULL            = TLightSpecial("null", null)
    val tUNDEFINED       = TLightSpecial("undefined", getUndefined())
    val tOBJECT          = TLightObject()
    val tSTRING          = TLightString(tOBJECT)
    val tNUMBER          = TLightNumber(tOBJECT)
    //
    val mainThread = Thread("MainThread")

    override fun init() {
        defines.add(tNULL)
        defines.add(tUNDEFINED)
        defines.add(tOBJECT)
        defines.add(tSTRING)
        defines.add(tNUMBER)
        //
        extend = tOBJECT
        //
        functions.add(object : LightFunction("println") {
            override val args: List<LightObject> = arrayListOf(tOBJECT)

            override fun call(call: Call) {
                println((call.thread.stack!![0] as IVObject).value)
                call.result = tUNDEFINED
            }
        })
    }

    companion object {
        inline val OC_NOP: Byte get() = 0x0
        inline val OC_SSS: Byte get() = 0x1
        inline val OC_CO0: Byte get() = 0x2
        inline val OC_CO1: Byte get() = 0x3
        inline val OC_GF0: Byte get() = 0x4
        inline val OC_GF1: Byte get() = 0x5
        inline val OC_C0: Byte get() = 0x6
        inline val OC_C1: Byte get() = 0x7
        inline val OC_C2: Byte get() = 0x8
        inline val OC_C3: Byte get() = 0x9
    }

    override fun eval(code: ByteArray) {
        var i = 0
        while (i < code.size) {
            when (code[i]) {
                OC_NOP -> { }
                OC_SSS -> {
                    var j = code[++i].toInt();
                    mainThread.stack = ArrayList();
                    val stack = mainThread.stack;
                    while (j != 0) {
                        stack!!.add(tUNDEFINED)
                        j--
                    }
                }
                OC_CO0 -> TODO("NEED TO REALIZE")
                OC_CO1 -> {
                    when (code[++i]) {
                        1.toByte() -> {
                            val si = code[++i]
                            val start = ++i
                            val size = code[i++]
                            mainThread.stack!![si.toInt()] = Utils.createString(this, "_", code.decodeToString(i, size + i))!!
                            i = start + size
                        }
                        else -> TODO("NEED TO REALIZE")
                    }
                }
                OC_GF0 -> TODO("NEED TO REALIZE")
                OC_GF1 -> TODO("NEED TO REALIZE")
                OC_C0 -> TODO("NEED TO REALIZE")
                OC_C1 -> TODO("NEED TO REALIZE")
                OC_C2 -> TODO("NEED TO REALIZE")
                OC_C3 -> {
                    val si = code[++i]
                    val start = ++i
                    val size = code[i++]
                    mainThread.stack!![si.toInt()] = callFunction(this, code.decodeToString(i, size + i), mainThread.stack!!, mainThread)!!.result
                    i = start + size
                }
            }

            i++
        }
    }

    fun callFunction(instance: LightObject, func: LightFunction, args: Iterable<LightObject>, thread: Thread = Thread("_")): Call {
        val cs = thread.callStack
        val call = Call(this, thread, instance, func, args)
        cs.addCall(call)

        func.call(call)

        cs.removeCall(call)
        return call
    }

    fun callFunction(instance: LightObject, name: String, args: List<LightObject>, thread: Thread = Thread("_")): Call? {
        val func = instance.functions[name, args]

        return if (func == null)
            null
        else {
            callFunction(instance, func, args, thread)
        }
    }
}