package mx.octaviocervantes.mypetcare.restAPI.model;

public class UsuarioFirebaseResponse {
    private String id;
    private String idusuario;
    private String iddispositivo;
    private String susuario;

    public UsuarioFirebaseResponse() {
    }

    public UsuarioFirebaseResponse(String id, String idusuario, String susuario, String iddispositivo) {
        this.id = id;
        this.idusuario = idusuario;
        this.susuario = susuario;
        this.iddispositivo = iddispositivo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdDispositivo() {
        return iddispositivo;
    }

    public void setIdDispositivo(String iddispositivo) {
        this.iddispositivo = iddispositivo;
    }

    public String getIdUsuario() {
        return idusuario;
    }

    public void setIdUsuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getsUsuario() {
        return susuario;
    }

    public void setsUsuario(String susuario) {
        this.susuario = susuario;
    }
}
