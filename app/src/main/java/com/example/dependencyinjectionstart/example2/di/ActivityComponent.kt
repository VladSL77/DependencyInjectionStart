package com.example.dependencyinjectionstart.example2.di

import com.example.dependencyinjectionstart.example2.presentation.MainActivity
import com.example.dependencyinjectionstart.example2.presentation.MainActivity2
import dagger.BindsInstance
import dagger.Subcomponent

/*
Если у нас есть зависимости, которые мы не можем предоставить Даггеру ни на этапе компиляции, ни на этапе создания компонента
(см. реализацию фабрики в ApplicationComponent.kt), например - id запущенной активити, то мы используем @Subcomponent.
Поскольку ActivityComponent своего рода наследник от ApplicationComponent (напрямую мы его создать не можем, только через
ApplicationComponent), то все зависимости, необходимые для создания вьюМоделей он подтянет от "родителя".
Поэтому тут достаточно только ViewModelModule.
 */
@Subcomponent(modules = [ViewModelModule::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)

    fun inject(activity: MainActivity2)

    @Subcomponent.Factory
    interface Factory {

        fun create(
            @BindsInstance
            id: String
        ): ActivityComponent
    }
}
