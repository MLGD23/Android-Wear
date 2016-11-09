package mx.octaviocervantes.mypetcare;

import java.util.ArrayList;

import mx.octaviocervantes.mypetcare.adapter.UsuarioLikeAdapter;
import mx.octaviocervantes.mypetcare.datos.MascotaIdInstagram;
import mx.octaviocervantes.mypetcare.datos.UsuarioIdInstagram;

public interface IUsuarioLike {

    void generarGridLayout();

    UsuarioLikeAdapter crearAdaptador(ArrayList<MascotaIdInstagram> usuariosLike);

    void inicializarAdaptadorUsuarioLike(UsuarioLikeAdapter usuarioLikeAdapter);

    void mostrarDatosUserLike(ArrayList<UsuarioIdInstagram> usuarioInstagram);
}
