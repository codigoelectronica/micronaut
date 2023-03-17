package com.codigoelectronica.infrastructure.web;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

@Controller
public class PeticionesGetController {
    

    @Get("/primer")
    public String primerEjemplo() {
        return "get";
    }

    @Get(value = "/segundo", produces = MediaType.TEXT_PLAIN)
    public String segundoEjemplo() {
        return "get-text_plain";
    }

    @Get(value = "/tercero/{numero}")
    public String terceroEjemplo(@PathVariable Integer numero) {
        return "get-path_variable:" + numero;
    }

    @Get(uris = {"/persona/{nombre}", "/{nombre}"})
    public String cuartoEjemplo(@PathVariable String nombre) {
        return "get-uris-path_variable:" + nombre;
    }

}
