package ru.DmN.Project.kvm.common.utils

import ru.DmN.Project.core.data.obj.impl.IESImpl
import ru.DmN.Project.core.obj.IObject
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

    fun createInt(vm: DynamicVirtualMachine, name: String, value: Int?): TInstance? {
        return try {
            createX(vm.tINT, name, value)
        } catch (ignored: Exception) {
            null
        }
    }
}