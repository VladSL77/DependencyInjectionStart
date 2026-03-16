package com.example.dependencyinjectionstart.example2.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dependencyinjectionstart.example2.di.ApplicationScope
import javax.inject.Inject
import javax.inject.Provider

/*
Новое: в даггере, в качестве возвращаемого значения можно использовать не конкретный класс, а класс, обернутый в Provider.
В этом случае, каждый раз, когда мы будем у Провайдера вызывать метод гет() - мы будем получать новое значение.
В нашем конкретном случае мы оборачиваем ВьюМодель в Провайдер, поскольку без этой обертки у нас ВьюМоделФактори одна на всё
приложение (а нам это и нужно, мы для этого добавили @ApplicationScope), и без Провайдера при открытии нового экрана у нас бы
сохранялись ВьюМодели от предыдущего экрана, а это плохо.
К тому же такой нюанс от ИИ гугла:
Зачем здесь Provider на самом деле:
Он превращает вашу карту из хранилища объектов (которые занимают память вечно) в карту функций-конструкторов.

    Вызвали get() — создали свежий объект.
    Экран закрылся — Android уничтожил ViewModel (нет утечек памяти).
    В фабрике (в карте) при этом ничего лишнего не копится, там только "рецепт" создания.

Так что Provider здесь — это не столько про разделение имен, сколько про управление жизненным циклом и предотвращение "вечных"
объектов в памяти.
 */
@ApplicationScope
class ViewModelFactory @Inject constructor(
    // Для Даггера важно "буква в букву" и без @JvmSuppressWildcards у нас "ViewModel" при компиляции в Котлин превратится
    // в "? extend ViewModel" и Даггеру это уже не нравится.
    private val viewModelsProviders: @JvmSuppressWildcards Map<String, Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModelsProviders[modelClass.simpleName]?.get() as T
    }
}
