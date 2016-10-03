package mx.octaviocervantes.mypetcare;

import java.util.ArrayList;

import mx.octaviocervantes.mypetcare.adapter.MascotaAdaptador;
import mx.octaviocervantes.mypetcare.datos.DatosMascota;

public interface IDetalleMascota {

    void generarLinearLayoutDetalleMascota();

    MascotaAdaptador crearAdaptadorDetalleMascota(ArrayList<DatosMascota> detalleMascotas);

    void inicializarAdaptadorDetalleMascota(MascotaAdaptador mascotaAdaptador);
}
