package ru.DmN.Project.test

import ru.DmN.Project.kvm.common.vm.DynamicVirtualMachine
import ru.DmN.Project.kvm.common.vm.DynamicVirtualMachine.Companion.OC_C3
import ru.DmN.Project.kvm.common.vm.DynamicVirtualMachine.Companion.OC_CO1
import ru.DmN.Project.kvm.common.vm.DynamicVirtualMachine.Companion.OC_SSS
import kotlin.test.Test

class KVMTest {
    @Test
    fun test() {
        val vm = DynamicVirtualMachine()
        //
        vm.init()
        //
        vm.eval(byteArrayOf(
            OC_SSS, 1,
            OC_CO1, 1, 0, 13, 72, 101, 108, 108, 111, 44, 32, 87, 111, 114, 108, 100, 33,
            OC_C3, 0, 7, 112, 114, 105, 110, 116, 108, 110
        ))
    }
}