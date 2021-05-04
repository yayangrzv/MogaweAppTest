package api;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class RetrofitFactory {

    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit(){

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create()).baseUrl("https://backend-service-development-dot-mogawe-222614.appspot.com/api/mogawers/").build();
        }

        return retrofit;
    }

}
