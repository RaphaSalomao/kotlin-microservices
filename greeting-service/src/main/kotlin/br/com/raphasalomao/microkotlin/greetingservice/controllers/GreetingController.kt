package br.com.raphasalomao.microkotlin.greetingservice.controllers

import br.com.raphasalomao.microkotlin.greetingservice.configuration.GreetingConfiguration
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController()
@RequestMapping("/greeting")
class GreetingController(private val configuration: GreetingConfiguration) {


    @GetMapping
    fun greeting(@RequestParam name: String?, @RequestParam subject: String?): Any {
        return object {
            val name = name ?: configuration.greeting
            val subject = subject ?: configuration.defaultValue
            val id = UUID.randomUUID()
        }
    }

}