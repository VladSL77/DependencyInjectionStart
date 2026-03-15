package com.example.dependencyinjectionstart.example2.di

import android.content.Context
import com.example.dependencyinjectionstart.example2.presentation.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DataModule::class, DomainModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    /*
    Именно так, через кастомный билдер, добавляют в граф зависимостей какие-то компоненты крутые программисты
    (контекст или что-то ещё).
    Уроком ранее был НЕ крутой вариант с созданием отдельного модуля.
     */
    @Component.Builder
    interface ApplicationComponentBuilder {

        @BindsInstance
        fun context(context: Context): ApplicationComponentBuilder

        @BindsInstance
        fun currentTimeInMillis(currentTime: Long): ApplicationComponentBuilder

        fun build(): ApplicationComponent
    }
}
