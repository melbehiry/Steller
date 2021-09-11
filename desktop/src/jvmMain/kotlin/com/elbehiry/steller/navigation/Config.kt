package com.elbehiry.steller.navigation

import com.arkivanov.decompose.statekeeper.Parcelable

sealed class Config : Parcelable{
    object Splash : Config()
    object PhotoList : Config()
}