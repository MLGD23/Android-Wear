package mx.octaviocervantes.mypetcare.presentador;

import android.content.Context;

import java.util.ArrayList;

import mx.octaviocervantes.mypetcare.datos.DatosMascota;
import mx.octaviocervantes.mypetcare.db.ConstructorMascotas;
import mx.octaviocervantes.mypetcare.fragments.IMascotasFragment;

public class MascotaFragmentPresenter implements IMascotaFragmentPresenter {

    private ArrayList<DatosMascota> mascotas;
    private IMascotasFragment iMascotaFragment;
    Context context;
    ConstructorMascotas constructorMascotas;

    public MascotaFragmentPresenter(IMascotasFragment iMascotaFragment, Context context){
        this.iMascotaFragment = iMascotaFragment;
        this.context = context;
        constructorMascotas = new ConstructorMascotas(context);
    }

    @Override
    public void obtenerDatosMascotas() {
        mascotas = constructorMascotas.listarMascotas();

        if(mascotas.size() == 0){
            constructorMascotas.insertarDatoMascota();
        }
    }

    @Override
    public void mostrarDatosMascota() {
        iMascotaFragment.inicializarAdaptadorMascota(iMascotaFragment.crearAdaptador(mascotas));
        iMascotaFragment.generarLinearLayout();
    }

    @Override
    public ArrayList<DatosMascota> datosMascotas() {
        return mascotas;
    }
}
