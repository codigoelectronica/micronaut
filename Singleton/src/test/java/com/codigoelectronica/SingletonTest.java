package com.codigoelectronica;

import io.micronaut.context.BeanContext;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codigoelectronica.singleton.Vehicle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;

@MicronautTest
class SingletonTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Inject
    EmbeddedApplication<?> application;

    @Test
    void testItWorks() {
        logger.info("testItWorks");
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    void testSingleton() {
        final BeanContext context = BeanContext.run();
        Vehicle vehicle = context.getBean(Vehicle.class);
        logger.info("testSingleton");
        assertEquals(vehicle.start(), "Starting V8");
    }
}
