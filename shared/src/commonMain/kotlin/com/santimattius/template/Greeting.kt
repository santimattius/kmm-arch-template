package com.santimattius.template

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}