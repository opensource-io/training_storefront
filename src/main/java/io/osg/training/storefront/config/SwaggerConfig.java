package io.osg.training.storefront.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import({springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration.class,
        springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration.class})
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //.apis(RequestHandlerSelectors.basePackage("io.osg.training.storefront"))
                //.paths(regex("/*"))
                .build()
                .apiInfo(metaData())
        ;
    }

    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfoBuilder()
        		.title("Training Storefront API")
        		.description("Services for maintaining a training class schedule")
        		.termsOfServiceUrl("https://github.com/opensource-io/training_storefront")
        		.license("AGPLv3")
        		.licenseUrl("https://github.com/opensource-io/training_storefront/blob/master/LICENSE")
        		.version("1.0.0")
        		.build();
        return apiInfo;
    }
}
