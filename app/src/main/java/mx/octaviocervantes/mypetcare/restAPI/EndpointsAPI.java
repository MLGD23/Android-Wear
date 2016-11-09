package mx.octaviocervantes.mypetcare.restAPI;

import mx.octaviocervantes.mypetcare.restAPI.model.MascotaLikeResponse;
import mx.octaviocervantes.mypetcare.restAPI.model.MascotaIdResponse;
import mx.octaviocervantes.mypetcare.restAPI.model.MascotaResponse;
import mx.octaviocervantes.mypetcare.restAPI.model.UsuarioFollowResponse;
import mx.octaviocervantes.mypetcare.restAPI.model.UsuarioIdResponse;
import mx.octaviocervantes.mypetcare.restAPI.model.UsuarioResponse;
import mx.octaviocervantes.mypetcare.restAPI.model.UsuarioSearchResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
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

    @POST(ConstantesRestAPI.URL_USER_PHOTO_LIKE)
    Call<MascotaLikeResponse> setLikeUserPhoto(@Path("media-id") String idfoto);

    @GET(ConstantesRestAPI.URL_RELATIONSHIP)
    Call<UsuarioFollowResponse> getRelationship(@Path("user-id") String idUser);

    @FormUrlEncoded
    @POST(ConstantesRestAPI.URL_FOLLOW_USER)
    Call<UsuarioFollowResponse> modifyFollowUser(@Path("user-id") String idUser, @Field("action") String action);

}

