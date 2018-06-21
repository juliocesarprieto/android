package com.example.jl.geren_hospitalar;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Prepara configuração do conector ao Web Service
 */
public class ConfigRetrofit {

    public static Retrofit config(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.5:7789/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return  retrofit;
    }

}
