package com.android.mvpdemo.apis;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhaoruolei1992 on 2016/5/16.
 */
public class PersonApi {
    public static String BASE_URL = "http://www.mocky.io";
    private static RxService service;
    private PersonApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service=retrofit.create(RxService.class);
    }

    static class ApiHolder {
        private static PersonApi personApi = new PersonApi();
    }

    public static PersonApi getPersonApi() {
        return ApiHolder.personApi;
    }
    public RxService getRxService(){
        return service;
    }
}
