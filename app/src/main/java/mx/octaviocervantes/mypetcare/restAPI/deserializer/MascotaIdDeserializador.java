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

import mx.octaviocervantes.mypetcare.datos.MascotaIdInstagram;
import mx.octaviocervantes.mypetcare.restAPI.JsonKeys;
import mx.octaviocervantes.mypetcare.restAPI.model.MascotaIdResponse;

/**
 * Created by Tavo on 17/10/2016.
 */
public class MascotaIdDeserializador implements JsonDeserializer<MascotaIdResponse> {
    @Override
    public MascotaIdResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        MascotaIdResponse mascotaResponse = gson.fromJson(json, MascotaIdResponse.class);
        JsonArray mascotaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        mascotaResponse.setMascotas(deserializadorMascotaJson(mascotaResponseData));
        return mascotaResponse;
    }

    private ArrayList<MascotaIdInstagram> deserializadorMascotaJson(JsonArray mascotaResponseData){
        ArrayList<MascotaIdInstagram> mascotaInstagram = new ArrayList<>();

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

            MascotaIdInstagram mascotaInstagramActual = new MascotaIdInstagram();
            mascotaInstagramActual.setIdUsuario(idUser);
            mascotaInstagramActual.setNombreUsuario(sUser);
            mascotaInstagramActual.setUrlFoto(sURLPhoto);
            mascotaInstagramActual.setMeGusta(iLikes);

            mascotaInstagram.add(mascotaInstagramActual);
        }

        return mascotaInstagram;
    }
}
