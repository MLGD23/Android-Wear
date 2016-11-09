package mx.octaviocervantes.mypetcare.fragments;

import java.util.ArrayList;

import mx.octaviocervantes.mypetcare.adapter.FotoMascotaAdaptador;
import mx.octaviocervantes.mypetcare.datos.MascotaIdInstagram;
import mx.octaviocervantes.mypetcare.datos.UsuarioIdInstagram;

public interface IPerfilFragment {

    void generarGridLayout();

    FotoMascotaAdaptador crearAdaptador(ArrayList<MascotaIdInstagram> mascotas);

    void inicializarAdaptadorMascota(FotoMascotaAdaptador mascotaAdaptador);

    void mostrarDatosUsuario(ArrayList<UsuarioIdInstagram> usuarioInstagram);
}
