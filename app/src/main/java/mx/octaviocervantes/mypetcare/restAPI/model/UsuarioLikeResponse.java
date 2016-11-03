package mx.octaviocervantes.mypetcare.restAPI.model;

/**
 * Created by Tavo on 31/10/2016.
 */
public class UsuarioLikeResponse {
    private String id;
    private String idusuario;
    private String iddispositivo;
    private String idfoto;
    private boolean notify;

    public UsuarioLikeResponse(String id, String iddispositivo, String idfoto, String idusuario, boolean notify) {
        this.id = id;
        this.iddispositivo = iddispositivo;
        this.idfoto = idfoto;
        this.idusuario = idusuario;
        this.notify = notify;
    }

    public UsuarioLikeResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIddispositivo() {
        return iddispositivo;
    }

    public void setIddispositivo(String iddispositivo) {
        this.iddispositivo = iddispositivo;
    }

    public String getIdfoto() {
        return idfoto;
    }

    public void setIdfoto(String idfoto) {
        this.idfoto = idfoto;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public boolean isNotify() {
        return notify;
    }

    public void setNotify(boolean notify) {
        this.notify = notify;
    }
}
