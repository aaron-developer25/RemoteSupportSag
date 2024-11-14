package com.sagrd.remotesupport.di

import com.sagrd.remotesupport.data.remote.SagApi
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

const val BASE_URL_API = "https://sag-api-dev.azurewebsites.net"

fun provideKtorClient(): HttpClient {
    return HttpClient {
        install(ContentNegotiation){
            json(json = Json { ignoreUnknownKeys = true }, contentType = ContentType.Any)
        }
    }
}

fun provideSagApi(client: HttpClient): SagApi {
    return SagApi(client, BASE_URL_API)
}