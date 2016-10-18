package mx.octaviocervantes.mypetcare.presentador;

import java.util.ArrayList;

import mx.octaviocervantes.mypetcare.datos.MascotaIdInstagram;

public interface IPerfilMascotaPresenter {

    void obtenerDatosMascotas();

    void obtenerMediosRecientesUsuario();

    void obtenerDatosUsuario();

    void mostrarDatosMascota();

    void mostrarDatosUsuario();

    ArrayList<MascotaIdInstagram> datosMascotas();

}
