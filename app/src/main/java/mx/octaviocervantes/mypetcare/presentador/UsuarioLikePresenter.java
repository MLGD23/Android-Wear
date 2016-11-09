package mx.octaviocervantes.mypetcare.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import mx.octaviocervantes.mypetcare.IUsuarioLike;
import mx.octaviocervantes.mypetcare.datos.MascotaIdInstagram;
import mx.octaviocervantes.mypetcare.datos.Metodos;
import mx.octaviocervantes.mypetcare.datos.UsuarioIdInstagram;
import mx.octaviocervantes.mypetcare.datos.UsuarioSearchInstagram;
import mx.octaviocervantes.mypetcare.restAPI.ConstantesRestAPI;
import mx.octaviocervantes.mypetcare.restAPI.EndpointsAPI;
import mx.octaviocervantes.mypetcare.restAPI.adapter.RestAPIAdapter;
import mx.octaviocervantes.mypetcare.restAPI.model.MascotaIdResponse;
import mx.octaviocervantes.mypetcare.restAPI.model.UsuarioIdResponse;
import mx.octaviocervantes.mypetcare.restAPI.model.UsuarioSearchResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsuarioLikePresenter implements IUsuarioLikePresenter {

    ArrayList<MascotaIdInstagram> usuariosLike;
    ArrayList<UsuarioIdInstagram> usuarios;
    ArrayList<UsuarioSearchInstagram> usuarioSearchInstagram;
    Metodos m;
    private IUsuarioLike iDetalleUsuarioLike;
    Context context;
    RestAPIAdapter restApiAdapter;
    EndpointsAPI endpointsAPI;
    String idUser, sUser;

    public UsuarioLikePresenter(Context context, IUsuarioLike iDetalleUsuarioLike) {
        this.context = context;
        this.iDetalleUsuarioLike = iDetalleUsuarioLike;
        m = new Metodos(context);
        restApiAdapter = new RestAPIAdapter();

        idUser = m.mostrarIdUsuarioLike();
        sUser = m.mostrarUsuarioLike();

        obtenerMediosRecientesUsuarioLike();
        obtenerDatosUsuarioLike();
    }

    @Override
    public void obtenerDatosUsuarioLike() {
        Gson gsonUser = restApiAdapter.construyeGsonDeserializadorUserId();
        endpointsAPI = restApiAdapter.establecerConexionRestAPIInstagram(gsonUser);
        Call<UsuarioIdResponse> usuarioResponseCall = endpointsAPI.getUserId(idUser);

        usuarioResponseCall.enqueue(new Callback<UsuarioIdResponse>() {
            @Override
            public void onResponse(Call<UsuarioIdResponse> call, Response<UsuarioIdResponse> response) {
                UsuarioIdResponse usuarioResponse = response.body();
                usuarios = usuarioResponse.getUsuarios();
                mostrarInfoUsuarioLike();
            }

            @Override
            public void onFailure(Call<UsuarioIdResponse> call, Throwable t) {
                Log.e("Falló la conexión.", t.toString());
            }
        });
    }

    @Override
    public void obtenerMediosRecientesUsuarioLike() {
        Gson gsonUser = restApiAdapter.construyeGsonDeserializadorMediaRecentUserId();
        endpointsAPI = restApiAdapter.establecerConexionRestAPIInstagram(gsonUser);
        Call<MascotaIdResponse> mascotaIdResponseCall = endpointsAPI.getRecentMediaUserId(idUser);

        mascotaIdResponseCall.enqueue(new Callback<MascotaIdResponse>() {
            @Override
            public void onResponse(Call<MascotaIdResponse> call, Response<MascotaIdResponse> response) {
                MascotaIdResponse usuarioResponse = response.body();
                usuariosLike = usuarioResponse.getMascotas();
                mostrarDatosUsuarioLike();
            }

            @Override
            public void onFailure(Call<MascotaIdResponse> call, Throwable t) {
                Log.e("Falló la conexión.", t.toString());
            }
        });
    }

    @Override
    public void mostrarDatosUsuarioLike() {
        iDetalleUsuarioLike.inicializarAdaptadorUsuarioLike(iDetalleUsuarioLike.crearAdaptador(usuariosLike));
        iDetalleUsuarioLike.generarGridLayout();
    }

    @Override
    public void mostrarInfoUsuarioLike() {
        iDetalleUsuarioLike.mostrarDatosUserLike(usuarios);
    }

    @Override
    public ArrayList<MascotaIdInstagram> datosUsuarioLike() {
        return usuariosLike;
    }
}
