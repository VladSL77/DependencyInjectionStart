package com.example.dependencyinjectionstart.example2.di

import com.example.dependencyinjectionstart.example2.data.repository.ExampleRepositoryImpl
import com.example.dependencyinjectionstart.example2.domain.ExampleRepository
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {

    @Binds
    fun bindRepository(impl: ExampleRepositoryImpl): ExampleRepository
}

/*
Если нам необходимо "вручную" создать экземпляр класса, НО при этом мы лишь передаем реализацию интерфейса:
fun provideRepository(impl: ExampleRepositoryImpl): ExampleRepository = impl
то эффективнее использовать @Binds:
@Binds
fun bindRepository(impl: ExampleRepositoryImpl): ExampleRepository
Если весь класс содержит только методы с @Binds (по сути, это абстрактные методы), значит, мы можем класс переделать
в интерфейс (как сделано с DomainModule) - даггер уже поймет, как генерировать зависимости, а мы получаем следующие преимущества:
класс сгенерирован не будет (у нас же теперь только интерфейс), методы вызываться не будут, а значит -
МЕНЬШЕ кода, БОЛЬШЕ скорость при компиляции!!!

Дополнительно: как совместить @Binds c @Provides (ведь, @Binds требует именно абстрактный класс).
В этом случае делаем все @Provides статическими:
@Module
abstract class DataModule {

    @Binds
    abstract fun bindLocalDataSource(impl: ExampleLocalDataSourceImpl): ExampleLocalDataSource


    companion object {
        @Provides
        fun provideRemoteDataSource(impl: ExampleRemoteDataSourceImpl): ExampleRemoteDataSource {
            // допустим, тут ещё как-то изменяется impl
            return impl
        }
    }
}
 */
