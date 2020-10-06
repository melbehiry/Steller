package com.elbehiry.steller.shared.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(
        networkModule,
        coroutinesModule,
        photoModule,
    )
}

//used by ios etc.
fun initKoin() = initKoin {}

