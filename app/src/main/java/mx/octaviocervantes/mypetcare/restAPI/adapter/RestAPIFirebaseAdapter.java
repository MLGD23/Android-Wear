package mx.octaviocervantes.mypetcare.restAPI.adapter;

import mx.octaviocervantes.mypetcare.restAPI.ConstantesRestAPIFirebase;
import mx.octaviocervantes.mypetcare.restAPI.EndpointsAPIFirebase;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestAPIFirebaseAdapter {

    public EndpointsAPIFirebase establecerConexionRestAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestAPIFirebase.TOKEN_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(EndpointsAPIFirebase.class);
    }
}
