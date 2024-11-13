package com.sagrd.remotesupport

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform