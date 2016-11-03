package mx.octaviocervantes.mypetcare.restAPI;

import mx.octaviocervantes.mypetcare.restAPI.model.UsuarioFirebaseResponse;
import mx.octaviocervantes.mypetcare.restAPI.model.UsuarioLikeResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface EndpointsAPIFirebase {

    @FormUrlEncoded
    @POST(ConstantesRestAPIFirebase.TOKEN)
    Call<UsuarioFirebaseResponse> registrarTokenId(@Field("idusuario") String idusuario,
                                                   @Field("susuario") String susuario,
                                                   @Field("iddispositivo") String iddispositivo);

    @FormUrlEncoded
    @POST(ConstantesRestAPIFirebase.TOKEN_FOTO_LIKE)
    Call<UsuarioLikeResponse> registrarLikeUsuario(@Field("idusuario") String idusuario,
                                                   @Field("idfoto") String idfoto,
                                                   @Field("iddispositivoe") String iddispositivoe);
}
