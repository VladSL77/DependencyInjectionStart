package com.example.dependencyinjectionstart.example2.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/*
Ранее, в мапе мы использовали в качестве ключа название класса в виде строки. Однако, это вызовет краш в релизе из-за обфускации
(потому что именно для релизной сборке в файле градла включена обфускация).
Поэтому мы делаем свою аннотацию, в которой используем название класса (при обфускации везде будет одно и то же название и краша
не будет). А точнее, указываем не название класса, а разрешаем использовать в качестве ключа любого наследника класса ViewModel.
 */

@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class ViewModelKey(val value: KClass<out ViewModel>)
