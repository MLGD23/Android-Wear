package mx.octaviocervantes.mypetcare.datos;

/**
 * Created by Tavo on 24/09/2016.
 */
public class FotosDatosMascota {
    private int fotoMascota;
    private String ratingFotoMascota;

    public FotosDatosMascota(int fotoMascota, String ratingFotoMascota) {
        this.fotoMascota = fotoMascota;
        this.ratingFotoMascota = ratingFotoMascota;
    }

    public int getFotoMascota() {
        return fotoMascota;
    }

    public void setFotoMascota(int fotoMascota) {
        this.fotoMascota = fotoMascota;
    }

    public String getRatingFotoMascota() {
        return ratingFotoMascota;
    }

    public void setRatingFotoMascota(String ratingFotoMascota) {
        this.ratingFotoMascota = ratingFotoMascota;
    }
}
