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
    defines: IDS<IObject> = IDSImpl(),
    functions: IFS<ByteArray, DynamicVirtualMachine, IObject> = IFSImpl(),
    extends: IES<IObject> = IESImpl()
) : KVM<ByteArray, DynamicVirtualMachine, IObject>(name, defines, functions, extends) {
    //
    override val tNULL        get() = defines["null"]!!
    override val tUNDEFINED   get() = defines["undefined"]!!
    override val tOBJECT      get() = defines["ru.DmN.Project.kvm.Object"]!!
    override val tSTRING      get() = defines["ru.DmN.Project.kvm.String"]!!
    override val tNUMBER      get() = defines["ru.DmN.Project.kvm.Number"]!!
    //
    val mainThread = Thread<ByteArray, DynamicVirtualMachine, IObject>("MainThread")

    override fun init() {
        defines.add(SpecValueObject("null", null))
        defines.add(SpecValueObject("undefined", getUndefined()))
        defines.add(TKawaiiObject<ByteArray, DynamicVirtualMachine, IObject>())
        defines.add(TKawaiiString<ByteArray, DynamicVirtualMachine, IObject>(tOBJECT))
        defines.add(TKawaiiNumber<ByteArray, DynamicVirtualMachine, IObject>(tOBJECT))
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

    fun callFunction(instance: IObject, func: IFunction<ByteArray, DynamicVirtualMachine, IObject>, args: List<IObject>, thread: Thread<ByteArray, DynamicVirtualMachine, IObject> = Thread("_")): Call<ByteArray, DynamicVirtualMachine, IObject> {
        val cs = thread.callStack
        val call = Call(this, thread, instance, func, args)
        cs.addCall(call)

        func.call(call)

        cs.removeCall(call)
        return call
    }

    fun callFunction(instance: IFunctionsContainer<ByteArray, DynamicVirtualMachine, IObject>, name: String, args: List<IObject>, thread: Thread<ByteArray, DynamicVirtualMachine, IObject> = Thread("_")): Call<ByteArray, DynamicVirtualMachine, IObject>? {
        val func = instance.functions[name, args]

        return if (func == null)
            null
        else {
           callFunction(instance, func as IFunction<ByteArray, DynamicVirtualMachine, IObject>, args, thread)
        }
    }
}

//typealias C = ByteArray
//typealias M = DynamicVirtualMachine
//typealias O = IObject
//typealias F = IFunction<C, M, O>
//typealias T = Thread<C, M, O>