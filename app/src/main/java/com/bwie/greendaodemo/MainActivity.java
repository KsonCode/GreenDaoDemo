package com.bwie.greendaodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bwie.greendaodemo.api.Api;
import com.bwie.greendaodemo.api.CartApiService;
import com.bwie.greendaodemo.entity.BaseResponse;
import com.bwie.greendaodemo.entity.CartBean;
import com.bwie.greendaodemo.entity.CartEntity;
import com.bwie.greendaodemo.entity.ShoppingCartListBean;
import com.bwie.greendaodemo.utils.GreenDaoUtils;

import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestData();
    }

    private void requestData() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        HashMap<String, String> params = new HashMap<>();
        params.put("userId", "3377");
        params.put("sessionId", "15634215000223377");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CartApiService cartApiService = retrofit.create(CartApiService.class);
        cartApiService.getCarts(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaseResponse<List<CartBean>>>() {
                    @Override
                    public void accept(BaseResponse<List<CartBean>> cartBean) throws Exception {

                        //第一步是刷新适配器

                        //第二步存库
                        saveData(cartBean.result);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    /**
     * 存库
     *
     * @param cartBeanList
     */
    private void saveData(List<CartBean> cartBeanList) {

        if (cartBeanList != null && cartBeanList.size() > 0) {
            for (int i = 0; i < cartBeanList.size(); i++) {
                CartEntity cartEntity = new CartEntity();
                cartEntity.setCategoryId((long) i);
                cartEntity.categoryName = cartBeanList.get(i).categoryName;
                GreenDaoUtils.getInstance().getDaoSession().getCartEntityDao().insertOrReplaceInTx(cartEntity);

                for (int i1 = 0; i1 < cartBeanList.get(i).shoppingCartList.size(); i1++) {
                    ShoppingCartListBean shoppingCartListBean = new ShoppingCartListBean();
                    shoppingCartListBean.commodityId = cartBeanList.get(i).shoppingCartList.get(i1).commodityId;
                    shoppingCartListBean.commodityName = cartBeanList.get(i).shoppingCartList.get(i1).commodityName;
                    shoppingCartListBean.setCategoryId((long) i);
                    GreenDaoUtils.getInstance().getDaoSession().getShoppingCartListBeanDao().insertOrReplaceInTx(shoppingCartListBean);

                }
            }

            List<CartEntity> cartEntityList = GreenDaoUtils.getInstance().getDaoSession().loadAll(CartEntity.class);
            System.out.println("cartEntity：size"+cartEntityList.size());
            for (CartEntity cartEntity : cartEntityList) {

                System.out.println("cartshoplist：size"+cartEntity.shoppingCartList.get(0).commodityId);

            }


        }

    }
}
