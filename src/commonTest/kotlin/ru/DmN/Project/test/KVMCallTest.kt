package ru.DmN.Project.test

import ru.DmN.Project.core.obj.IObject
import ru.DmN.Project.kvm.common.obj.api.Function
import ru.DmN.Project.kvm.common.obj.impl.types.TInstance
import ru.DmN.Project.kvm.common.utils.Utils.createInt
import ru.DmN.Project.kvm.common.utils.Utils.createString
import ru.DmN.Project.kvm.common.vm.Call
import ru.DmN.Project.kvm.common.vm.DynamicVirtualMachine
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class KVMCallTest {
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

        println("callFunctionTest complete!!! Result => " + (call.result as TInstance).value)
    }

    @Test
    fun callFunctionWithArgs() {
        val vm = DynamicVirtualMachine()

        vm.init()

        vm.functions.add(object : Function() {
            override val name: String = "add"
            override val args: List<IObject> = arrayListOf(vm.tNUMBER, vm.tNUMBER)
            override fun call(call: Call) {
                val iterator = call.args.iterator()
                val a = iterator.next() as TInstance
                val b = iterator.next() as TInstance

                call.result = createInt(call.vm, "result", a.value as Int + b.value as Int)!!
            }
        })

        val aVal = createInt(vm, "a", 12)!!
        val bVal = createInt(vm, "b", 21)!!

        val call = vm.callFunction(vm, "add", arrayListOf(aVal, bVal))

        assertNotNull(call)
        assertEquals((call.result as TInstance).value, 33)

        println("callFunctionWithArgs complete!!! Result => " + (call.result as TInstance).value)
    }

    @Test
    fun callMultiFunctions() {
        val vm = DynamicVirtualMachine()

        vm.init()

        vm.functions.add(object : Function() {
            override val name: String = "foo"
            override val args: List<IObject> = arrayListOf(vm.tOBJECT)
            override fun call(call: Call) {
                println("Foo Object arg call!")
            }
        })

        vm.functions.add(object : Function() {
            override val name: String = "foo"
            override val args: List<IObject> = arrayListOf(vm.tNUMBER)
            override fun call(call: Call) {
                println("Foo Int arg call!")
            }
        })

        vm.callFunction(vm, "foo", arrayListOf(createInt(vm, "i", 12)!!))
        vm.callFunction(vm, "foo", arrayListOf(createString(vm, "str", "Hello, World!")!!))
    }
}