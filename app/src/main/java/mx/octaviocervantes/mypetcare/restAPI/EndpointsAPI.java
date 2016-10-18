package mx.octaviocervantes.mypetcare.restAPI;

import mx.octaviocervantes.mypetcare.restAPI.model.MascotaIdResponse;
import mx.octaviocervantes.mypetcare.restAPI.model.MascotaResponse;
import mx.octaviocervantes.mypetcare.restAPI.model.UsuarioIdResponse;
import mx.octaviocervantes.mypetcare.restAPI.model.UsuarioResponse;
import mx.octaviocervantes.mypetcare.restAPI.model.UsuarioSearchResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EndpointsAPI{

	@GET(ConstantesRestAPI.URL_RECENT_MEDIA)
	Call<MascotaResponse> getRecentMedia();

    @GET(ConstantesRestAPI.URL_USER)
	Call<UsuarioResponse> getUser();

    @GET(ConstantesRestAPI.USER_SEARCH_ENDPOINT)
    Call<UsuarioSearchResponse> getUserSearch(@Query("q") String sUser, @Query("access_token") String sAccessToken);

    @GET(ConstantesRestAPI.URL_USER_ID_RECENT_MEDIA)
    Call<MascotaIdResponse> getRecentMediaUserId(@Path("user-id") String idUser);

    @GET(ConstantesRestAPI.URL_USER_ID)
    Call<UsuarioIdResponse> getUserId(@Path("user-id") String idUser);

}

