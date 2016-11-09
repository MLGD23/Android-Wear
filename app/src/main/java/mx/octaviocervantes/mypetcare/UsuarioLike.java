package mx.octaviocervantes.mypetcare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import mx.octaviocervantes.mypetcare.adapter.FotoMascotaAdaptador;
import mx.octaviocervantes.mypetcare.adapter.UsuarioLikeAdapter;
import mx.octaviocervantes.mypetcare.datos.MascotaIdInstagram;
import mx.octaviocervantes.mypetcare.datos.UsuarioIdInstagram;
import mx.octaviocervantes.mypetcare.presentador.PerfilMascotaPresenter;
import mx.octaviocervantes.mypetcare.presentador.UsuarioLikePresenter;

public class UsuarioLike extends AppCompatActivity implements IUsuarioLike {

    private RecyclerView rvFotosUsuario;
    private UsuarioLikePresenter usuarioLikePresenter;
    private CircularImageView imgCUsuario;
    private TextView txtNombreUsuarioLike;
    private TextView tvNoSeguidoresUsuario;
    private TextView tvNoSeguidosUsuario;

    public UsuarioLike() {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usuario_like);
        Toolbar actionBarMascota = (Toolbar) findViewById(R.id.actionBarMascota);
        setSupportActionBar(actionBarMascota);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvFotosUsuario = (RecyclerView) findViewById(R.id.rvFotosUsuario);
        usuarioLikePresenter = new UsuarioLikePresenter(getBaseContext(), this);
        imgCUsuario = (CircularImageView) findViewById(R.id.imgCUsuario);
        txtNombreUsuarioLike = (TextView) findViewById(R.id.txtNombreUsuarioLike);
        tvNoSeguidoresUsuario = (TextView) findViewById(R.id.tvNoSeguidoresUsuario);
        tvNoSeguidosUsuario = (TextView) findViewById(R.id.tvNoSeguidosUsuario);
    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager glm = new GridLayoutManager(this, 2);
        rvFotosUsuario.setLayoutManager(glm);
    }

    @Override
    public UsuarioLikeAdapter crearAdaptador(ArrayList<MascotaIdInstagram> usuariosLike) {
        return new UsuarioLikeAdapter(usuariosLike, getBaseContext());
    }

    @Override
    public void inicializarAdaptadorUsuarioLike(UsuarioLikeAdapter usuarioLikeAdapter) {
        rvFotosUsuario.setAdapter(usuarioLikeAdapter);
    }

    @Override
    public void mostrarDatosUserLike(ArrayList<UsuarioIdInstagram> usuarioInstagram) {
        Picasso.with(getBaseContext())
                .load(usuarioInstagram.get(0).getsFotoUsuario())
                .placeholder(R.drawable.golden)
                .into(imgCUsuario);
        txtNombreUsuarioLike.setText(usuarioInstagram.get(0).getsNombreUsuario());
        tvNoSeguidoresUsuario.setText(String.valueOf(usuarioInstagram.get(0).getiSeguidores()));
        tvNoSeguidosUsuario.setText(String.valueOf(usuarioInstagram.get(0).getiSeguidos()));
    }
}
