package ru.DmN.Project.test

import ru.DmN.Project.lvm.vm.LightVirtualMachine
import kotlin.test.Test

class LVMTest {
    @Test
    fun test() {
        val vm = LightVirtualMachine()
        //
        vm.init()
        //
        vm.eval(byteArrayOf(
            LightVirtualMachine.OC_SSS, 1,
            LightVirtualMachine.OC_CO1, 1, 0, 13, 72, 101, 108, 108, 111, 44, 32, 87, 111, 114, 108, 100, 33,
            LightVirtualMachine.OC_C3, 0, 7, 112, 114, 105, 110, 116, 108, 110
        ))
    }
}