package api;

import org.json.JSONObject;

import java.util.HashMap;

import model.User;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RetrofitServices {

    @POST("logIn")
    Call<LoginResponse> isValidUser(@Body RequestBody body);

    @POST("v2/getProfile")
    Call<User> getDataUser(@Header("token") String token);

}




