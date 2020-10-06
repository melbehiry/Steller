package com.elbehiry.steller.shared.di

import com.elbehiry.steller.shared.remote.API_KEY
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import org.koin.dsl.module

private const val CONTENT_TYPE = "Content-Type"
private const val APPLICATION_JSON = "application/json"
private const val ACCEPT_VERSION = "Accept-Version"
private const val AUTHORIZATION = "Authorization"

val networkModule = module {
    single {
        HttpClient {
            install(JsonFeature) {
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                    isLenient = true; ignoreUnknownKeys = true
                })
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.BODY
            }
            install(DefaultRequest){
                headers.append(CONTENT_TYPE, APPLICATION_JSON)
                headers.append(ACCEPT_VERSION, "v1")
                headers.append(AUTHORIZATION, "Client-ID $API_KEY")
            }
        }
    }
}