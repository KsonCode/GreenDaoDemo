package com.bwie.greendaodemo.api;

import com.bwie.greendaodemo.entity.BaseResponse;
import com.bwie.greendaodemo.entity.CartBean;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;

public interface CartApiService {

    @GET(Api.CART_URL)
    Observable<BaseResponse<List<CartBean>>> getCarts(@HeaderMap HashMap<String,String> headers);
}
