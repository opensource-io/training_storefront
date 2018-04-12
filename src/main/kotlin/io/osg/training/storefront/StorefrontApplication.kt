package io.osg.training.storefront

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;


@SpringBootApplication
@EnableJpaRepositories
@EnableConfigurationProperties
@EnableOAuth2Sso
class StorefrontApplication

fun main(args: Array<String>) {
    SpringApplication.run(StorefrontApplication::class.java, *args)
}

