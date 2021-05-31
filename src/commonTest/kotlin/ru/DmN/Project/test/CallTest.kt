package ru.DmN.Project.test

import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.kvm.common.obj.api.Function
import ru.DmN.Project.kvm.common.obj.impl.types.TInstance
import ru.DmN.Project.kvm.common.obj.impl.types.TKawaiiString
import ru.DmN.Project.kvm.common.utils.createString
import ru.DmN.Project.kvm.common.vm.Call
import ru.DmN.Project.kvm.common.vm.DynamicVirtualMachine
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class CallTest {
    @Test
    fun callFunctionTest() {
        val vm = DynamicVirtualMachine()

        vm.init()

        vm.functions.add(object : Function() {
            override val name: String = "foo"
            override fun call(call: Call) {
                call.result = createString(call.vm, "result", "Foo!") as IObject
            }
        })

        val call = vm.callFunction(vm, "foo", emptyList())

        assertNotNull(call)
        assertEquals((call.result as TInstance).value, "Foo!")

        println("callFunctionTest complete!!! Result => " + call.result)
    }
}