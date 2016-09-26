package mx.octaviocervantes.mypetcare.datos;

/**
 * Created by Tavo on 22/09/2016.
 */
public class DatosContactoCorreo {
    private String sNombreCorreo;
    private String sCorreoElectronico;
    private String sMensajeCorreo;

    public DatosContactoCorreo(String sNombreCorreo, String sCorreoElectronico, String sMensajeCorreo) {
        this.sCorreoElectronico = sCorreoElectronico;
        this.sMensajeCorreo = sMensajeCorreo;
        this.sNombreCorreo = sNombreCorreo;
    }

    public String getsCorreoElectronico() {
        return sCorreoElectronico;
    }

    public void setsCorreoElectronico(String sCorreoElectronico) {
        this.sCorreoElectronico = sCorreoElectronico;
    }

    public String getsMensajeCorreo() {
        return sMensajeCorreo;
    }

    public void setsMensajeCorreo(String sMensajeCorreo) {
        this.sMensajeCorreo = sMensajeCorreo;
    }

    public String getsNombreCorreo() {
        return sNombreCorreo;
    }

    public void setsNombreCorreo(String sNombreCorreo) {
        this.sNombreCorreo = sNombreCorreo;
    }
}
