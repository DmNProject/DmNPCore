package ru.DmN.Project.kvm.common.vm

open class CallStack {
    val data = ArrayList<Call>()

    fun addCall(call: Call) { data.add(call) }
    fun removeCall(call: Call) { data.remove(call) }
    fun removeLastCall() { data.removeAt(data.size - 1) }
}