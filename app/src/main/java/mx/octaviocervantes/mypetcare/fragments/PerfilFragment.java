package mx.octaviocervantes.mypetcare.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import mx.octaviocervantes.mypetcare.R;
import mx.octaviocervantes.mypetcare.adapter.FotoMascotaAdaptador;
import mx.octaviocervantes.mypetcare.adapter.MascotaAdaptador;
import mx.octaviocervantes.mypetcare.datos.DatosMascota;
import mx.octaviocervantes.mypetcare.datos.FotosDatosMascota;
import mx.octaviocervantes.mypetcare.datos.MascotaIdInstagram;
import mx.octaviocervantes.mypetcare.datos.MascotaInstagram;
import mx.octaviocervantes.mypetcare.datos.UsuarioIdInstagram;
import mx.octaviocervantes.mypetcare.datos.UsuarioInstagram;
import mx.octaviocervantes.mypetcare.presentador.PerfilMascotaPresenter;

public class PerfilFragment extends Fragment implements IPerfilFragment {

    private RecyclerView rvFotosMascotas;
    private PerfilMascotaPresenter perfilMascotaPresenter;
    private CircularImageView imgCMascota;
    private TextView txtNombreMascota;
    private TextView tvNoSeguidores;
    private TextView tvNoSeguidos;

    public PerfilFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        rvFotosMascotas = (RecyclerView) v.findViewById(R.id.rvFotosMascota);
        perfilMascotaPresenter = new PerfilMascotaPresenter(getContext(), this);
        imgCMascota = (CircularImageView) v.findViewById(R.id.imgCMascota);
        txtNombreMascota = (TextView) v.findViewById(R.id.txtNombreMascota);
        tvNoSeguidores = (TextView) v.findViewById(R.id.tvNoSeguidores);
        tvNoSeguidos = (TextView) v.findViewById(R.id.tvNoSeguidos);

        return v;
    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager glm = new GridLayoutManager(getContext(), 2);
        rvFotosMascotas.setLayoutManager(glm);
    }

    @Override
    public FotoMascotaAdaptador crearAdaptador(ArrayList<MascotaIdInstagram> fotosMascotas) {
        return new FotoMascotaAdaptador(fotosMascotas, getContext());
    }

    @Override
    public void inicializarAdaptadorMascota(FotoMascotaAdaptador mascotaAdaptador) {
        rvFotosMascotas.setAdapter(mascotaAdaptador);
    }

    @Override
    public void mostrarDatosUsuario(ArrayList<UsuarioIdInstagram> usuarioInstagram) {
        Picasso.with(getContext())
                .load(usuarioInstagram.get(0).getsFotoUsuario())
                .placeholder(R.drawable.golden)
                .into(imgCMascota);
        txtNombreMascota.setText(usuarioInstagram.get(0).getsNombreUsuario());
        tvNoSeguidores.setText(String.valueOf(usuarioInstagram.get(0).getiSeguidores()));
        tvNoSeguidos.setText(String.valueOf(usuarioInstagram.get(0).getiSeguidos()));
    }
}
