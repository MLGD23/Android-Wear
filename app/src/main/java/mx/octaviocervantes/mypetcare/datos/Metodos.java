package mx.octaviocervantes.mypetcare.datos;

import android.content.Context;
import android.content.SharedPreferences;

public class Metodos {
    Context context;
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
}
