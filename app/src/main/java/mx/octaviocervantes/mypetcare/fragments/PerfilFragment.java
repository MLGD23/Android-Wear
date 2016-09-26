package mx.octaviocervantes.mypetcare.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.octaviocervantes.mypetcare.R;
import mx.octaviocervantes.mypetcare.adapter.FotoMascotaAdaptador;
import mx.octaviocervantes.mypetcare.datos.FotosDatosMascota;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    private ArrayList<FotosDatosMascota> fotosMascotas;
    private RecyclerView rvFotosMascotas;

    public PerfilFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        rvFotosMascotas = (RecyclerView) v.findViewById(R.id.rvFotosMascota);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        rvFotosMascotas.setLayoutManager(glm);

        llenarFotosMascota();
        inicializarAdaptador();

        return v;
    }

    //Inicia el adaptador
    public void inicializarAdaptador(){
        FotoMascotaAdaptador adaptador = new FotoMascotaAdaptador(fotosMascotas);
        rvFotosMascotas.setAdapter(adaptador);
    }

    private void llenarFotosMascota(){
        fotosMascotas = new ArrayList<FotosDatosMascota>();

        fotosMascotas.add(new FotosDatosMascota(R.drawable.golden_1, "22"));
        fotosMascotas.add(new FotosDatosMascota(R.drawable.golden_2, "4"));
        fotosMascotas.add(new FotosDatosMascota(R.drawable.golden_3, "17"));

        fotosMascotas.add(new FotosDatosMascota(R.drawable.golden_4, "6"));
        fotosMascotas.add(new FotosDatosMascota(R.drawable.golden_5, "0"));
        fotosMascotas.add(new FotosDatosMascota(R.drawable.golden_6, "5"));

        fotosMascotas.add(new FotosDatosMascota(R.drawable.golden_7, "9"));
        fotosMascotas.add(new FotosDatosMascota(R.drawable.golden_8, "14"));
        fotosMascotas.add(new FotosDatosMascota(R.drawable.golden_9, "11"));

        fotosMascotas.add(new FotosDatosMascota(R.drawable.golden_10, "10"));
        fotosMascotas.add(new FotosDatosMascota(R.drawable.golden_11, "8"));
        fotosMascotas.add(new FotosDatosMascota(R.drawable.golden_12, "3"));
    }
}
