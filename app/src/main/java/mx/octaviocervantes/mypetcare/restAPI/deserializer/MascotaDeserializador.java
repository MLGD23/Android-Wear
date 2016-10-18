package mx.octaviocervantes.mypetcare.restAPI.deserializer;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

import mx.octaviocervantes.mypetcare.datos.MascotaInstagram;
import mx.octaviocervantes.mypetcare.restAPI.JsonKeys;
import mx.octaviocervantes.mypetcare.restAPI.model.MascotaResponse;

public class MascotaDeserializador implements JsonDeserializer<MascotaResponse> {
	@Override
	public MascotaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		Gson gson = new Gson();
		MascotaResponse mascotaResponse = gson.fromJson(json, MascotaResponse.class);
		JsonArray mascotaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

		mascotaResponse.setMascotas(deserializadorMascotaJson(mascotaResponseData));
		return mascotaResponse;
	}

	private ArrayList<MascotaInstagram> deserializadorMascotaJson(JsonArray mascotaResponseData){
		ArrayList<MascotaInstagram> mascotaInstagram = new ArrayList<>();

		for(int i = 0; i < mascotaResponseData.size(); i++){
			JsonObject jsonObject = mascotaResponseData.get(i).getAsJsonObject();
			
			JsonObject jsonObjectUser = jsonObject.getAsJsonObject(JsonKeys.MEDIA_RESPONSE_ARRAY_USER);
			String idUser = jsonObjectUser.get(JsonKeys.USER_ID).getAsString();
			String sUser = jsonObjectUser.get(JsonKeys.USER_FULLNAME).getAsString();

			JsonObject jsonObjectImage = jsonObject.getAsJsonObject(JsonKeys.MEDIA_RESPONSE_ARRAY_IMAGES);
			JsonObject jsonObjectRes = jsonObjectImage.getAsJsonObject(JsonKeys.MEDIA_RECENT_STD_RES);
			String sURLPhoto = jsonObjectRes.get(JsonKeys.MEDIA_RECENT_STD_RES_URL).getAsString();

			JsonObject jsonObjectLikes = jsonObject.getAsJsonObject(JsonKeys.MEDIA_RESPONSE_ARRAY_LIKES);
			int iLikes = jsonObjectLikes.get(JsonKeys.MEDIA_RECENT_LIKES_COUNT).getAsInt();

			MascotaInstagram mascotaInstagramActual = new MascotaInstagram();
			mascotaInstagramActual.setIdUsuario(idUser);
			mascotaInstagramActual.setNombreUsuario(sUser);
			mascotaInstagramActual.setUrlFoto(sURLPhoto);
			mascotaInstagramActual.setMeGusta(iLikes);

			mascotaInstagram.add(mascotaInstagramActual);
		}

		return mascotaInstagram;
	}
}