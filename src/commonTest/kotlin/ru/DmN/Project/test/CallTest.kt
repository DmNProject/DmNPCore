package ru.DmN.Project.test

import ru.DmN.Project.kvm.common.obj.impl.Function
import ru.DmN.Project.kvm.common.vm.DynamicVirtualMachine
import kotlin.test.Test

class CallTest {
    @Test
    fun addFunction() {
        val vm = DynamicVirtualMachine()

        vm.functions.add(object : Function {

        })
    }
}