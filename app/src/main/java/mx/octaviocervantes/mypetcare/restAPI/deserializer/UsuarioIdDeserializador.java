package mx.octaviocervantes.mypetcare.restAPI.deserializer;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

import mx.octaviocervantes.mypetcare.datos.UsuarioIdInstagram;
import mx.octaviocervantes.mypetcare.restAPI.JsonKeys;
import mx.octaviocervantes.mypetcare.restAPI.model.UsuarioIdResponse;

public class UsuarioIdDeserializador implements JsonDeserializer<UsuarioIdResponse> {
    @Override
    public UsuarioIdResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        UsuarioIdResponse usuarioResponse = gson.fromJson(json, UsuarioIdResponse.class);
        JsonObject usuarioResponseData = json.getAsJsonObject();

        usuarioResponse.setUsuarios(deserializadorUsuarioJson(usuarioResponseData));
        return usuarioResponse;
    }

    private ArrayList<UsuarioIdInstagram> deserializadorUsuarioJson(JsonObject usuarioResponseData){
        ArrayList<UsuarioIdInstagram> usuarioInstagram = new ArrayList<>();

        JsonObject jsonObjectUser = usuarioResponseData.getAsJsonObject(JsonKeys.MEDIA_RESPONSE_ARRAY);
        String sUser = jsonObjectUser.get(JsonKeys.USER_FULLNAME).getAsString();
        String sPhoto = jsonObjectUser.get(JsonKeys.USER_PROFILE_PIC).getAsString();

        JsonObject jsonObjectFollows = jsonObjectUser.getAsJsonObject(JsonKeys.USER_RESPONSE_ARRAY_COUNTS);
        int iFollowers = jsonObjectFollows.get(JsonKeys.USER_FOLLOWERS).getAsInt();
        int iFollowed = jsonObjectFollows.get(JsonKeys.USER_FOLLOWS).getAsInt();

        UsuarioIdInstagram usuarioInstagramActual = new UsuarioIdInstagram();
        usuarioInstagramActual.setsNombreUsuario(sUser);
        usuarioInstagramActual.setsFotoUsuario(sPhoto);
        usuarioInstagramActual.setiSeguidores(iFollowers);
        usuarioInstagramActual.setiSeguidos(iFollowed);

        usuarioInstagram.add(usuarioInstagramActual);

        return usuarioInstagram;
    }
}
