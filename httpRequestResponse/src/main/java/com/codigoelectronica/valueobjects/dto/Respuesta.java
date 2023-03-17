package com.codigoelectronica.valueobjects.dto;

import java.util.List;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class Respuesta {
    private String mensaje;
    private List<Error> errores;

    public Respuesta() {
    }

    public String getMensaje() {
        return this.mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Error> getErrores() {
        return this.errores;
    }

    public void setErrores(List<Error> errores) {
        this.errores = errores;
    }

    @Override
    public String toString() {
        return "{" +
                " mensaje='" + getMensaje() + "'" +
                ", errores='" + getErrores() + "'" +
                "}";
    }

}
