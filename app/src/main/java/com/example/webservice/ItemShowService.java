package com.example.webservice;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ItemShowService {
    @GET("character")
    Call<ItemShowRoot> getItemShowList();

    //@GET("most-popular")
   // Call<ItemShowRoot> getItemShowList(@Query("page") int page);


}
