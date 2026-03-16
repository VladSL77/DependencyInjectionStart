package com.example.dependencyinjectionstart.example2

import android.app.Application
import com.example.dependencyinjectionstart.example2.di.DaggerApplicationComponent

/*
Переносим создание компонента из Активити выше -  на уровень Аpplication.
В противном случае у нас, при пересоздании активити (например, переворот экрана), будет создаваться
новый компонент и тогда наши аннотации @Singleton не сработают (они возвращают тот же объект только в рамках
скоупа, в котором создан компонент. А если скоуп новый - то и объект будет новый).
Т.е. если мы создаем компонент на уровне приложения, то и все объекты, связанные с компонентом и помеченные @Singleton будут
жить в единственном экзепляре, пока живет само приложение.
 */
class ExampleApp : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory()
            .create(
                context = this,
                currentTime = System.currentTimeMillis()
            )
    }
}
