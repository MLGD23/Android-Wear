package mx.octaviocervantes.mypetcare.fragments;

import java.util.ArrayList;

import mx.octaviocervantes.mypetcare.adapter.MascotaAdaptador;
import mx.octaviocervantes.mypetcare.datos.DatosMascota;

public interface IMascotasFragment {

    void generarLinearLayout();

    MascotaAdaptador crearAdaptador(ArrayList<DatosMascota> mascotas);

    void inicializarAdaptadorMascota(MascotaAdaptador mascotaAdaptador);
}
