package com.codigoelectronica.valueobjects.dto;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class Error {

    private String codigo;
    private String mensaje;

    public Error() {
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return this.mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "{" +
                " codigo='" + getCodigo() + "'" +
                ", mensaje='" + getMensaje() + "'" +
                "}";
    }

}
