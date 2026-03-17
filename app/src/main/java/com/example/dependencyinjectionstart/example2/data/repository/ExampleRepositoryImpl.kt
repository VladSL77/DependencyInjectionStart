package com.example.dependencyinjectionstart.example2.data.repository

import com.example.dependencyinjectionstart.example2.data.datasource.ExampleLocalDataSource
import com.example.dependencyinjectionstart.example2.data.datasource.ExampleRemoteDataSource
import com.example.dependencyinjectionstart.example2.data.mapper.ExampleMapper
import com.example.dependencyinjectionstart.example2.di.TestQualifier
import com.example.dependencyinjectionstart.example2.domain.ExampleRepository
import javax.inject.Inject

class ExampleRepositoryImpl @Inject constructor(
    private val localDataSource: ExampleLocalDataSource,
    @TestQualifier private val remoteDataSource: ExampleRemoteDataSource,
    private val mapper: ExampleMapper
) : ExampleRepository {

    override fun method() {
        mapper.map()
        localDataSource.method()
        remoteDataSource.method()
    }
}
/*
Урок 11.15 (Qualifiers)
Допустим, у нас есть две реализации интерфейса ExampleRemoteDataSource (одна - боевая, типа, прод, и одна - тестовая, типа - мок)
Во-первых, создаем два квалификатора (см. ProdQualifier и TestQualifier).
Во-вторых, в DataModule связываем боевую и тестовую версии с помощью созданных квалификаторов с интерфейсом.
В-третьих, в реализации репозитория (то бишь в этом файле) в конструкторе указываем нужную аннотацию и таким образом переключаем
между боевым и тестовым режимами. Вот это было не явно почему-то для меня... Мне казалось, что выбор приходит откуда-то извне.
Позже, если не забуду, надо ещё над этим подумать.
А так - квалификаторами можно помечать те параметры, у которых совпадают типы (поскольку Даггер смотрит именно на типы, а не на
имена параметров при сборке графа). Например, при создании ВьюМодели, в файле АктивитиКомпонент String можно разрулить так:
@Subcomponent.Factory
    interface Factory {

        fun create(
            @BindsInstance
            @IdQualifier
            id: String
            @BindsInstance
            @NameQualifier
            name: String
        ): ActivityComponent
    }
при этом в самом классе ВьюМодели:
class ExampleViewModel @Inject constructor(
    private val useCase: ExampleUseCase,
    @IdQualifier private val id: String
    @NameQualifier private val name: String
) : ViewModel() {
...
}
 */
