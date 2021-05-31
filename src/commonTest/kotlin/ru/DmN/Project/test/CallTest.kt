package ru.DmN.Project.test

import ru.DmN.Project.kvm.common.obj.api.Function
import ru.DmN.Project.kvm.common.obj.impl.types.TKawaiiString
import ru.DmN.Project.kvm.common.vm.Call
import ru.DmN.Project.kvm.common.vm.DynamicVirtualMachine
import kotlin.test.Test

class CallTest {
    @Test
    fun callFunctionTest() {
        val vm = DynamicVirtualMachine()

        vm.init()

        vm.functions.add(object : Function() {
            override val name: String = "foo"
            override fun call(call: Call) {
                call.result = TKawaiiString(call.vm, "Foo!")
            }
        })

        vm.callFunction(vm, "foo", emptyList())
    }
}