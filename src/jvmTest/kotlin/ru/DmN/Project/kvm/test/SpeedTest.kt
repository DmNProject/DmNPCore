package ru.DmN.Project.kvm.test

import org.apache.commons.lang3.time.StopWatch
import org.junit.Test
import ru.DmN.Project.kvm.common.vm.DynamicVirtualMachine

class SpeedTest {
    @Test
    fun test() {
        //
        val code = intArrayOf(
            1, 1,
            3, 1, 0, 13, 72, 101, 108, 108, 111, 44, 32, 87, 111, 114, 108, 100, 33,
            9, 0, 7, 112, 114, 105, 110, 116, 108, 110
        )
        //
        val vm = DynamicVirtualMachine()
        //
        vm.init()
        //
        val sw = StopWatch()
        sw.start()
        //
        for (i in 0..999) {
            vm.eval(code)
        }
        //
        sw.stop()
        println(sw)
    }
}