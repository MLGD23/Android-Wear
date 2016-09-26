package mx.octaviocervantes.mypetcare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import mx.octaviocervantes.mypetcare.adapter.MascotaAdaptador;
import mx.octaviocervantes.mypetcare.datos.DatosMascota;

public class DetalleMascota extends AppCompatActivity {

    ArrayList<DatosMascota> listaDetalleMascota;
    ArrayList<Integer> posicionesMascotas;
    RecyclerView rvDetalleMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mascota_detalle);

        final Bundle parametros = getIntent().getExtras();
        posicionesMascotas = parametros.getIntegerArrayList(getResources().getString(R.string.pMascota));

        Toolbar actionBarMascota = (Toolbar) findViewById(R.id.actionBarMascota);
        setSupportActionBar(actionBarMascota);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvDetalleMascotas = (RecyclerView) findViewById(R.id.rvDetalleMascotas);
        LinearLayoutManager llmDetalle = new LinearLayoutManager(this);
        llmDetalle.setOrientation(LinearLayoutManager.VERTICAL);
        rvDetalleMascotas.setLayoutManager(llmDetalle);

        llenarDatosDetalleMascotas();
        inicializarAdaptador();

    }

    //Inicia el adaptador
    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(listaDetalleMascota);
        rvDetalleMascotas.setAdapter(adaptador);
    }

    //Llenar recycler view con información de perritos.
    public void llenarDatosDetalleMascotas(){
        listaDetalleMascota = new ArrayList<DatosMascota>();

        listaDetalleMascota.add(new DatosMascota("Willy", String.valueOf(posicionesMascotas.get(0)), R.drawable.beagle));
        listaDetalleMascota.add(new DatosMascota("Toby", String.valueOf(posicionesMascotas.get(1)), R.drawable.alaska));
        listaDetalleMascota.add(new DatosMascota("Bruno", String.valueOf(posicionesMascotas.get(2)), R.drawable.collie));
        listaDetalleMascota.add(new DatosMascota("Simba", String.valueOf(posicionesMascotas.get(3)), R.drawable.pastor_aleman));
        listaDetalleMascota.add(new DatosMascota("Bucky", String.valueOf(posicionesMascotas.get(4)), R.drawable.golden));

        Collections.sort(listaDetalleMascota, new Comparator<DatosMascota>() {
            @Override
            public int compare(DatosMascota m1, DatosMascota m2) {
                return new Integer(m2.getRatingMascota()).compareTo(new Integer(m1.getRatingMascota()));
            }
        });
    }
}
