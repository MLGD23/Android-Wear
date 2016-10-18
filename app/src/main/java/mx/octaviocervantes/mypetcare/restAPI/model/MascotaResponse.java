package mx.octaviocervantes.mypetcare.restAPI.model;

import java.util.ArrayList;

import mx.octaviocervantes.mypetcare.datos.MascotaInstagram;

public class MascotaResponse{

	ArrayList<MascotaInstagram> mascotas;

	public ArrayList<MascotaInstagram> getMascotas(){
		return mascotas;
	}

	public void setMascotas(ArrayList<MascotaInstagram> mascotas){
		this.mascotas = mascotas;
	}
}