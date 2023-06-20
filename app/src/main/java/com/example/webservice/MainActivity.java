package com.example.webservice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showfb(View view) {
        Toast.makeText(this, "Facebook", Toast.LENGTH_SHORT).show();
    }

    public void showtw(View view) {
        Toast.makeText(this, "Twitter", Toast.LENGTH_SHORT).show();
    }

    public void showst(View view) {
        Toast.makeText(this, "Intagram", Toast.LENGTH_SHORT).show();
    }

    public void login(View view) {
        startActivity(new Intent(getApplicationContext(), MainPage.class));
    }
    }