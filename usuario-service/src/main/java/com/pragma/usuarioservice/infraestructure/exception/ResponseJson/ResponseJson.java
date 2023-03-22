package com.pragma.usuarioservice.infraestructure.exception.ResponseJson;

public class ResponseJson {
    private String typo;
    private String mensaje;

    public ResponseJson(String typo, String mensaje) {
        this.typo = typo;
        this.mensaje = mensaje;
    }

    public ResponseJson() {
    }

    public String getTypo() {
        return typo;
    }

    public void setTypo(String typo) {
        this.typo = typo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
