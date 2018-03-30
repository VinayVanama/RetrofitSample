package com.example.cykulapps.retrofitsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextName;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private EditText editTextEmail;

    private Button buttonRegister;

    //This is our root url
    public static final String ROOT_URL = "http://simplifiedcoding.16mb.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing Views
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        //Adding listener to button
        buttonRegister.setOnClickListener(this);

    }

    private void insertUser(){
        //Here we will handle the http request to insert user to mysql db

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .build();

        //Creating object for our interface
        RegisterAPI api = retrofit.create(RegisterAPI.class);

        api.insertUser(

                //Passing the values by getting it from editTexts
                editTextName.getText().toString(),
                editTextUsername.getText().toString(),
                editTextPassword.getText().toString(),
                editTextEmail.getText().toString(),

                //Creating an anonymous callback
                new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, Response<Response> response) {

                    }


                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {

                    }
                }
        );
    }

    @Override
    public void onClick(View v) {
        //Calling insertUser on button click
        insertUser();
    }
}
