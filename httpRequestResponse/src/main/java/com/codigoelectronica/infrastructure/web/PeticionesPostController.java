package com.codigoelectronica.infrastructure.web;

import com.codigoelectronica.valueobjects.command.Contacto;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

@Controller
public class PeticionesPostController {
    
    @Post("/simplePost")
    public String simplePost() {
        return "simplePost";
    }

    @Post("/postBody")
    public String postBody(@Body Contacto contacto) {
        return contacto.getNombre();
    }

    @Post("/postBodyHttpResponse")
    public HttpResponse postBodyHttpResponse(@Body Contacto contacto) {
        return HttpResponse.ok();
    }

}
