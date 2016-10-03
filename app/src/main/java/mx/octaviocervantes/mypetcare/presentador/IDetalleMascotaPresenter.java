package mx.octaviocervantes.mypetcare.presentador;

import java.util.ArrayList;

import mx.octaviocervantes.mypetcare.datos.DatosMascota;

public interface IDetalleMascotaPresenter {

    void obtenerDatosMascotas();

    void mostrarDatosMascota();

    ArrayList<DatosMascota> datosMascotas();
}
