package ru.DmN.Project.GullAsm.vm

import ru.DmN.Project.core.vm.v0.IVirtualMachine

class GVM : IVirtualMachine<ArrayList<Int>> {
    override fun init() {
        TODO("Not yet implemented")
    }

    override fun eval(code: ArrayList<Int>) {
        TODO("Not yet implemented")
    }
}

/*
Строение GVM:
1. IObject - текущий обьект
2. ArrayList<IObject> - хип обьектов
3. ArrayDeque<Any?> - стек
4. [15 шт] Any? - регистры для функций
5. ArrayList<Integer> - код
Опкоды:
(ПОЯСНЕНИЕ) XN - X обозначает что элемент это следующий элемент кода, вместо N подписывается значение какой он идёт по счёту после опкода
1. Устанавливает @1 в X1 @4
2. Устанавливает значение X1 @"регистра" в @1
3. Помещает X1 @5 в @3
4. Помещает X1 @3 в X2 @4 начиная с X3 @4
5. Помещает X1 @"4 в @3 начиная с X2 @4
 */