package io.osg.training.storefront

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
@EnableConfigurationProperties
class StorefrontApplication

fun main(args: Array<String>) {
    SpringApplication.run(StorefrontApplication::class.java, *args)
}