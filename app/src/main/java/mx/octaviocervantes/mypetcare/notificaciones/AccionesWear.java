package mx.octaviocervantes.mypetcare.notificaciones;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import mx.octaviocervantes.mypetcare.MascotasLista;
import mx.octaviocervantes.mypetcare.UsuarioLike;
import mx.octaviocervantes.mypetcare.datos.Constantes;
import mx.octaviocervantes.mypetcare.datos.Metodos;
import mx.octaviocervantes.mypetcare.restAPI.ConstantesRestAPI;
import mx.octaviocervantes.mypetcare.restAPI.ConstantesRestAPIFirebase;
import mx.octaviocervantes.mypetcare.restAPI.EndpointsAPI;
import mx.octaviocervantes.mypetcare.restAPI.adapter.RestAPIAdapter;
import mx.octaviocervantes.mypetcare.restAPI.model.MascotaIdResponse;
import mx.octaviocervantes.mypetcare.restAPI.model.UsuarioFollowResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Tavo on 06/11/2016.
 */
public class AccionesWear extends BroadcastReceiver {

    private static final int NOTIFY_ID = 001;
    String tipoAccion;
    Metodos metodos;

    @Override
    public void onReceive(Context context, Intent intent) {
        tipoAccion = intent.getAction();
        metodos = new Metodos(context);

        if(Constantes.KEY_MY_PROFILE.equals(tipoAccion)) {
            Intent intentPerfil = new Intent(context, MascotasLista.class);
            intentPerfil.putExtra("tab", 2);
            intentPerfil.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intentPerfil);
            Log.d("BROADCAST_RECEIVER", "Se ejecutó la acción 'Mi Perfil'");
        }else{
            if(Constantes.KEY_FOLLOWS.equals(tipoAccion)){
                revisarRelacion(context);
                Log.d("BROADCAST_RECEIVER", "Se ejecutó la acción 'Follow / Unfollow'");
            }else {
                if (Constantes.KEY_USER_PROFILE.equals(tipoAccion)) {
                    Intent intentUserPerfil = new Intent(context, UsuarioLike.class);
                    intentUserPerfil.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intentUserPerfil);

                    Log.d("BROADCAST_RECEIVER", "Se ejecutó la acción 'Ver Usuario'");
                }
            }
        }

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(NOTIFY_ID);
    }

    private void revisarRelacion(final Context context){
        RestAPIAdapter restApiAdapter = new RestAPIAdapter();
        Gson gsonUser = restApiAdapter.construyeGsonDeserializadorGetRelationship();
        EndpointsAPI endpointsAPI = restApiAdapter.establecerConexionRestAPIInstagram(gsonUser);
        Call<UsuarioFollowResponse> usuarioFollowResponseCall = endpointsAPI.getRelationship(metodos.mostrarIdUsuarioLike());

        usuarioFollowResponseCall.enqueue(new Callback<UsuarioFollowResponse>() {
            @Override
            public void onResponse(Call<UsuarioFollowResponse> call, Response<UsuarioFollowResponse> response) {
                UsuarioFollowResponse usuarioFollowResponse = response.body();
                if(usuarioFollowResponse.getCodigoRespuesta().equals("200")){
                    if(usuarioFollowResponse.getOutgoing_status().equals("follows")){
                        Log.d("RELATION_STATUS", "Unfollow");
                        darFollowUnfollow("unfollow", context);
                    } else {
                        Log.d("RELATION_STATUS", "Follow");
                        darFollowUnfollow("follow", context);
                    }
                } else {
                    Toast.makeText(context, "No se ha podido ejecutar la acción de follow.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UsuarioFollowResponse> call, Throwable t) {
                Toast.makeText(context, "Error al realizar la conexión A.", Toast.LENGTH_SHORT).show();
                Log.e("ERROR", "Mi error", t);
            }
        });
    }

    private void darFollowUnfollow(String action, final Context context){
        RestAPIAdapter restApiAdapter = new RestAPIAdapter();
        Gson gsonUser = restApiAdapter.construyeGsonDeserializadorGetRelationship();
        EndpointsAPI endpointsAPI = restApiAdapter.establecerConexionRestAPIInstagram(gsonUser);
        Call<UsuarioFollowResponse> usuarioFollowResponseCall = endpointsAPI.modifyFollowUser(metodos.mostrarIdUsuarioLike(), action);

        usuarioFollowResponseCall.enqueue(new Callback<UsuarioFollowResponse>() {
            @Override
            public void onResponse(Call<UsuarioFollowResponse> call, Response<UsuarioFollowResponse> response) {
                UsuarioFollowResponse usuarioFollowResponse = response.body();
                if(usuarioFollowResponse.getCodigoRespuesta().equals("200")){
                    Log.d("ACTION_STATUS", usuarioFollowResponse.getOutgoing_status());
                    if(usuarioFollowResponse.getOutgoing_status().equals("follows")){
                        Toast.makeText(context, "Has empezado a seguir a" + metodos.mostrarUsuarioLike(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if(usuarioFollowResponse.getOutgoing_status().equals("requested")){
                        Toast.makeText(context, "Has solicitado seguir a " + metodos.mostrarUsuarioLike(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Has dejado de seguir a" + metodos.mostrarUsuarioLike(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<UsuarioFollowResponse> call, Throwable t) {
                Toast.makeText(context, "Error al realizar la conexión.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
