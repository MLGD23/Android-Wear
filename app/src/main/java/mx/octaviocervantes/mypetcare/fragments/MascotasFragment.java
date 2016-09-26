package mx.octaviocervantes.mypetcare.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.octaviocervantes.mypetcare.DetalleMascota;
import mx.octaviocervantes.mypetcare.R;
import mx.octaviocervantes.mypetcare.adapter.MascotaAdaptador;
import mx.octaviocervantes.mypetcare.datos.DatosMascota;

/**
 * Created by Tavo on 22/09/2016.
 */
public class MascotasFragment extends Fragment {

    private ArrayList<DatosMascota> mascotas;
    private ArrayList<Integer> posicionesMascotas;
    private RecyclerView listaMascotas;

    public MascotasFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mascotas, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        llenarDatosMascotas();
        inicializarAdaptador();

        return v;
    }

    //Inicia el adaptador
    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    //Datos de las mascotas
    private void llenarDatosMascotas(){
        mascotas = new ArrayList<DatosMascota>();

        mascotas.add(new DatosMascota("Willy", "4", R.drawable.beagle));
        mascotas.add(new DatosMascota("Toby", "4", R.drawable.alaska));
        mascotas.add(new DatosMascota("Bruno", "2", R.drawable.collie));
        mascotas.add(new DatosMascota("Simba", "3", R.drawable.pastor_aleman));
        mascotas.add(new DatosMascota("Bucky", "5", R.drawable.golden));
    }

    //Mostrar Mascotas Favoritas
    public void verDetalleMascotas(){
        posicionesMascotas = new ArrayList<Integer>();

        posicionesMascotas.add(Integer.parseInt(mascotas.get(0).getRatingMascota()));
        posicionesMascotas.add(Integer.parseInt(mascotas.get(1).getRatingMascota()));
        posicionesMascotas.add(Integer.parseInt(mascotas.get(2).getRatingMascota()));
        posicionesMascotas.add(Integer.parseInt(mascotas.get(3).getRatingMascota()));
        posicionesMascotas.add(Integer.parseInt(mascotas.get(4).getRatingMascota()));

        Intent intent = new Intent(getActivity(), DetalleMascota.class);
        intent.putExtra(getResources().getString(R.string.pMascota), posicionesMascotas);
        startActivity(intent);
    }
}
