package mx.octaviocervantes.mypetcare;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import mx.octaviocervantes.mypetcare.datos.Metodos;
import mx.octaviocervantes.mypetcare.datos.UsuarioSearchInstagram;
import mx.octaviocervantes.mypetcare.restAPI.ConstantesRestAPI;
import mx.octaviocervantes.mypetcare.restAPI.EndpointsAPI;
import mx.octaviocervantes.mypetcare.restAPI.JsonKeys;
import mx.octaviocervantes.mypetcare.restAPI.adapter.RestAPIAdapter;
import mx.octaviocervantes.mypetcare.restAPI.model.UsuarioResponse;
import mx.octaviocervantes.mypetcare.restAPI.model.UsuarioSearchResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginUsuario extends AppCompatActivity {

    public ArrayList<UsuarioSearchInstagram> usuarios;
    SharedPreferences shrdPrefs;
    TextInputEditText txtUsuario;
    TextView tvUsuarioActual;
    String sUsuario;
    RestAPIAdapter restAPIAdapter;
    EndpointsAPI endpointsAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usuario_login);

        Toolbar actionBarMascota = (Toolbar) findViewById(R.id.actionBarMascota);
        setSupportActionBar(actionBarMascota);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        shrdPrefs = getSharedPreferences("datosInstagram", Context.MODE_PRIVATE);

        tvUsuarioActual = (TextView) findViewById(R.id.tvUsuarioActual);
        tvUsuarioActual.setText("Usuario conectado: " + mostrarUsuarioActual());

        restAPIAdapter = new RestAPIAdapter();
    }

    public void buscarUsuarioInstagram(View v){
        txtUsuario = (TextInputEditText) findViewById(R.id.txtUsuario);
        obtenerDatosUsuario();
    }

    public String mostrarUsuarioActual(){
        String usuarioActual = shrdPrefs.getString("usuario", "cococatmx");

        return usuarioActual;
    }

    public void obtenerDatosUsuario() {
        Gson gsonUser = restAPIAdapter.construyeGsonDeserializadorUserSearch();
        endpointsAPI = restAPIAdapter.establecerConexionRestAPIInstagram(gsonUser);
        Call<UsuarioSearchResponse> usuarioResponseCall = endpointsAPI.getUserSearch(txtUsuario.getText().toString(), ConstantesRestAPI.ACCESS_TOKEN);

        usuarioResponseCall.enqueue(new Callback<UsuarioSearchResponse>() {
            @Override
            public void onResponse(Call<UsuarioSearchResponse> call, Response<UsuarioSearchResponse> response) {
                UsuarioSearchResponse usuarioResponse = response.body();
                usuarios = usuarioResponse.getUsuario();

                if (usuarios.size() > 0) {
                    Metodos m = new Metodos(getApplicationContext());

                    m.guardarDatos(usuarios.get(0).getIdUser(), usuarios.get(0).getsUser(), false);
                    Intent intent = new Intent(LoginUsuario.this, MascotasLista.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }else{
                    Metodos m = new Metodos(getApplicationContext());

                    m.guardarDatos(ConstantesRestAPI.ID_USUARIO, ConstantesRestAPI.USUARIO, false);
                    Toast.makeText(getApplicationContext(), "No se encontró al usuario seleccionado, se mostrará el usuario registrado en la API", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginUsuario.this, MascotasLista.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<UsuarioSearchResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Hubo un problema con la conexión al buscar a un usuario, intenta nuevamente.", Toast.LENGTH_LONG).show();
                Log.e("Falló la conexión.", t.toString());
            }
        });
    }
}
