package mx.octaviocervantes.mypetcare.restAPI;

import mx.octaviocervantes.mypetcare.LoginUsuario;

public final class ConstantesRestAPI{

    //Datos del usuario
    public static final String ID_USUARIO = "4026472933";
    public static final String USUARIO = "cococatmx";

	//Partes principales de la URL.
	public static final String ROOT_VERSION = "/v1/";
	public static final String URL = "https://api.instagram.com";
	public static final String ROOT_URL = URL + ROOT_VERSION;
	public static final String ACCESS_TOKEN = "4026472933.2f2c253.04df578986394101a0fe945dde5815d6";
	public static final String TOKEN = "?access_token=";
    public static final String KEY_ACCESS_TOKEN = TOKEN + ACCESS_TOKEN;

	//Endpoints
	public static final String RECENT_MEDIA_ENDPOINT = "users/self/media/recent/";
	public static final String USER_ENDPOINT = "users/self/";
    public static final String USER_SEARCH_ENDPOINT = "users/search";
	public static final String USER_ID_RECENT_MEDIA_ENDPOINT = "users/{user-id}/media/recent/";
	public static final String USER_ID_ENDPOINT = "users/{user-id}/";
	public static final String USER_PHOTO_LIKE = "media/{media-id}/likes";

	public static final String URL_RECENT_MEDIA = RECENT_MEDIA_ENDPOINT + KEY_ACCESS_TOKEN;
    public static final String URL_USER = USER_ENDPOINT + KEY_ACCESS_TOKEN;
    public static final String URL_USER_ID_RECENT_MEDIA = USER_ID_RECENT_MEDIA_ENDPOINT + KEY_ACCESS_TOKEN;
    public static final String URL_USER_ID = USER_ID_ENDPOINT + KEY_ACCESS_TOKEN;
	public static final String URL_USER_PHOTO_LIKE = USER_PHOTO_LIKE + KEY_ACCESS_TOKEN;
}