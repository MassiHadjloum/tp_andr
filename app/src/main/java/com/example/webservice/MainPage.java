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

public class MainPage extends AppCompatActivity {

    private Retrofit retrofit;
    private ItemShowService itemShowService;
    private Call<ItemShowRoot> itemShowRootCall;
    //private static final String BASE_URL = "https://www.episodate.com/api/";
    private static final String BASE_URL = "https://api.disneyapi.dev/";
    private Thread thread;
    private RecyclerView itemShowRecycler;
    private ItemShowAdapter itemShowAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        itemShowRecycler = findViewById(R.id.itemShowRecycler);
        layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        // Client Retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // Création d'une implémentation de l'interface TvShowService
        itemShowService = retrofit.create(ItemShowService.class);
        itemShowRootCall = itemShowService.getItemShowList();
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response<ItemShowRoot> response = itemShowRootCall.execute();
                    if (response.isSuccessful()){
                        List<ItemShow> tvShowList = response.body().getItemShowList();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                itemShowAdapter = new ItemShowAdapter(
                                        getApplicationContext(),
                                        tvShowList
                                );
                                itemShowRecycler.setAdapter(itemShowAdapter);
                                itemShowRecycler.setLayoutManager(layoutManager);
                                itemShowRecycler.setHasFixedSize(true);
                            }
                        });
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();

    }


}