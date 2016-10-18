package mx.octaviocervantes.mypetcare.datos;

public class UsuarioSearchInstagram {
    String idUser;
    String sUser;

    public UsuarioSearchInstagram(String idUser, String sUser) {
        this.idUser = idUser;
        this.sUser = sUser;
    }

    public UsuarioSearchInstagram() {
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getsUser() {
        return sUser;
    }

    public void setsUser(String sUser) {
        this.sUser = sUser;
    }
}
