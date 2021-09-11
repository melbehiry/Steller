package com.elbehiry.steller.di

import com.elbehiry.steller.ui.feature.photo.PhotoListViewModel
import org.koin.dsl.module

val desktopModule = module {
    single { PhotoListViewModel() }
}