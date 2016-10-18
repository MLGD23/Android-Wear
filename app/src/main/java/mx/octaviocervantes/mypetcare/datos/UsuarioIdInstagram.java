package mx.octaviocervantes.mypetcare.datos;

public class UsuarioIdInstagram {

    String sFotoUsuario, sNombreUsuario;
    int iSeguidores, iSeguidos;

    public UsuarioIdInstagram(int iSeguidores, int iSeguidos, String sFotoUsuario, String sNombreUsuario) {
        this.iSeguidores = iSeguidores;
        this.iSeguidos = iSeguidos;
        this.sFotoUsuario = sFotoUsuario;
        this.sNombreUsuario = sNombreUsuario;
    }

    public UsuarioIdInstagram() {
    }

    public int getiSeguidores() {
        return iSeguidores;
    }

    public void setiSeguidores(int iSeguidores) {
        this.iSeguidores = iSeguidores;
    }

    public int getiSeguidos() {
        return iSeguidos;
    }

    public void setiSeguidos(int iSeguidos) {
        this.iSeguidos = iSeguidos;
    }

    public String getsFotoUsuario() {
        return sFotoUsuario;
    }

    public void setsFotoUsuario(String sFotoUsuario) {
        this.sFotoUsuario = sFotoUsuario;
    }

    public String getsNombreUsuario() {
        return sNombreUsuario;
    }

    public void setsNombreUsuario(String sNombreUsuario) {
        this.sNombreUsuario = sNombreUsuario;
    }
}
