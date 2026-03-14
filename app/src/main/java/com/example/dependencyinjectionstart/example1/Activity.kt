package com.example.dependencyinjectionstart.example1

import javax.inject.Inject

class Activity {

    private val component = DaggerNewComponent.create()

    @Inject
    lateinit var keyboard: Keyboard
    @Inject
    lateinit var mouse: Keyboard
    @Inject
    lateinit var monitor: Keyboard

//    val keyboard = component.getKeyboard()
//    val mouse = component.getMouse()
//    val monitor = component.getMonitor()

    init {
        component.inject(this)
    }
}

/*
В этом уроке рассматриваем всё те же два варианта работы - через геттеры (что не гуд), и через
метод inject() (предпочтительный вариант). Но уже с использованием Даггера и аннотаций.
 */
