package com.codigoelectronica.infraestructure.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.xml.ws.Response;

import org.junit.jupiter.api.Test;

import com.codigoelectronica.valueobjects.dto.Respuesta;

import io.micronaut.http.HttpMethod;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;

@MicronautTest
public class PeticionesGetTest {

    @Inject
    EmbeddedServer server;

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void simpleGetTest() {
        String response = client.toBlocking()
                .retrieve(HttpRequest.GET("/simpleGet"));
        assertEquals("simpleGet", response);
    }

    @Test
    void peticionGetRetornaTextoPlanoTest() {
        String response = client.toBlocking()
                .retrieve(HttpRequest.GET("/peticionGetRetornaTextoPlano"));
        assertEquals("peticionGetRetornaTextoPlano", response);
    }

    @Test
    void getPathVariableTest() {
        Integer numero = 5;
        String uri = "/getPathVariable/" + numero.toString();
        String repuestaComparar = "getPathVariable:" + numero.toString();
        String response = client.toBlocking()
                .retrieve(HttpRequest.GET(uri));
        assertEquals(response, repuestaComparar);
    }

    @Test
    void getPathVariableUrisTest() {
        String nombre = "codigoelectronica";
        String uri = "/p/" + nombre;
        String repuestaComparar = "getPathVariableUris:" + nombre;
        String response = client.toBlocking()
                .retrieve(HttpRequest.GET(uri));
        assertEquals(response, repuestaComparar);
    }

    @Test
    void getHttpResponseTest() {
        HttpRequest request = HttpRequest.create(HttpMethod.GET, "/getHttpResponse");
        HttpResponse<Respuesta> respuestaResponse = client.toBlocking()
                .exchange(request, Respuesta.class);

        assertEquals(respuestaResponse.getStatus().getCode(), 200 );
        assertNotNull(respuestaResponse.body());
    }

}
