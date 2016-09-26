package mx.octaviocervantes.mypetcare.datos;

/**
 * Created by Tavo on 19/09/2016.
 */
public class DatosContacto {
    private String nombreContacto;
    private String correoContacto;
    private String mensajeContacto;

    public DatosContacto(String correoContacto, String mensajeContacto, String nombreContacto) {
        this.correoContacto = correoContacto;
        this.mensajeContacto = mensajeContacto;
        this.nombreContacto = nombreContacto;
    }

    public String getCorreoContacto() {
        return correoContacto;
    }

    public void setCorreoContacto(String correoContacto) {
        this.correoContacto = correoContacto;
    }

    public String getMensajeContacto() {
        return mensajeContacto;
    }

    public void setMensajeContacto(String mensajeContacto) {
        this.mensajeContacto = mensajeContacto;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }
}
