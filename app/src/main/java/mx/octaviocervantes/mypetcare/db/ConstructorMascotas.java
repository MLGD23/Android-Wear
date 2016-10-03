package mx.octaviocervantes.mypetcare.db;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import mx.octaviocervantes.mypetcare.R;
import mx.octaviocervantes.mypetcare.datos.DatosMascota;

public class ConstructorMascotas {

    BaseDatosMascotas baseDatosMascotas;
    private Context context;
    private ArrayList<DatosMascota> mascotas;

    public ConstructorMascotas(Context context) {
        this.context = context;
        baseDatosMascotas = new BaseDatosMascotas(context);
        mascotas = listarMascotas();
        if(mascotas.size() == 0)
            insertarDatoMascota();

    }

    public ArrayList<DatosMascota> listarMascotas(){
        return baseDatosMascotas.listarDatosMascotas();
    }

    public ArrayList<DatosMascota> listarDetalleMascotas(){
        return baseDatosMascotas.listarDetalleDatosMascotas();
    }

    public void insertarDatoMascota(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.NOMBRE_MASCOTA, "Willy");
        contentValues.put(ConstantesBaseDatos.RATING_MASCOTA, 0);
        contentValues.put(ConstantesBaseDatos.FOTO_MASCOTA, R.drawable.beagle);
        baseDatosMascotas.insertarDatosMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.NOMBRE_MASCOTA, "Toby");
        contentValues.put(ConstantesBaseDatos.RATING_MASCOTA, 0);
        contentValues.put(ConstantesBaseDatos.FOTO_MASCOTA, R.drawable.alaska);
        baseDatosMascotas.insertarDatosMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.NOMBRE_MASCOTA, "Bruno");
        contentValues.put(ConstantesBaseDatos.RATING_MASCOTA, 0);
        contentValues.put(ConstantesBaseDatos.FOTO_MASCOTA, R.drawable.collie);
        baseDatosMascotas.insertarDatosMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.NOMBRE_MASCOTA, "Simba");
        contentValues.put(ConstantesBaseDatos.RATING_MASCOTA, 0);
        contentValues.put(ConstantesBaseDatos.FOTO_MASCOTA, R.drawable.pastor_aleman);
        baseDatosMascotas.insertarDatosMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.NOMBRE_MASCOTA, "Bucky");
        contentValues.put(ConstantesBaseDatos.RATING_MASCOTA, 0);
        contentValues.put(ConstantesBaseDatos.FOTO_MASCOTA, R.drawable.golden);
        baseDatosMascotas.insertarDatosMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.NOMBRE_MASCOTA, "Claude");
        contentValues.put(ConstantesBaseDatos.RATING_MASCOTA, 0);
        contentValues.put(ConstantesBaseDatos.FOTO_MASCOTA, R.drawable.chihuahua);
        baseDatosMascotas.insertarDatosMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.NOMBRE_MASCOTA, "Jamie");
        contentValues.put(ConstantesBaseDatos.RATING_MASCOTA, 0);
        contentValues.put(ConstantesBaseDatos.FOTO_MASCOTA, R.drawable.perro_bco);
        baseDatosMascotas.insertarDatosMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.NOMBRE_MASCOTA, "Pitty");
        contentValues.put(ConstantesBaseDatos.RATING_MASCOTA, 0);
        contentValues.put(ConstantesBaseDatos.FOTO_MASCOTA, R.drawable.pitbull);
        baseDatosMascotas.insertarDatosMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.NOMBRE_MASCOTA, "Hush");
        contentValues.put(ConstantesBaseDatos.RATING_MASCOTA, 0);
        contentValues.put(ConstantesBaseDatos.FOTO_MASCOTA, R.drawable.basset);
        baseDatosMascotas.insertarDatosMascota(contentValues);
    }

    public void actualizarLikeMascota(DatosMascota mascota){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.RATING_MASCOTA, mascota.getRatingMascota());
        baseDatosMascotas.actualizarLikeMascota(contentValues, mascota.getIdMascota());
    }

    public int obtenerLikesMascota(DatosMascota mascota){
        return baseDatosMascotas.obtenerLikesMascota(mascota);
    }
}
