package mx.octaviocervantes.mypetcare.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.octaviocervantes.mypetcare.R;
import mx.octaviocervantes.mypetcare.adapter.MascotaAdaptador;
import mx.octaviocervantes.mypetcare.datos.DatosMascota;
import mx.octaviocervantes.mypetcare.presentador.IMascotaFragmentPresenter;
import mx.octaviocervantes.mypetcare.presentador.MascotaFragmentPresenter;

public class MascotasFragment extends Fragment implements IMascotasFragment{

    IMascotaFragmentPresenter iMascotaFragmentPresenter;
    private RecyclerView listaMascotas;

    public MascotasFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mascotas, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        iMascotaFragmentPresenter = new MascotaFragmentPresenter(this, getContext());
        iMascotaFragmentPresenter.obtenerDatosMascotas();
        iMascotaFragmentPresenter.mostrarDatosMascota();

        return v;
    }

    @Override
    public void generarLinearLayout() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<DatosMascota> mascotas) {
        return new MascotaAdaptador(mascotas, getActivity());
    }

    @Override
    public void inicializarAdaptadorMascota(MascotaAdaptador mascotaAdaptador) {
        listaMascotas.setAdapter(mascotaAdaptador);
    }
}
