package mx.octaviocervantes.mypetcare.restAPI.model;

import java.util.ArrayList;

import mx.octaviocervantes.mypetcare.datos.UsuarioSearchInstagram;

public class UsuarioSearchResponse {

    ArrayList<UsuarioSearchInstagram> usuario;

    public ArrayList<UsuarioSearchInstagram> getUsuario(){
        return usuario;
    }

    public void setUsuario(ArrayList<UsuarioSearchInstagram> usuario){
        this.usuario = usuario;
    }

}
