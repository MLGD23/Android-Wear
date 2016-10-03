package mx.octaviocervantes.mypetcare.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import mx.octaviocervantes.mypetcare.datos.DatosMascota;

public class BaseDatosMascotas extends SQLiteOpenHelper {

    private Context context;

    public BaseDatosMascotas(Context context) {
        super(context, ConstantesBaseDatos.NOMBRE_BASE_DATOS, null, ConstantesBaseDatos.BASE_DATOS_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryTabla = "CREATE TABLE " + ConstantesBaseDatos.TABLA_MASCOTAS + "(" +
                            ConstantesBaseDatos.ID_MASCOTA + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            ConstantesBaseDatos.NOMBRE_MASCOTA + " TEXT, " +
                            ConstantesBaseDatos.FOTO_MASCOTA + " INTEGER, " +
                            ConstantesBaseDatos.RATING_MASCOTA + " INTEGER " +
                            ")";

        db.execSQL(queryTabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLA_MASCOTAS);
        onCreate(db);
    }

    public ArrayList<DatosMascota> listarDatosMascotas(){
        ArrayList<DatosMascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLA_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor regs = db.rawQuery(query, null);

        while (regs.moveToNext()){
            DatosMascota mascota = new DatosMascota();
            mascota.setIdMascota(regs.getInt(0));
            mascota.setNombreMascota(regs.getString(1));
            mascota.setFotoMascota(regs.getInt(2));
            mascota.setRatingMascota(regs.getInt(3));
            mascotas.add(mascota);
        }

        db.close();
        regs.close();

        return mascotas;
    }

    public ArrayList<DatosMascota> listarDetalleDatosMascotas(){
        ArrayList<DatosMascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLA_MASCOTAS + " ORDER BY " +
                        ConstantesBaseDatos.RATING_MASCOTA + " DESC LIMIT 5";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor regs = db.rawQuery(query, null);

        while (regs.moveToNext()){
            DatosMascota mascota = new DatosMascota();
            mascota.setIdMascota(regs.getInt(0));
            mascota.setNombreMascota(regs.getString(1));
            mascota.setFotoMascota(regs.getInt(2));
            mascota.setRatingMascota(regs.getInt(3));
            mascotas.add(mascota);
        }

        db.close();
        regs.close();

        return mascotas;
    }

    public void insertarDatosMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLA_MASCOTAS, null, contentValues);
        db.close();
    }

    public void actualizarLikeMascota(ContentValues contentValues, int idMascota){
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(ConstantesBaseDatos.TABLA_MASCOTAS, contentValues, ConstantesBaseDatos.ID_MASCOTA + " = ?", new String[] {String.valueOf(idMascota)});
        db.close();
    }

    public int obtenerLikesMascota(DatosMascota mascota){
        int likes = 0;

        String query = "SELECT " + ConstantesBaseDatos.RATING_MASCOTA + " FROM " + ConstantesBaseDatos.TABLA_MASCOTAS +
                       " WHERE " + ConstantesBaseDatos.ID_MASCOTA + " = " + mascota.getIdMascota();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor regs = db.rawQuery(query, null);

        while (regs.moveToNext()){
            likes = regs.getInt(0);
        }

        db.close();
        regs.close();

        return likes;
    }
}
