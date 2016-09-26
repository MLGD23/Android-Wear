package mx.octaviocervantes.mypetcare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class AcercaDesarrollador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desarrollador_acerca);

        Toolbar actionBarMascota = (Toolbar) findViewById(R.id.actionBarMascota);
        setSupportActionBar(actionBarMascota);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
