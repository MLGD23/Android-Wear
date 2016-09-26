package mx.octaviocervantes.mypetcare;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import mx.octaviocervantes.mypetcare.datos.DatosContactoCorreo;
import mx.octaviocervantes.mypetcare.datos.EnviarCorreo;

public class PersonaContacto extends AppCompatActivity {

    TextInputEditText txtNombre;
    TextInputEditText txtCorreo;
    TextInputEditText txtMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacto_persona);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        Button btnEnviar = (Button) findViewById(R.id.btnEnviar);
        Button btnEnviarDos = (Button) findViewById(R.id.btnEnviarDos);
        txtNombre = (TextInputEditText) findViewById(R.id.txtNombre);
        txtCorreo = (TextInputEditText) findViewById(R.id.txtCorreo);
        txtMensaje = (TextInputEditText) findViewById(R.id.txtMensaje);


        Toolbar actionBarMascota = (Toolbar) findViewById(R.id.actionBarMascota);
        setSupportActionBar(actionBarMascota);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatosContactoCorreo dcc = new DatosContactoCorreo(txtNombre.getText().toString(), txtCorreo.getText().toString(), txtMensaje.getText().toString());

                EnviarCorreo ec = new EnviarCorreo(dcc.getsNombreCorreo(),dcc.getsCorreoElectronico(), dcc.getsMensajeCorreo());
                ec.enviar();
            }
        });

        btnEnviarDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarCorreo(v);
            }
        });
    }

    public void enviarCorreo(View view){
        String[] correo = {txtCorreo.getText().toString()};
        Intent correoIntent = new Intent((Intent.ACTION_SEND));
        correoIntent.setData(Uri.parse("mailto:"));
        correoIntent.putExtra(Intent.EXTRA_EMAIL, correo);
        correoIntent.putExtra(Intent.EXTRA_SUBJECT, "Correo contacto: " + txtNombre.getText().toString());
        correoIntent.putExtra(Intent.EXTRA_TEXT, txtMensaje.getText().toString());
        correoIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(correoIntent, "Enviar correo"));
    }
}
