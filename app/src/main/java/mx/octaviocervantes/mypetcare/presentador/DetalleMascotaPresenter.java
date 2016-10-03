package mx.octaviocervantes.mypetcare.presentador;

import android.content.Context;

import java.util.ArrayList;

import mx.octaviocervantes.mypetcare.IDetalleMascota;
import mx.octaviocervantes.mypetcare.datos.DatosMascota;
import mx.octaviocervantes.mypetcare.db.ConstructorMascotas;
import mx.octaviocervantes.mypetcare.fragments.IMascotasFragment;

public class DetalleMascotaPresenter implements IDetalleMascotaPresenter {

    private ArrayList<DatosMascota> detalleMascotas;
    private IDetalleMascota iDetalleMascota;
    Context context;
    ConstructorMascotas constructorMascotas;

    public DetalleMascotaPresenter(IDetalleMascota iDetalleMascota, Context context) {
        this.iDetalleMascota = iDetalleMascota;
        this.context = context;
        constructorMascotas = new ConstructorMascotas(context);
    }

    @Override
    public void obtenerDatosMascotas() {
        detalleMascotas = constructorMascotas.listarDetalleMascotas();
    }

    @Override
    public void mostrarDatosMascota() {
        iDetalleMascota.inicializarAdaptadorDetalleMascota(iDetalleMascota.crearAdaptadorDetalleMascota(detalleMascotas));
        iDetalleMascota.generarLinearLayoutDetalleMascota();
    }

    @Override
    public ArrayList<DatosMascota> datosMascotas() {
        return detalleMascotas;
    }
}
