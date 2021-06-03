package ru.DmN.Project.kvm.common.vm

import ru.DmN.Project.core.data.api.IDS
import ru.DmN.Project.core.data.api.IES
import ru.DmN.Project.core.data.impl.IDSImpl
import ru.DmN.Project.core.data.impl.IESImpl
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.obj.IVObject
import ru.DmN.Project.core.util.AtomicInt
import ru.DmN.Project.core.vm.IVirtualMachine
import ru.DmN.Project.kvm.common.data.api.IFS
import ru.DmN.Project.kvm.common.data.impl.IFSImpl
import ru.DmN.Project.kvm.common.obj.KawaiiType
import ru.DmN.Project.kvm.common.obj.api.Function
import ru.DmN.Project.kvm.common.obj.api.IFunction
import ru.DmN.Project.kvm.common.obj.api.IFunctionsContainer
import ru.DmN.Project.kvm.common.obj.api.KObject
import ru.DmN.Project.kvm.common.obj.impl.SpecValueObject
import ru.DmN.Project.kvm.common.obj.impl.types.TInstance
import ru.DmN.Project.kvm.common.obj.impl.types.TKawaiiNumber
import ru.DmN.Project.kvm.common.obj.impl.types.TKawaiiObject
import ru.DmN.Project.kvm.common.obj.impl.types.TKawaiiString
import ru.DmN.Project.kvm.common.utils.Utils
import ru.DmN.Project.kvm.common.utils.getUndefined

open class DynamicVirtualMachine(
    name: String = "DynamicVirtualMachine",
    defines: IDS<IObject> = IDSImpl(),
    functions: IFS = IFSImpl(),
    extends: IES<IObject> = IESImpl()
) : IVirtualMachine<ByteArray>, KObject(name, KawaiiType.VM, defines, functions, extends) {
    inline val tNULL        get() = defines["null"]!!
    inline val tUNDEFINED   get() = defines["undefined"]!!
    inline val tOBJECT      get() = defines["ru.DmN.Project.kvm.Object"]!!
    inline val tSTRING      get() = defines["ru.DmN.Project.kvm.String"]!!
    inline val tNUMBER      get() = defines["ru.DmN.Project.kvm.Number"]!!
    //
    val mainThread = Thread("MainThread")

    override fun init() {
        defines.add(SpecValueObject("null", null))
        defines.add(SpecValueObject("undefined", getUndefined()))
        defines.add(TKawaiiObject())
        defines.add(TKawaiiString(tOBJECT))
        defines.add(TKawaiiNumber(tOBJECT))
        //
        extends.add(tOBJECT)
        //
        functions.add(object : Function() {
            override val name: String = "println"
            override val args: List<IObject> = arrayListOf(tOBJECT)

            override fun call(call: Call) {
                println((call.thread.stack[0] as IVObject).value)
                call.result = tUNDEFINED
            }
        })
    }

    companion object {
        inline val OC_NOP get() = 0.toByte()
        inline val OC_SSS get() = 1.toByte()
        inline val OC_CO0 get() = 2.toByte()
        inline val OC_CO1 get() = 3.toByte()
        inline val OC_GF0 get() = 4.toByte()
        inline val OC_GF1 get() = 5.toByte()
        inline val OC_C0 get() = 6.toByte()
        inline val OC_C1 get() = 7.toByte()
        inline val OC_C2 get() = 8.toByte()
        inline val OC_C3 get() = 9.toByte()
    }

    override fun eval(code: ByteArray) {
        var i = 0
        while (i < code.size) {
            when (code[i]) {
                OC_NOP -> { }
                OC_SSS -> { mainThread.stack.add(tUNDEFINED) }
                OC_CO0 -> TODO("NEED TO REALIZE")
                OC_CO1 -> {
                    when (code[++i]) {
                        1.toByte() -> {
                            val si = code[++i]
                            val start = ++i
                            val size = code[i++]
                            mainThread.stack[si.toInt()] = Utils.createString(this, "_", code.decodeToString(i, size + i))!!
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
                    mainThread.stack[si.toInt()] = callFunction(this, code.decodeToString(i, size + i), mainThread.stack, mainThread)!!.result
                    i = start + size
                }
            }

            i++
        }
    }

    fun callFunction(instance: IObject, func: IFunction, args: Iterable<IObject>, thread: Thread = Thread("_")): Call {
        val cs = thread.callStack
        val call = Call(this, thread, instance, func, args)
        cs.addCall(call)

        func.call(call)

        cs.removeCall(call)
        return call
    }

    fun callFunction(instance: IFunctionsContainer, name: String, args: List<IObject>, thread: Thread = Thread("_")): Call? {
        val func = instance.functions[name, args]

        return if (func == null)
            null
        else {
           callFunction(instance, func, args, thread)
        }
    }
}