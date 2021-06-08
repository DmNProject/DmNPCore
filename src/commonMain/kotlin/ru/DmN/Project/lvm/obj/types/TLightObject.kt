package ru.DmN.Project.lvm.obj.types

import ru.DmN.Project.lvm.obj.LightFunction
import ru.DmN.Project.lvm.obj.LightObject
import ru.DmN.Project.lvm.obj.LightType
import ru.DmN.Project.lvm.utils.Utils
import ru.DmN.Project.lvm.vm.Call

@Suppress("OVERRIDE_BY_INLINE")
class TLightObject : LightObject("ru.DmN.Project.lvm.Object", LightType.OBJ) {
    init {
        functions.add(object : LightFunction("toString") {
            override val args: List<LightObject> = arrayListOf()

            override fun call(call: Call) {
                call.result = Utils.createString(call.vm, "_result_", this@TLightObject.toString())!!
            }
        })
    }
}