package mx.octaviocervantes.mypetcare.restAPI.model;

public class UsuarioFirebaseResponse {
    private String id;
    private String idUsuario;
    private String idDispositivo;
    private String sUsuario;

    public UsuarioFirebaseResponse() {
    }

    public UsuarioFirebaseResponse(String id, String idUsuario, String sUsuario, String idDispositivo) {

        this.id = id;
        this.idDispositivo = idDispositivo;
        this.idUsuario = idUsuario;
        this.sUsuario = sUsuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(String idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getsUsuario() {
        return sUsuario;
    }

    public void setsUsuario(String sUsuario) {
        this.sUsuario = sUsuario;
    }
}
