package mx.octaviocervantes.mypetcare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

import java.util.ArrayList;

import mx.octaviocervantes.mypetcare.adapter.PageAdapter;
import mx.octaviocervantes.mypetcare.datos.Metodos;
import mx.octaviocervantes.mypetcare.fragments.MascotasFragment;
import mx.octaviocervantes.mypetcare.fragments.PerfilFragment;
import mx.octaviocervantes.mypetcare.restAPI.ConstantesRestAPI;
import mx.octaviocervantes.mypetcare.restAPI.EndpointsAPIFirebase;
import mx.octaviocervantes.mypetcare.restAPI.adapter.RestAPIFirebaseAdapter;
import mx.octaviocervantes.mypetcare.restAPI.model.UsuarioFirebaseResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MascotasLista extends AppCompatActivity {

    Toolbar tbMascota;
    private TabLayout tlMascota;
    private ViewPager vpMascota;
    MascotasFragment mf;
    PerfilFragment pf;
    Metodos metodos;

    private ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_mascotas);
        metodos = new Metodos(getApplicationContext());

        tbMascota = (Toolbar) findViewById(R.id.tbMascota);
        tlMascota = (TabLayout) findViewById(R.id.tlMascota);
        vpMascota = (ViewPager) findViewById(R.id.vpMascota);

        if(metodos.inicioApp())
            metodos.guardarDatos(ConstantesRestAPI.ID_USUARIO, ConstantesRestAPI.USUARIO, true);

        if (tbMascota != null){
            setSupportActionBar(tbMascota);
        }
        setUpViewPager();
    }

    private ArrayList<Fragment> agregarFragments(){
        mf = new MascotasFragment();
        pf = new PerfilFragment();

        fragments.add(mf);
        fragments.add(pf);

        return fragments;
    }

    private void setUpViewPager(){
        vpMascota.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tlMascota.setupWithViewPager(vpMascota);

        tlMascota.getTabAt(0).setIcon(R.drawable.ic_home_pet);
        tlMascota.getTabAt(1).setIcon(R.drawable.ic_dog);
    }

    //Menú
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_actionbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemFav:
                Intent intDetalle = new Intent(this, DetalleMascota.class);
                startActivity(intDetalle);
            break;

            case R.id.mContacto:
                Intent intContacto = new Intent(this, PersonaContacto.class);
                startActivity(intContacto);
            break;

            case R.id.mAcercaDe:
                Intent intAcerca = new Intent(this, AcercaDesarrollador.class);
                startActivity(intAcerca);
            break;

            case R.id.mConfigurarCuenta:
                Intent intConfigura = new Intent(this, LoginUsuario.class);
                startActivity(intConfigura);
                break;

            case R.id.mRecibirNotificaciones:
                recibirNotificaciones();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void recibirNotificaciones(){
        String token = FirebaseInstanceId.getInstance().getToken();

        RestAPIFirebaseAdapter restAPIFirebaseAdapter = new RestAPIFirebaseAdapter();
        EndpointsAPIFirebase endpointsAPIFirebase = restAPIFirebaseAdapter.establecerConexionRestAPI();
        Call<UsuarioFirebaseResponse> usuarioFirebaseResponseCall = endpointsAPIFirebase.registrarTokenId(metodos.mostrarDatos(), metodos.mostrarDatosUsuario(), token);

        usuarioFirebaseResponseCall.enqueue(new Callback<UsuarioFirebaseResponse>() {
            @Override
            public void onResponse(Call<UsuarioFirebaseResponse> call, Response<UsuarioFirebaseResponse> response) {
                UsuarioFirebaseResponse usuarioFirebaseResponse = response.body();
                Toast.makeText(getApplicationContext(), "Información enviada a la base de datos de firebase.", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<UsuarioFirebaseResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "No se pudo enviar información a la base de datos de firebase.", Toast.LENGTH_LONG).show();
            }
        });
    }
}
