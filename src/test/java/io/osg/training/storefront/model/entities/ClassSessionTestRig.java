package io.osg.training.storefront.model.entities;

import io.osg.training.storefront.AbstractTestRig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Lazy
@ConfigurationProperties(prefix="test.rigs.classSessionTestRig")
@Profile("development")
public class ClassSessionTestRig extends AbstractTestRig {
}