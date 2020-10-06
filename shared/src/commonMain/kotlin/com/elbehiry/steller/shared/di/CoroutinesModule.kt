package com.elbehiry.steller.shared.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val DefaultDispatcher = "DefaultDispatcher"
const val MainDispatcher = "MainDispatcher"
const val MainImmediateDispatcher = "MainImmediateDispatcher"

val coroutinesModule = module {
    single(named(DefaultDispatcher)) { Dispatchers.Default }
    single<CoroutineDispatcher>(named(MainDispatcher)) { Dispatchers.Main }
    single<CoroutineDispatcher>(named(MainImmediateDispatcher)) { Dispatchers.Main.immediate }
}