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

    public String mostrarIdUsuarioLike(){
        String idUser = shrd.getString("idUsuarioLike", "");
        return idUser;
    }

    public String mostrarUsuarioLike(){
        String sUser = shrd.getString("usuarioLike", "");
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

    public void guardarDatosUsuarioLike(String idUsuario, String sUsuario){
        SharedPreferences.Editor edit = shrd.edit();

        edit.clear();

        edit.putString("idUsuarioLike", idUsuario);
        edit.putString("usuarioLike", sUsuario);

        edit.commit();
    }

    public boolean inicioApp(){
        boolean inicio = shrd.getBoolean("inicio", true);
        return inicio;
    }

}
