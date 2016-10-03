package mx.octaviocervantes.mypetcare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import mx.octaviocervantes.mypetcare.adapter.MascotaAdaptador;
import mx.octaviocervantes.mypetcare.datos.DatosMascota;
import mx.octaviocervantes.mypetcare.presentador.DetalleMascotaPresenter;
import mx.octaviocervantes.mypetcare.presentador.IDetalleMascotaPresenter;

public class DetalleMascota extends AppCompatActivity implements IDetalleMascota {

    RecyclerView rvDetalleMascotas;
    IDetalleMascotaPresenter iDetalleMascotaPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mascota_detalle);
        Toolbar actionBarMascota = (Toolbar) findViewById(R.id.actionBarMascota);
        setSupportActionBar(actionBarMascota);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvDetalleMascotas = (RecyclerView) findViewById(R.id.rvDetalleMascotas);

        iDetalleMascotaPresenter = new DetalleMascotaPresenter(this, getBaseContext());
        iDetalleMascotaPresenter.obtenerDatosMascotas();
        iDetalleMascotaPresenter.mostrarDatosMascota();
    }

    @Override
    public void generarLinearLayoutDetalleMascota() {
        LinearLayoutManager llmDetalle = new LinearLayoutManager(this);
        llmDetalle.setOrientation(LinearLayoutManager.VERTICAL);
        rvDetalleMascotas.setLayoutManager(llmDetalle);
    }

    @Override
    public MascotaAdaptador crearAdaptadorDetalleMascota(ArrayList<DatosMascota> detalleMascotas) {
        return new MascotaAdaptador(detalleMascotas, this);
    }

    @Override
    public void inicializarAdaptadorDetalleMascota(MascotaAdaptador mascotaAdaptador) {
        rvDetalleMascotas.setAdapter(mascotaAdaptador);
    }
}
