package com.example

import io.micronaut.core.annotation.Introspected
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/example")
class Controller {

    @Get("/foo")
    fun helloFoo() : Parent {
        return Parent.Foo("Micronaut")
    }

    @Get("/bar")
    fun helloBar(): Bar {
        return Bar("Micronaut")
    }
}

@Introspected
sealed interface Parent {
    @Introspected
    data class Foo (
        val name: String
    ): Parent
}

@Introspected
data class Bar (
    val name: String
)