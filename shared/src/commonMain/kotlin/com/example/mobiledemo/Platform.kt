package com.example.mobiledemo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform