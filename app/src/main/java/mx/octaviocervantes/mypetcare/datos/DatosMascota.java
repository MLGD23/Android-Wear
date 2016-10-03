package mx.octaviocervantes.mypetcare.datos;

public class DatosMascota {
    private int idMascota;
    private String nombreMascota;
    private int ratingMascota;
    private int fotoMascota;

    public DatosMascota(String nombreMascota, int ratingMascota, int fotoMascota) {
        this.nombreMascota = nombreMascota;
        this.ratingMascota = ratingMascota;
        this.fotoMascota = fotoMascota;
    }

    public DatosMascota() {}

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public int getRatingMascota() {
        return ratingMascota;
    }

    public void setRatingMascota(int ratingMascota) {
        this.ratingMascota = ratingMascota;
    }

    public int getFotoMascota() {
        return fotoMascota;
    }

    public void setFotoMascota(int fotoMascota) {
        this.fotoMascota = fotoMascota;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }
}
