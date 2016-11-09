package mx.octaviocervantes.mypetcare.datos;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;

import mx.octaviocervantes.mypetcare.restAPI.EndpointsAPI;
import mx.octaviocervantes.mypetcare.restAPI.EndpointsAPIFirebase;
import mx.octaviocervantes.mypetcare.restAPI.adapter.RestAPIAdapter;
import mx.octaviocervantes.mypetcare.restAPI.adapter.RestAPIFirebaseAdapter;
import mx.octaviocervantes.mypetcare.restAPI.model.MascotaLikeResponse;
import mx.octaviocervantes.mypetcare.restAPI.model.UsuarioLikeResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Tavo on 02/11/2016.
 */
public class MetodosRestAPI {

    RestAPIAdapter restApiAdapter;
    private EndpointsAPI endpointsAPI;
    Context context;
    Metodos metodos;

    public MetodosRestAPI(Context context) {
        this.context = context;
        metodos = new Metodos(context);
        restApiAdapter = new RestAPIAdapter();
    }

    public void darLikeFoto(String idfoto){
        Gson gsonUser = restApiAdapter.construyeGsonDeserializadorUserPhotoLike();
        endpointsAPI = restApiAdapter.establecerConexionRestAPIInstagram(gsonUser);
        Call<MascotaLikeResponse> mascotaLikeResponseCall = endpointsAPI.setLikeUserPhoto(idfoto);

        mascotaLikeResponseCall.enqueue(new Callback<MascotaLikeResponse>() {
            @Override
            public void onResponse(Call<MascotaLikeResponse> call, Response<MascotaLikeResponse> response) {
                MascotaLikeResponse mascotaLikeResponse = response.body();
                Log.d("PHOTO_LIKE", mascotaLikeResponse.getCodigoRespuesta());
            }

            @Override
            public void onFailure(Call<MascotaLikeResponse> call, Throwable t) {
                Toast.makeText(context, "Hubo un problema al dar like a la foto.", Toast.LENGTH_LONG).show();
                Log.e("Falló la conexión.", t.toString());
            }
        });
    }

    public void registroLike(final String idFoto){
        String token = FirebaseInstanceId.getInstance().getToken();

        Log.d("BEFORE_Receptor", metodos.mostrarDatos());
        Log.d("BEFORE_FOTO", idFoto);
        Log.d("DISPOSITIVO_EMISOR", token);

        RestAPIFirebaseAdapter restAPIFirebaseAdapter = new RestAPIFirebaseAdapter();
        EndpointsAPIFirebase endpointsAPIFirebase = restAPIFirebaseAdapter.establecerConexionRestAPI();
        Call<UsuarioLikeResponse> usuarioLikeResponseCall = endpointsAPIFirebase.registrarLikeUsuario(metodos.mostrarDatos(), idFoto, token);

        usuarioLikeResponseCall.enqueue(new Callback<UsuarioLikeResponse>() {
            @Override
            public void onResponse(Call<UsuarioLikeResponse> call, Response<UsuarioLikeResponse> response) {
                UsuarioLikeResponse usuarioLikeResponse = response.body();

                Log.d("NOTIFICACION_USER", " " + usuarioLikeResponse.getIdusuario());
                Log.d("NOTIFICACION_DVC", " " + usuarioLikeResponse.getIddispositivo());
                Log.d("NOTIFICACION_FOTO", " " + usuarioLikeResponse.getIdfoto());
                Log.d("NOTIFY", " " + String.valueOf(usuarioLikeResponse.isNotify()));
            }

            @Override
            public void onFailure(Call<UsuarioLikeResponse> call, Throwable t) {

            }
        });

    }
}
