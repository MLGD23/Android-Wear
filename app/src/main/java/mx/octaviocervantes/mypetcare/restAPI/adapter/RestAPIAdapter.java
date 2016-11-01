package mx.octaviocervantes.mypetcare.restAPI.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import mx.octaviocervantes.mypetcare.restAPI.ConstantesRestAPI;
import mx.octaviocervantes.mypetcare.restAPI.EndpointsAPI;
import mx.octaviocervantes.mypetcare.restAPI.deserializer.MascotaIdDeserializador;
import mx.octaviocervantes.mypetcare.restAPI.deserializer.MascotaLikeDeserializador;
import mx.octaviocervantes.mypetcare.restAPI.deserializer.UsuarioDeserializador;
import mx.octaviocervantes.mypetcare.restAPI.deserializer.UsuarioIdDeserializador;
import mx.octaviocervantes.mypetcare.restAPI.deserializer.UsuarioSearchDeserializador;
import mx.octaviocervantes.mypetcare.restAPI.model.MascotaIdResponse;
import mx.octaviocervantes.mypetcare.restAPI.model.MascotaLikeResponse;
import mx.octaviocervantes.mypetcare.restAPI.model.MascotaResponse;
import mx.octaviocervantes.mypetcare.restAPI.deserializer.MascotaDeserializador;
import mx.octaviocervantes.mypetcare.restAPI.model.UsuarioIdResponse;
import mx.octaviocervantes.mypetcare.restAPI.model.UsuarioResponse;
import mx.octaviocervantes.mypetcare.restAPI.model.UsuarioSearchResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestAPIAdapter{

	public EndpointsAPI establecerConexionRestAPIInstagram(Gson gson){
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(ConstantesRestAPI.ROOT_URL)
				.addConverterFactory(GsonConverterFactory.create(gson))
				.build();

		return retrofit.create(EndpointsAPI.class);
	}

	public Gson construyeGsonDeserializadorMediaRecent(){
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(MascotaResponse.class, new MascotaDeserializador());
		return gsonBuilder.create();
	}

	public Gson construyeGsonDeserializadorUser(){
		GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(UsuarioResponse.class, new UsuarioDeserializador());
        return gsonBuilder.create();
	}

    public Gson construyeGsonDeserializadorUserSearch(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(UsuarioSearchResponse.class, new UsuarioSearchDeserializador());
        return gsonBuilder.create();
    }

	public Gson construyeGsonDeserializadorMediaRecentUserId(){
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(MascotaIdResponse.class, new MascotaIdDeserializador());
		return gsonBuilder.create();
	}

	public Gson construyeGsonDeserializadorUserId(){
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(UsuarioIdResponse.class, new UsuarioIdDeserializador());
		return gsonBuilder.create();
	}

	public Gson construyeGsonDeserializadorUserPhotoLike(){
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(MascotaLikeResponse.class, new MascotaLikeDeserializador());
		return gsonBuilder.create();
	}
}