package mx.octaviocervantes.mypetcare.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import mx.octaviocervantes.mypetcare.IDetalleMascota;
import mx.octaviocervantes.mypetcare.LoginUsuario;
import mx.octaviocervantes.mypetcare.MascotasLista;
import mx.octaviocervantes.mypetcare.datos.MascotaIdInstagram;
import mx.octaviocervantes.mypetcare.datos.MascotaInstagram;
import mx.octaviocervantes.mypetcare.datos.Metodos;
import mx.octaviocervantes.mypetcare.datos.UsuarioIdInstagram;
import mx.octaviocervantes.mypetcare.datos.UsuarioInstagram;
import mx.octaviocervantes.mypetcare.datos.UsuarioSearchInstagram;
import mx.octaviocervantes.mypetcare.fragments.IPerfilFragment;
import mx.octaviocervantes.mypetcare.restAPI.EndpointsAPI;
import mx.octaviocervantes.mypetcare.restAPI.adapter.RestAPIAdapter;
import mx.octaviocervantes.mypetcare.restAPI.model.MascotaIdResponse;
import mx.octaviocervantes.mypetcare.restAPI.model.MascotaResponse;
import mx.octaviocervantes.mypetcare.restAPI.model.UsuarioIdResponse;
import mx.octaviocervantes.mypetcare.restAPI.model.UsuarioResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilMascotaPresenter implements IPerfilMascotaPresenter {

    //ArrayList<MascotaInstagram> mascotas;
    //ArrayList<UsuarioInstagram> usuarios;

    ArrayList<MascotaIdInstagram> mascotas;
    ArrayList<UsuarioIdInstagram> usuarios;
    Metodos m;
    private IPerfilFragment iDetalleMascota;
    Context context;
    RestAPIAdapter restApiAdapter;
    EndpointsAPI endpointsAPI;
    String idUser;

    public PerfilMascotaPresenter(Context context, IPerfilFragment iDetalleMascota) {
        this.context = context;
        this.iDetalleMascota = iDetalleMascota;
        restApiAdapter = new RestAPIAdapter();
        m = new Metodos(context.getApplicationContext());
        idUser = m.mostrarDatos();

        obtenerMediosRecientesUsuario();
        obtenerDatosUsuario();
    }

    @Override
    public void obtenerDatosMascotas() {}

    @Override
    public void obtenerMediosRecientesUsuario() {
        Gson gsonUser = restApiAdapter.construyeGsonDeserializadorMediaRecentUserId();
        endpointsAPI = restApiAdapter.establecerConexionRestAPIInstagram(gsonUser);
        Call<MascotaIdResponse> mascotaIdResponseCall = endpointsAPI.getRecentMediaUserId(idUser);

        mascotaIdResponseCall.enqueue(new Callback<MascotaIdResponse>() {
            @Override
            public void onResponse(Call<MascotaIdResponse> call, Response<MascotaIdResponse> response) {
                MascotaIdResponse usuarioResponse = response.body();
                mascotas = usuarioResponse.getMascotas();
                mostrarDatosMascota();
            }

            @Override
            public void onFailure(Call<MascotaIdResponse> call, Throwable t) {
                Toast.makeText(context, "Hubo un problema con la conexión para el usuario con ID, intenta nuevamente.", Toast.LENGTH_LONG).show();
                Log.e("Falló la conexión.", t.toString());
            }
        });
    }

    @Override
    public void obtenerDatosUsuario() {
        /*Gson gsonUser = restApiAdapter.construyeGsonDeserializadorUser();
        endpointsAPI = restApiAdapter.establecerConexionRestAPIInstagram(gsonUser);
        Call<UsuarioResponse> usuarioResponseCall = endpointsAPI.getUser();

        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                UsuarioResponse usuarioResponse = response.body();
                usuarios = usuarioResponse.getUsuarios();
                mostrarDatosUsuario();
            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {
                Toast.makeText(context, "Hubo un problema con la conexión para el usuario,, intenta nuevamente.", Toast.LENGTH_LONG).show();
                Log.e("Falló la conexión.", t.toString());
            }
        });*/
        Gson gsonUser = restApiAdapter.construyeGsonDeserializadorUserId();
        endpointsAPI = restApiAdapter.establecerConexionRestAPIInstagram(gsonUser);
        Call<UsuarioIdResponse> usuarioResponseCall = endpointsAPI.getUserId(idUser);

        usuarioResponseCall.enqueue(new Callback<UsuarioIdResponse>() {
            @Override
            public void onResponse(Call<UsuarioIdResponse> call, Response<UsuarioIdResponse> response) {
                UsuarioIdResponse usuarioResponse = response.body();
                usuarios = usuarioResponse.getUsuarios();
                mostrarDatosUsuario();
            }

            @Override
            public void onFailure(Call<UsuarioIdResponse> call, Throwable t) {
                Toast.makeText(context, "Hubo un problema con la conexión para el usuario,, intenta nuevamente.", Toast.LENGTH_LONG).show();
                Log.e("Falló la conexión.", t.toString());
            }
        });
    }

    @Override
    public void mostrarDatosMascota() {
        iDetalleMascota.inicializarAdaptadorMascota(iDetalleMascota.crearAdaptador(mascotas));
        iDetalleMascota.generarGridLayout();
    }

    @Override
    public void mostrarDatosUsuario() {
        iDetalleMascota.mostrarDatosUsuario(usuarios);
    }

    @Override
    public ArrayList<MascotaIdInstagram> datosMascotas() {
        return mascotas;
    }
}
