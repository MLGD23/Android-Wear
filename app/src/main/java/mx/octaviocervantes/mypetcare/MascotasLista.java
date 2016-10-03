package mx.octaviocervantes.mypetcare;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

import mx.octaviocervantes.mypetcare.adapter.PageAdapter;
import mx.octaviocervantes.mypetcare.fragments.MascotasFragment;
import mx.octaviocervantes.mypetcare.fragments.PerfilFragment;

public class MascotasLista extends AppCompatActivity {

    Toolbar tbMascota;
    private TabLayout tlMascota;
    private ViewPager vpMascota;

    MascotasFragment mf;
    PerfilFragment pf;

    private ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_mascotas);

        tbMascota = (Toolbar) findViewById(R.id.tbMascota);
        tlMascota = (TabLayout) findViewById(R.id.tlMascota);
        vpMascota = (ViewPager) findViewById(R.id.vpMascota);

/*        Toolbar actionBarMascota = (Toolbar) findViewById(R.id.actionBarMascota);
        setSupportActionBar(actionBarMascota);*/

        setUpViewPager();

        if (tbMascota != null){
            setSupportActionBar(tbMascota);
        }
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
        }

        return super.onOptionsItemSelected(item);
    }
}
