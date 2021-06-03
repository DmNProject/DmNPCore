package ru.DmN.Project.kvm.test

import org.apache.commons.lang3.time.StopWatch
import org.junit.Test
import ru.DmN.Project.kvm.common.vm.DynamicVirtualMachine

class SpeedTest {
    @Test
    fun test() {
        //
        val vm = DynamicVirtualMachine()
        //
        vm.init()
        //
        val sw = StopWatch()
        sw.start()
        //
        vm.eval(intArrayOf(
            1, 1,
            3, 1, 0, 13, 72, 101, 108, 108, 111, 44, 32, 87, 111, 114, 108, 100, 33,
            9, 0, 7, 112, 114, 105, 110, 116, 108, 110
        ))
        //
        sw.stop()
        println(sw)
    }
}