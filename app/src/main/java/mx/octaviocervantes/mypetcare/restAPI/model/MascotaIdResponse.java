package mx.octaviocervantes.mypetcare.restAPI.model;

import java.util.ArrayList;

import mx.octaviocervantes.mypetcare.datos.MascotaIdInstagram;

public class MascotaIdResponse {

    ArrayList<MascotaIdInstagram> mascotas;

    public ArrayList<MascotaIdInstagram> getMascotas(){
        return mascotas;
    }

    public void setMascotas(ArrayList<MascotaIdInstagram> mascotas){
        this.mascotas = mascotas;
    }

}
