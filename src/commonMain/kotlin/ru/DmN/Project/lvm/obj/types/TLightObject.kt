package ru.DmN.Project.lvm.obj.types

import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.kvm.common.obj.KawaiiType
import ru.DmN.Project.kvm.common.obj.api.Function
import ru.DmN.Project.kvm.common.utils.Utils
import ru.DmN.Project.kvm.common.vm.Call
import ru.DmN.Project.lvm.obj.LightObject

@Suppress("OVERRIDE_BY_INLINE")
class TLightObject : LightObject("ru.DmN.Project.lvm.Object", KawaiiType.OBJ) {
    init {
        functions.add(object : Function() {
            override inline val name: String get() = "toString"
            override val args: List<IObject> = arrayListOf()

            override fun call(call: Call) {
                call.result = Utils.createString(call.vm, "_result_", this@TLightObject.toString())!!
            }
        })
    }
}