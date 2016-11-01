package mx.octaviocervantes.mypetcare.restAPI.model;

/**
 * Created by Tavo on 31/10/2016.
 */
public class MascotaLikeResponse {

    private String codigoRespuesta;

    public MascotaLikeResponse() {

    }

    public MascotaLikeResponse(String codigoRespuesta) {

        this.codigoRespuesta = codigoRespuesta;
    }

    public String getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public void setCodigoRespuesta(String codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }

}
