package mx.octaviocervantes.mypetcare.datos;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import mx.octaviocervantes.mypetcare.restAPI.ConstantesRestAPI;
import mx.octaviocervantes.mypetcare.restAPI.EndpointsAPI;
import mx.octaviocervantes.mypetcare.restAPI.EndpointsAPIFirebase;
import mx.octaviocervantes.mypetcare.restAPI.adapter.RestAPIAdapter;
import mx.octaviocervantes.mypetcare.restAPI.adapter.RestAPIFirebaseAdapter;
import mx.octaviocervantes.mypetcare.restAPI.model.MascotaLikeResponse;
import mx.octaviocervantes.mypetcare.restAPI.model.UsuarioFirebaseResponse;
import mx.octaviocervantes.mypetcare.restAPI.model.UsuarioLikeResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Metodos {
    Context context;
    private RestAPIAdapter restApiAdapter;
    private EndpointsAPI endpointsAPI;
    SharedPreferences shrd;
    boolean inicio = true;

    public Metodos(Context context) {
        this.context = context;
        restApiAdapter = new RestAPIAdapter();
        shrd = context.getSharedPreferences("datosInstagram", Context.MODE_PRIVATE);
    }

    public String mostrarDatos(){
        String idUser = shrd.getString("idUsuario", "");
        return idUser;
    }

    public String mostrarDatosUsuario(){
        String sUser = shrd.getString("usuario","");
        return sUser;
    }

    public void guardarDatos(String idUsuario, String sUsuario, boolean inicioApp){
        SharedPreferences.Editor edit = shrd.edit();

        edit.clear();

        edit.putString("idUsuario", idUsuario);
        edit.putString("usuario", sUsuario);
        edit.putBoolean("inicio", inicioApp);

        edit.commit();
    }

    public boolean inicioApp(){
        boolean inicio = shrd.getBoolean("inicio", true);
        return inicio;
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
        Log.d("BEFORE_Emisor", ConstantesRestAPI.ID_USUARIO);
        Log.d("BEFORE_Receptor", mostrarDatos());
        Log.d("BEFORE_FOTO", idFoto);

        RestAPIFirebaseAdapter restAPIFirebaseAdapter = new RestAPIFirebaseAdapter();
        EndpointsAPIFirebase endpointsAPIFirebase = restAPIFirebaseAdapter.establecerConexionRestAPI();
        Call<UsuarioLikeResponse> usuarioLikeResponseCall = endpointsAPIFirebase.registrarLikeUsuario(mostrarDatos(), ConstantesRestAPI.ID_USUARIO, idFoto);

        usuarioLikeResponseCall.enqueue(new Callback<UsuarioLikeResponse>() {
            @Override
            public void onResponse(Call<UsuarioLikeResponse> call, Response<UsuarioLikeResponse> response) {
                UsuarioLikeResponse usuarioLikeResponse = response.body();

                darLikeFoto(idFoto);
                Log.d("NOTIFICACION_USER", usuarioLikeResponse.getIdusuario());
                Log.d("NOTIFICACION_DVC", usuarioLikeResponse.getIddispositivo());
                Log.d("NOTIFICACION_FOTO", usuarioLikeResponse.getIdfoto());
                Log.d("NOTIFICACION", String.valueOf(usuarioLikeResponse.isNotificacion()));
                Log.d("NOTIFY", String.valueOf(usuarioLikeResponse.isNotify()));
            }

            @Override
            public void onFailure(Call<UsuarioLikeResponse> call, Throwable t) {

            }
        });

    }
}
