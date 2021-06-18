package ru.DmN.Project.kvm.common.vm

import ru.DmN.Project.core.data.api.IDS
import ru.DmN.Project.core.data.api.IES
import ru.DmN.Project.core.data.impl.IDSImpl
import ru.DmN.Project.core.data.impl.IESImpl
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.obj.IVObject
import ru.DmN.Project.kvm.common.data.api.IFS
import ru.DmN.Project.kvm.common.data.impl.IFSImpl
import ru.DmN.Project.kvm.common.obj.api.Function
import ru.DmN.Project.kvm.common.obj.api.IFunction
import ru.DmN.Project.kvm.common.obj.api.IFunctionsContainer
import ru.DmN.Project.kvm.common.obj.impl.SpecValueObject
import ru.DmN.Project.kvm.common.obj.impl.types.TKawaiiNumber
import ru.DmN.Project.kvm.common.obj.impl.types.TKawaiiObject
import ru.DmN.Project.kvm.common.obj.impl.types.TKawaiiString
import ru.DmN.Project.kvm.common.utils.Utils
import ru.DmN.Project.kvm.common.utils.getUndefined
import ru.DmN.Project.kvm.common.vm.api.KVM

open class DynamicVirtualMachine(
    name: String = "DynamicVirtualMachine",
    defines: IDS<O> = IDSImpl(),
    functions: IFS<C, V, O> = IFSImpl(),
    extends: IES<O> = IESImpl()
) : KVM<C, V, O>(name, defines, functions, extends) {
    //
    override val tNULL        get() = defines["null"]!!
    override val tUNDEFINED   get() = defines["undefined"]!!
    override val tOBJECT      get() = defines["ru.DmN.Project.kvm.Object"]!!
    override val tSTRING      get() = defines["ru.DmN.Project.kvm.String"]!!
    override val tNUMBER      get() = defines["ru.DmN.Project.kvm.Number"]!!
    //
    val mainThread = T("MainThread")

    override fun init() {
        defines.add(SpecValueObject("null", null))
        defines.add(SpecValueObject("undefined", getUndefined()))
        defines.add(TKawaiiObject<C, V, O>())
        defines.add(TKawaiiString<C, V, O>(tOBJECT))
        defines.add(TKawaiiNumber<C, V, O>(tOBJECT))
        //
        extends.add(tOBJECT)
        //
        functions.add(object : Function<ByteArray, DynamicVirtualMachine, IObject>() {
            override val name: String = "println"
            override val args: List<IObject> = arrayListOf(tOBJECT)

            override fun call(call: Call<ByteArray, DynamicVirtualMachine, IObject>) {
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

    override fun eval(code: C) {
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

    fun callFunction(instance: O, func: F, args: List<O>, thread: T = Thread("_")): Call<C, V, O> {
        val cs = thread.callStack
        val call = Call(this, thread, instance, func, args)
        cs.addCall(call)

        func.call(call)

        cs.removeCall(call)
        return call
    }

    fun callFunction(instance: IFunctionsContainer<C, V, O>, name: String, args: List<O>, thread: T = Thread("_")): Call<C, V, O>? {
        val func = instance.functions[name, args]

        return if (func == null)
            null
        else {
           callFunction(instance, func as F, args, thread)
        }
    }
}

typealias C = ByteArray
typealias V = DynamicVirtualMachine
typealias O = IObject
typealias F = IFunction<C, V, O>
typealias T = Thread<C, V, O>