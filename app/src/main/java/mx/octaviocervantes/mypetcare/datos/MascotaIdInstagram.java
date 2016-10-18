package mx.octaviocervantes.mypetcare.datos;

public class MascotaIdInstagram {

    private String idUsuario;
    private String nombreUsuario;
    private String urlFoto;
    private int meGusta = 0;

    public MascotaIdInstagram() {
    }

    public MascotaIdInstagram(String idUsuario, int meGusta, String nombreUsuario, String urlFoto) {

        this.idUsuario = idUsuario;
        this.meGusta = meGusta;
        this.nombreUsuario = nombreUsuario;
        this.urlFoto = urlFoto;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getMeGusta() {
        return meGusta;
    }

    public void setMeGusta(int meGusta) {
        this.meGusta = meGusta;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}
