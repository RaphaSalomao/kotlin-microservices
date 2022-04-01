package br.com.raphasalomao.microkotlin.bookservice.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
class FooBarController {

    @GetMapping("/foo-bar")
    fun fooBar(): Any {
        RestTemplate().getForEntity("http://localhost:9999/do-nothing", String::class.java)
        return object {
            val foo = "Foo"
            val bar = "Bar"
        }
    }

}