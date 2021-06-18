package ru.DmN.Project.kvm.common.vm

import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.kvm.common.vm.api.IVM

open class CallStack<C, V : IVM<C, V, O>, O : IObject> {
    val data = ArrayList<Call<C, V, O>>()

    fun addCall(call: Call<C, V, O>) { data.add(call) }
    fun removeCall(call: Call<C, V, O>) { data.remove(call) }
    fun removeLastCall() { data.removeAt(data.size - 1) }
}