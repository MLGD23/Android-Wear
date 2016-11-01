package mx.octaviocervantes.mypetcare.restAPI.deserializer;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

import mx.octaviocervantes.mypetcare.restAPI.JsonKeys;
import mx.octaviocervantes.mypetcare.restAPI.model.MascotaLikeResponse;

public class MascotaLikeDeserializador implements JsonDeserializer<MascotaLikeResponse> {
    @Override
    public MascotaLikeResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        MascotaLikeResponse mascotaLikeResponse = gson.fromJson(json, MascotaLikeResponse.class);
        JsonObject mascotaLikeResponseData = json.getAsJsonObject();

        mascotaLikeResponse.setCodigoRespuesta(deserializadorMascotaLikeJson(mascotaLikeResponseData));
        return mascotaLikeResponse;
    }

    private String deserializadorMascotaLikeJson(JsonObject mascotaLikeResponseData){
        ArrayList<MascotaLikeResponse> mascotaLikeResponses = new ArrayList<>();

        JsonObject jsonObjectUser = mascotaLikeResponseData.getAsJsonObject(JsonKeys.LIKE_META);
        String sCode = jsonObjectUser.get(JsonKeys.LIKE_CODE).getAsString();

        return sCode;
    }
}
