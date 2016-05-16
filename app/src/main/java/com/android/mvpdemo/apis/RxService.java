package com.android.mvpdemo.apis;

import com.android.mvpdemo.bean.Person;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by zhaoruolei1992 on 2016/5/16.
 */
public interface RxService {
    @GET("/v2/573982200f0000a120b12235")
    Observable<List<Person>> fetchPersonResult();
}
