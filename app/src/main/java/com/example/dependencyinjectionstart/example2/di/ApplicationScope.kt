package com.example.dependencyinjectionstart.example2.di

import javax.inject.Scope

/*
Кастомная аннотация нужна для улучшения "читабельности", ибо из коробки @Singleton - не понятно,
это сингл на уровне всего приложения или ...?
А так скоуп - всё приложение.
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationScope
