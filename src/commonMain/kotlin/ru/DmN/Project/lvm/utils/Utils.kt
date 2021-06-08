package ru.DmN.Project.lvm.utils

import ru.DmN.Project.core.data.impl.IESImpl
import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.kvm.common.obj.KawaiiType
import ru.DmN.Project.kvm.common.obj.impl.types.TInstance
import ru.DmN.Project.lvm.vm.LightVirtualMachine

object Utils {
    inline fun createX(obj: IObject, name: String, value: Any?): TInstance =
        TInstance(name, KawaiiType.VAR, value, IESImpl(obj))

    fun createString(vm: LightVirtualMachine, name: String, value: String?): TInstance? {
        return try {
            createX(vm.tSTRING, name, value)
        } catch (ignored: Exception) {
            null
        }
    }

    fun createString(vm: LightVirtualMachine, name: String, value: ByteArray): TInstance? {
        return try {
            createX(vm.tSTRING, name, value.decodeToString())
        } catch (ignored: Exception) {
            null
        }
    }

    fun createInt(vm: LightVirtualMachine, name: String, value: Int?): TInstance? {
        return try {
            createX(vm.tNUMBER, name, value)
        } catch (ignored: Exception) {
            null
        }
    }
}