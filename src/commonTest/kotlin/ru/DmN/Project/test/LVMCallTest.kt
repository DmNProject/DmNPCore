//package ru.DmN.Project.test
//
//import ru.DmN.Project.core.obj.IObject
//import ru.DmN.Project.lvm.obj.types.TInstance
//import ru.DmN.Project.lvm.obj.LightFunction
//import ru.DmN.Project.lvm.obj.LightObject
//import ru.DmN.Project.lvm.utils.Utils
//import ru.DmN.Project.lvm.vm.Call
//import ru.DmN.Project.lvm.vm.LightVirtualMachine
//import kotlin.test.Test
//import kotlin.test.assertEquals
//import kotlin.test.assertNotNull
//
//class LVMCallTest {
//    @Test
//    fun callFunctionTest() {
//        val vm = LightVirtualMachine()
//
//        vm.init()
//
//        vm.functions.add(object : LightFunction("foo") {
//            override fun call(call: Call) {
//                call.result = Utils.createString(call.vm, "result", "Foo!") as LightObject
//            }
//        })
//
//        val call = vm.callFunction(vm, "foo", emptyList())
//
//        assertNotNull(call)
//        assertEquals((call.result as TInstance).value, "Foo!")
//
//        println("callFunctionTest complete!!! Result => " + (call.result as TInstance).value)
//    }
//
//    @Test
//    fun callFunctionWithArgs() {
//        val vm = LightVirtualMachine()
//
//        vm.init()
//
//        vm.functions.add(object : LightFunction("add") {
//            override val args: List<LightObject> = arrayListOf(vm.tNUMBER, vm.tNUMBER)
//            override fun call(call: Call) {
//                val iterator = call.args.iterator()
//                val a = iterator.next() as TInstance
//                val b = iterator.next() as TInstance
//
//                call.result = Utils.createInt(call.vm, "result", a.value as Int + b.value as Int) as LightObject
//            }
//        })
//
//        val aVal = Utils.createInt(vm, "a", 12)!!
//        val bVal = Utils.createInt(vm, "b", 21)!!
//
//        val call = vm.callFunction(vm, "add", arrayListOf(aVal, bVal))
//
//        assertNotNull(call)
//        assertEquals((call.result as TInstance).value, 33)
//
//        println("callFunctionWithArgs complete!!! Result => " + (call.result as TInstance).value)
//    }
//
//    @Test
//    fun callMultiFunctions() {
//        val vm = LightVirtualMachine()
//
//        vm.init()
//
//        vm.functions.add(object : LightFunction("foo") {
//            override val args: List<LightObject> = arrayListOf(vm.tOBJECT)
//            override fun call(call: Call) {
//                println("Foo Object arg call!")
//            }
//        })
//
//        vm.functions.add(object : LightFunction("foo") {
//            override val args: List<LightObject> = arrayListOf(vm.tNUMBER)
//            override fun call(call: Call) {
//                println("Foo Int arg call!")
//            }
//        })
//
//        assertNotNull(vm.callFunction(vm, "foo", arrayListOf(Utils.createInt(vm, "i", 12)!!)))
//        assertNotNull(vm.callFunction(vm, "foo", arrayListOf(Utils.createString(vm, "str", "Hello, World!")!!)))
//    }
//}