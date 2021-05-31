package ru.DmN.Project.test

import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.kvm.common.obj.api.KObject
import ru.DmN.Project.kvm.common.obj.impl.Function
import ru.DmN.Project.kvm.common.vm.Call
import ru.DmN.Project.kvm.common.vm.DynamicVirtualMachine
import kotlin.test.Test

class CallTest {
    @Test
    fun addCallFunctionTest() {
        val vm = DynamicVirtualMachine()

        vm.init()

        vm.functions.add(object : Function<DynamicVirtualMachine>() {
            override val name: String = "foo"
            override fun call(call: Call<DynamicVirtualMachine>) {
                println("foo!")
            }
        })

//        vm.callFunction(vm, )
    }
}