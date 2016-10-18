package mx.octaviocervantes.mypetcare.restAPI.model;

import java.util.ArrayList;
import mx.octaviocervantes.mypetcare.datos.UsuarioInstagram;

public class UsuarioResponse {

    ArrayList<UsuarioInstagram> usuarios;

    public ArrayList<UsuarioInstagram> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<UsuarioInstagram> usuarios) {
        this.usuarios = usuarios;
    }
}
