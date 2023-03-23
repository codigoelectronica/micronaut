package com.codigoelectronica.infraestructure.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.Test;

import com.codigoelectronica.valueobjects.command.Contacto;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;

@MicronautTest
public class PeticionesPostTest {

    @Inject
    EmbeddedServer server;

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void simplePostStatusTest() {
        HttpRequest request = HttpRequest.POST("/simplePost", null);
        HttpResponse<String> response = client.toBlocking()
                .exchange(request, String.class);
        assertEquals(200, response.getStatus().getCode());
    }

    @Test
    void simplePostTest() {
        HttpRequest request = HttpRequest.POST("/simplePost", null);
        HttpResponse<String> response = client.toBlocking()
                .exchange(request, String.class);
        assertEquals("simplePost", response.getBody().get());
    }

    @Test
    void postBodyTest() {
        Contacto contacto = new Contacto();
        contacto.setNombre("oscar");
        HttpRequest request = HttpRequest.POST("/postBody", contacto);
        HttpResponse<String> response = client.toBlocking()
                .exchange(request, String.class);
        assertEquals("oscar", response.getBody().get());
    }

    @Test
    void postBodyHttpResponseTest() {
        Contacto contacto = new Contacto();
        contacto.setNombre("oscar");
        HttpRequest request = HttpRequest.POST("/postBodyHttpResponse", contacto);
        HttpResponse<String> response = client.toBlocking()
                .exchange(request, String.class);
        assertEquals(200, response.getStatus().getCode());
    }

}
