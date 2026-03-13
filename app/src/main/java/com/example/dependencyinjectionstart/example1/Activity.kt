package com.example.dependencyinjectionstart.example1

class Activity {

    val monitor = Monitor()
    val keyboard = Keyboard()
    val mouse = Mouse()
    val computerTower = ComputerTower(
        Storage(),
        Memory(),
        Processor()
    )
    val computer = Computer(monitor, computerTower, keyboard, mouse)
}

/*
В первом уроке нет кода. Паттерн "инъекция зависимостей" по факту уже работает в классах ComputerTower и Computer - там мы НЕ
создаем необходимые объекты (зависимости), мы ждем, что их передадут через параметры конструктора.
А вот с Activity - не работает. В следующих уроках будет исправлено.
 */