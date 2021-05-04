package com.yayangrzv.mogaweid;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import api.LoginResponse;
import api.RetrofitFactory;
import api.RetrofitServices;
import model.ObjectClass;
import model.User;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HalamanDashboard extends AppCompatActivity implements Callback<User> {

    TextView user_name, user_code, user_mail, user_balance, user_points, user_downline;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_dashboard);

        SharedPreferences getToken = getApplicationContext().getSharedPreferences("token", Context.MODE_PRIVATE);
        String tokenString = getToken.getString("token", "missing");

        Log.d("Get Token @ dashboard", tokenString);

        user_name = findViewById(R.id.idUserName);
        user_code = findViewById(R.id.idCode);
        user_mail = findViewById(R.id.mailUser);
        user_balance = findViewById(R.id.tvMenu1);
        user_points = findViewById(R.id.tvMenu2);
        user_downline = findViewById(R.id.tvMenu3);

        Retrofit retrofit = RetrofitFactory.getRetrofit();
        RetrofitServices retrofitServices = retrofit.create(RetrofitServices.class);

        Map<String, Object> jsonParams = new ArrayMap<>();


        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),(new JSONObject(jsonParams)).toString());

        Call<User> call = retrofitServices.getDataUser(tokenString);

        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<User> call, Response<User> response) {
        User response1 = response.body();
        ObjectClass response2 = response1.getObject();
        Log.d("Dashboard Check: ", new Gson().toJson(response2));

        if (response2 != null){
            user_name.setText(response2.getFullName());
            Log.d("name", response2.getFullName());
            user_code.setText(response2.getMogawersCode());
            Log.d("name", response2.getMogawersCode());
            user_mail.setText(response2.getEmail());
            user_balance.setText("Rp." + response2.getBalance());
            user_points.setText(String.valueOf(response2.getPoints()) + " pts");
            user_downline.setText(String.valueOf(response2.getDouwnlineCount()) + " downline");
        }else{

            Log.d("failed @ dashboard", "null");
        }
    }


    @Override
    public void onFailure(Call<User> call, Throwable t) {

    }
}