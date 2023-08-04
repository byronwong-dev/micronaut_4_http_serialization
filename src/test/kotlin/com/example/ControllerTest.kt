package com.example

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.kotest5.annotation.MicronautTest

@MicronautTest
class ControllerTest(
    @Client("/example")
    client: HttpClient
) : FunSpec({

    test("should be able to retrieve Foo json") {
        val response = client.toBlocking().retrieve("/foo")
        response.shouldBe("""{"name":"Micronaut"}""")
    }

    test("should be able to retrieve Bar json") {
        val response = client.toBlocking().retrieve("/bar")
        response.shouldBe("""{"name":"Micronaut"}""")
    }

})
