package mx.octaviocervantes.mypetcare.restAPI.model;

import java.util.ArrayList;

import mx.octaviocervantes.mypetcare.datos.UsuarioIdInstagram;

public class UsuarioIdResponse {

    ArrayList<UsuarioIdInstagram> usuarios;

    public ArrayList<UsuarioIdInstagram> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<UsuarioIdInstagram> usuarios) {
        this.usuarios = usuarios;
    }

}
