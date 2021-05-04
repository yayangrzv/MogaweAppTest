package com.yayangrzv.mogaweid;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.preference.PreferenceManager;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Map;

import api.LoginResponse;
import api.RetrofitFactory;
import api.RetrofitServices;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Callback<LoginResponse> {

    private static final String TAG = "Check Log: ";
    EditText email, password;
    MaterialCardView signIn;
    String textmail, textpassword, encoded;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.inputEmail);
        password = findViewById(R.id.typePassword);

        signIn = findViewById(R.id.btnLogin);


        signIn.setOnClickListener(this);


    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {

        if (v == signIn){
            textmail = email.getText().toString();
            textpassword = password.getText().toString();

            encoded = getSHA256(textpassword);


            Log.d(TAG, "email : " + textmail);
            Log.d(TAG, "password : " + encoded);

            Retrofit retrofit = RetrofitFactory.getRetrofit();
            RetrofitServices retrofitServices = retrofit.create(RetrofitServices.class);

            // prepare call in Retrofit 2.0
            try {
                Map<String, Object> jsonParams = new ArrayMap<>();
                JSONObject paramObject = new JSONObject();
                paramObject.put("email", textmail);
                paramObject.put("password", encoded);

                jsonParams.put("email", textmail);
                jsonParams.put("password", encoded);

                RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),(new JSONObject(jsonParams)).toString());


                Call<LoginResponse> call = retrofitServices.isValidUser(body);

                Log.d("json: ", body.toString());

                call.enqueue(this);

            } catch (JSONException e) {
                e.printStackTrace();
                Log.d("Error1: ", e.toString());
            }
        }
    }

    public static String getSHA256(String data){
        StringBuffer sb = new StringBuffer();
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(data.getBytes());
            byte byteData[] = md.digest();

            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return sb.toString();
    }

    @Override
    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
        LoginResponse response1 = response.body();
        Log.d("Check: ", new Gson().toJson(response));

        if (response1 != null){
            SharedPreferences userToken = getApplicationContext().getSharedPreferences("token", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = userToken.edit();
            editor.putString("token", response1.getToken());
            editor.apply();
            Intent i = new Intent(getApplicationContext(), HalamanDashboard.class);
            startActivity(i);
            Log.i("Token", response1.getToken());
        }else{

            Log.d("failed", "null");
        }
    }

    @Override
    public void onFailure(Call<LoginResponse> call, Throwable t) {
        t.printStackTrace();
        Toast.makeText(getApplicationContext()," Error..." ,Toast.LENGTH_LONG).show();
    }
}