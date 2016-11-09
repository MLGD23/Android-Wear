package mx.octaviocervantes.mypetcare.restAPI.deserializer;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import mx.octaviocervantes.mypetcare.restAPI.JsonKeys;
import mx.octaviocervantes.mypetcare.restAPI.model.UsuarioFollowResponse;

public class UsuarioFollowDeserializador implements JsonDeserializer<UsuarioFollowResponse> {
    @Override
    public UsuarioFollowResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        UsuarioFollowResponse usuarioFollowResponse = gson.fromJson(json, UsuarioFollowResponse.class);
        JsonObject usuarioFollowResponseData = json.getAsJsonObject().getAsJsonObject(JsonKeys.LIKE_META);
        String sCode = usuarioFollowResponseData.get(JsonKeys.LIKE_CODE).getAsString();

        JsonObject usuarioFollowData = json.getAsJsonObject().getAsJsonObject(JsonKeys.MEDIA_RESPONSE_ARRAY);
        String sOut = usuarioFollowData.get(JsonKeys.FOLLOW_OUTGOING_STATUS).getAsString();
        String sIn = usuarioFollowData.get(JsonKeys.FOLLOW_INCOMING_STATUS).getAsString();
        String sUserPrivate = usuarioFollowData.get(JsonKeys.FOLLOW_TARGET_USER_PRIVATE).getAsString();

        usuarioFollowResponse.setCodigoRespuesta(sCode);
        usuarioFollowResponse.setOutgoing_status(sOut);
        usuarioFollowResponse.setTarget_user_is_private(sUserPrivate);
        usuarioFollowResponse.setIncoming_status(sIn);

        return usuarioFollowResponse;
    }
}
