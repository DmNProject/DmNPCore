package ru.DmN.Project.kvm.common.utils

import ru.DmN.Project.core.data.impl.IESImpl
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.core.util.AtomicInt
import ru.DmN.Project.kvm.common.obj.KawaiiType
import ru.DmN.Project.kvm.common.obj.impl.types.TInstance
import ru.DmN.Project.kvm.common.vm.DynamicVirtualMachine

object Utils {
    inline fun createX(obj: IObject, name: String, value: Any?): TInstance =
        TInstance(name, KawaiiType.VAR, value, IESImpl(obj))

    fun createString(vm: DynamicVirtualMachine, name: String, value: String?): TInstance? {
        return try {
            createX(vm.tSTRING, name, value)
        } catch (ignored: Exception) {
            null
        }
    }

    fun createString(vm: DynamicVirtualMachine, name: String, value: ByteArray): TInstance? {
        return try {
            createX(vm.tSTRING, name, value.decodeToString())
        } catch (ignored: Exception) {
            null
        }
    }

    fun createInt(vm: DynamicVirtualMachine, name: String, value: Int?): TInstance? {
        return try {
            createX(vm.tNUMBER, name, value)
        } catch (ignored: Exception) {
            null
        }
    }

    fun getByteArrayOfIntArray(ia: IntArray, i: AtomicInt): ByteArray {
        val size = ia[i.value++]
        val arr = ArrayList<Byte>()
        for (j in i.value until size + i.value)
            arr.add(ia[j].toByte())
        i.value += size
        return arr.toByteArray()
    }

    fun getByteArrayOfIntArray(ia: IntArray, i: AtomicInt, size: Int): ByteArray {
        val arr = ArrayList<Byte>()
        for (j in i.value until size + i.value)
            arr.add(ia[j].toByte())
        i.value += size
        return arr.toByteArray()
    }
}