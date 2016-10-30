package mx.octaviocervantes.mypetcare.restAPI;

import mx.octaviocervantes.mypetcare.restAPI.model.UsuarioFirebaseResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface EndpointsAPIFirebase {

    @FormUrlEncoded
    @POST(ConstantesRestAPIFirebase.TOKEN)
    Call<UsuarioFirebaseResponse> registrarTokenId(@Field("idusuario") String idUsuario,
                                                   @Field("susuario") String sUsuario,
                                                   @Field("iddispositivo") String idDispositivo);
}
