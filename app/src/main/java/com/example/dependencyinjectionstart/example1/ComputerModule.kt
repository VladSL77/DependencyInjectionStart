package com.example.dependencyinjectionstart.example1

import dagger.Module
import dagger.Provides

/*
Класс с аннотацией @Module мы используем для создания таких зависимостей, в которых мы не можем конструктор пометить аннотацией
@Inject (например, по причине использования сторонних библиотек).
Аннотацией @Provides мы помечаем методы, в которых вручную создаем экземпляры класса (т.е. даггер не сам их создает).
Если необходимо - мы можем все цепочки зависимостей, для которых Inject неприменим, тут реализовать (как ниже с классом Computer).
Т.е. вложенность не важна. Даггер сам выстроит цепочку.
 */

@Module
class ComputerModule {

    @Provides
    fun providesMonitor(): Monitor {
        return Monitor()
    }

    @Provides
    fun providesMouse(): Mouse {
        return Mouse()
    }

    @Provides
    fun providesKeyboard(): Keyboard {
        return Keyboard()
    }

    @Provides
    fun providesMemory(): Memory {
        return Memory()
    }

    @Provides
    fun providesProcessor(): Processor {
        return Processor()
    }

    @Provides
    fun providesStorage(): Storage {
        return Storage()
    }

    @Provides
    fun providesComputerTower(
        storage: Storage,
        memory: Memory,
        processor: Processor
    ):ComputerTower {
        return ComputerTower(storage, memory, processor)
    }

    @Provides
    fun providesComputer(
        monitor: Monitor,
        computerTower: ComputerTower,
        keyboard: Keyboard,
        mouse: Mouse
    ): Computer {
        return Computer(monitor, computerTower, keyboard, mouse)
    }
}
