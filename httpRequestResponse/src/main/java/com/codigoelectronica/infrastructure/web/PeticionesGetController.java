package com.codigoelectronica.infrastructure.web;

import com.codigoelectronica.valueobjects.dto.Respuesta;

import java.util.ArrayList;
import java.util.List;

import com.codigoelectronica.valueobjects.dto.Error;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

@Controller
public class PeticionesGetController {
    
    @Get("/simpleGet")
    public String simpleGet() {
        return "simpleGet";
    }

    @Get(value = "/peticionGetRetornaTextoPlano", produces = MediaType.TEXT_PLAIN)
    public String peticionGetRetornaTextoPlano() {
        return "peticionGetRetornaTextoPlano";
    }

    @Get(value = "/getPathVariable/{numero}")
    public String getPathVariable(@PathVariable Integer numero) {
        return "getPathVariable:" + numero;
    }

    @Get(uris = {"/persona/{nombre}", "p/{nombre}"})
    public String getPathVariableUris(@PathVariable String nombre) {
        return "getPathVariableUris:" + nombre;
    }

    @Get("/getHttpResponse")
    public HttpResponse<Respuesta> getHttpResponse() {
        Error error = new Error();
        error.setCodigo("campo");
        error.setMensaje("Error en este campo");
        List<Error> errores = new ArrayList<>();
        errores.add(error);
        Respuesta respuesta = new Respuesta();
        respuesta.setMensaje("Se presentaron los siguientes errores");
        respuesta.setErrores(errores);
        return HttpResponse.ok(respuesta);
    }


}
