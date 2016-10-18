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

import mx.octaviocervantes.mypetcare.datos.UsuarioSearchInstagram;
import mx.octaviocervantes.mypetcare.restAPI.JsonKeys;
import mx.octaviocervantes.mypetcare.restAPI.model.UsuarioSearchResponse;

public class UsuarioSearchDeserializador implements JsonDeserializer<UsuarioSearchResponse> {
    @Override
    public UsuarioSearchResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        UsuarioSearchResponse usuarioResponse = gson.fromJson(json, UsuarioSearchResponse.class);
        JsonArray usuarioResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        usuarioResponse.setUsuario(deserializadorUsuarioJson(usuarioResponseData));
        return usuarioResponse;
    }

    private ArrayList<UsuarioSearchInstagram> deserializadorUsuarioJson(JsonArray usuarioResponseData){
        ArrayList<UsuarioSearchInstagram> usuarioInstagram = new ArrayList<>();

        if(usuarioResponseData.size() > 0){
            JsonObject jsonObject = usuarioResponseData.get(0).getAsJsonObject();

            String idUser = jsonObject.get(JsonKeys.USER_ID).getAsString();
            String sUser = jsonObject.get(JsonKeys.USERNAME).getAsString();

            UsuarioSearchInstagram usuarioInstagramActual = new UsuarioSearchInstagram();
            usuarioInstagramActual.setIdUser(idUser);
            usuarioInstagramActual.setsUser(sUser);

            usuarioInstagram.add(usuarioInstagramActual);
        }

        return usuarioInstagram;
    }
}
