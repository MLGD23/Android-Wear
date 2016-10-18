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

import mx.octaviocervantes.mypetcare.datos.UsuarioInstagram;
import mx.octaviocervantes.mypetcare.restAPI.JsonKeys;
import mx.octaviocervantes.mypetcare.restAPI.model.UsuarioResponse;

/**
 * Created by Tavo on 16/10/2016.
 */
public class UsuarioDeserializador implements JsonDeserializer<UsuarioResponse> {
    @Override
    public UsuarioResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        UsuarioResponse usuarioResponse = gson.fromJson(json, UsuarioResponse.class);
        JsonObject usuarioResponseData = json.getAsJsonObject();

        usuarioResponse.setUsuarios(deserializadorUsuarioJson(usuarioResponseData));
        return usuarioResponse;
    }

    private ArrayList<UsuarioInstagram> deserializadorUsuarioJson(JsonObject usuarioResponseData){
        ArrayList<UsuarioInstagram> usuarioInstagram = new ArrayList<>();

        JsonObject jsonObjectUser = usuarioResponseData.getAsJsonObject(JsonKeys.MEDIA_RESPONSE_ARRAY);
        //String sUserName = jsonObject.get(JsonKeys.USERNAME).getAsString();
        String sUser = jsonObjectUser.get(JsonKeys.USER_FULLNAME).getAsString();
        String sPhoto = jsonObjectUser.get(JsonKeys.USER_PROFILE_PIC).getAsString();

        JsonObject jsonObjectFollows = jsonObjectUser.getAsJsonObject(JsonKeys.USER_RESPONSE_ARRAY_COUNTS);
        int iFollowers = jsonObjectFollows.get(JsonKeys.USER_FOLLOWERS).getAsInt();
        int iFollowed = jsonObjectFollows.get(JsonKeys.USER_FOLLOWS).getAsInt();

        UsuarioInstagram usuarioInstagramActual = new UsuarioInstagram();
        usuarioInstagramActual.setsNombreUsuario(sUser);
        usuarioInstagramActual.setsFotoUsuario(sPhoto);
        usuarioInstagramActual.setiSeguidores(iFollowers);
        usuarioInstagramActual.setiSeguidos(iFollowed);

        usuarioInstagram.add(usuarioInstagramActual);

        return usuarioInstagram;
    }
}
