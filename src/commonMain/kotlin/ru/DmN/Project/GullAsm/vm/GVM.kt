package ru.DmN.Project.GullAsm.vm

import ru.DmN.Project.core.vm.v0.IVirtualMachine

class GVM : IVirtualMachine<ArrayList<Int>> {
    override fun init() {
        TODO("Not yet implemented")
    }

    override fun eval(code: ArrayList<Int>) {
        var i = 0
        while (i < code.size) {
            when (code[i]) {
                else -> throw TODO("REALIZE NORMAL EXCEPTION PLEASE")
            }

            i++
        }
    }
}

/*
Строение GVM:
1. IObject - текущий обьект
2. ArrayList<IObject> - хип обьектов
3. ArrayDeque<Any?> - стек
4. [15 шт] Any? - регистры
5. ArrayList<Integer> - код
Опкоды:
////////////////////////////////////////
КОД => СТЕК
////////////////////////////////////////
1. загрузить 1 "обьект" из кода в стек
--- 1; "обьект"
2. загрузить @A "обьектов" из кода в стек
--- 2; @A; "обьекты"
////////////////////////////////////////
КОД => регистры
////////////////////////////////////////
3. загрузить @A "обьектов" из кода в @B регистров начиная с @C регистра
--- 3; @A; @B; @C; "обьекты"
////////////////////////////////////////
стек => регистры
////////////////////////////////////////
4. загрузить @A элементов сверху стека в регистры для начиная с @B регистра
--- 4; @A; @B
5. загрузить @A элементов снизу стека в регистры для начиная с @B регистра
--- 5; @A; @B
////////////////////////////////////////
регистры => стек
////////////////////////////////////////
6. загрузить @A регистров вверх стека начиная с @B регистра
--- 6; @A; @B
7. загрузить @A регистров вниз стека начиная с @B регистра
--- 7; @A; @B
////////////////////////////////////////
утилиты
////////////////////////////////////////
8. собрать строку из @A символов кода и поместить вверх стека
--- 8; @A; "код"
9. собрать строку из @A символов кода и поместить вниз стека
--- 9; @A; "код"
10. собрать строку из @A символов кода и поместить в регист @B
--- 10; @A; @B; "код"
 */