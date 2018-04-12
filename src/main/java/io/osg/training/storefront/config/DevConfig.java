package io.osg.training.storefront.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import io.osg.training.storefront.model.entities.AddressEntity;
import io.osg.training.storefront.model.entities.ClassSessionEntity;
import io.osg.training.storefront.model.entities.InstructorEntity;
import io.osg.training.storefront.model.entities.SkuEntity;
import io.osg.training.storefront.model.entities.VendorEntity;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class DevConfig extends RepositoryRestConfigurerAdapter {
	@Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(AddressEntity.class);
        config.exposeIdsFor(ClassSessionEntity.class);
        config.exposeIdsFor(InstructorEntity.class);
        config.exposeIdsFor(SkuEntity.class);
        config.exposeIdsFor(VendorEntity.class);
    }
	
}
