package com.example.dependencyinjectionstart.example2.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component

/*
ViewModelModule::class из списка модулей перекочевал в ActivityComponent, потому что теперь за создание ВьюМоделей отвечает
именно ActivityComponent
 */
@ApplicationScope
@Component(modules = [DataModule::class, DomainModule::class])
interface ApplicationComponent {

    fun activityComponentFactory(): ActivityComponent.Factory

    /*
    Именно так, через кастомный билдер, добавляют в граф зависимостей какие-то компоненты крутые программисты
    (контекст или что-то ещё) после запуска приложения (т.е. когда мы не можем добавить зависимости на этапе компиляции).
    Уроком ранее был НЕ крутой вариант с созданием отдельного модуля.
     */
//    @Component.Builder
//    interface ApplicationComponentBuilder {
//
//        @BindsInstance
//        fun context(context: Context): ApplicationComponentBuilder
//
//        @BindsInstance
//        fun currentTimeInMillis(currentTime: Long): ApplicationComponentBuilder
//
//        fun build(): ApplicationComponent
//    }

    /*
    Оказалось, что и билдер - не круто. А круто - Factory. И не нужно плодить кучу методов.
     */
    @Component.Factory
    interface ApplicationComponentFactory {

        fun create(
            @BindsInstance
            context: Context,
            @BindsInstance
            currentTime: Long
        ): ApplicationComponent
    }
}
