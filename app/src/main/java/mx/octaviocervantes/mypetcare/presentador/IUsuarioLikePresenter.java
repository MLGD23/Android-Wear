package mx.octaviocervantes.mypetcare.presentador;

import java.util.ArrayList;

import mx.octaviocervantes.mypetcare.datos.MascotaIdInstagram;

/**
 * Created by Tavo on 06/11/2016.
 */
public interface IUsuarioLikePresenter {

    void obtenerDatosUsuarioLike();

    void obtenerMediosRecientesUsuarioLike();

    void mostrarDatosUsuarioLike();

    void mostrarInfoUsuarioLike();

    ArrayList<MascotaIdInstagram> datosUsuarioLike();

}
