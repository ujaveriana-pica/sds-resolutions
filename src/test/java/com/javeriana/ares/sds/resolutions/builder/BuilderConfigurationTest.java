package com.javeriana.ares.sds.resolutions.builder;

import com.javeriana.ares.sds.resolutions.ApplicationTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

@ContextConfiguration(classes = {ApplicationTest.class})
@TestPropertySource(properties = {"SPRING_PROFILES_ACTIVE=test"})
public abstract class BuilderConfigurationTest {
}
