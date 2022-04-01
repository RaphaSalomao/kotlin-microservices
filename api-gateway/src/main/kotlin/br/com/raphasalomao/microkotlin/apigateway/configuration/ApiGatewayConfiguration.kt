package br.com.raphasalomao.microkotlin.apigateway.configuration

import org.springframework.cloud.gateway.route.Route
import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.Buildable
import org.springframework.cloud.gateway.route.builder.PredicateSpec
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.cloud.gateway.route.builder.routes
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApiGatewayConfiguration {

    @Bean
    fun gatewayRouter(builder: RouteLocatorBuilder): RouteLocator {
        return builder.routes()
            .route { p ->
                p.path("/get")
                    .filters { f ->
                        f.addRequestHeader("Hello","World")
                            .addRequestParameter("World","Hello")
                    }.uri("http://httpbin.org:80")
            }.route { p ->
                p.path("/exchange-service/**").uri("lb://exchange-service")
            }.route { p ->
                p.path("/book-service/**").uri("lb://book-service")
            }.build()
    }

}