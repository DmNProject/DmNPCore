#Соотвествие ObjType и наследования интерфейсов Api

| ObjType   | Интерфейс(ы)           | Возможность изменения (поле - тип) |
| :--------:| :--------------------: | :-------------------------------:  |
| NULL      | IObject                | Не требуется                       |
| VAL       | IVObject               | Не требуется                       |
| VAR       | IVObject               | Требуется (value - Any?)           |
| REFERENCE | IVObject               | Не требуется                       |
| METHOD    | IVObject               | Не требуется                       |
| INTERFACE | IObject ~ IFMS ~ IES   | Желательно (везде)                 |
| CLASS     | IObject ~ IFMS ~ IES   | Желательно (везде)                 |
| PACKAGE   | IVObject               | Требуется (value - List<IObject>)  |