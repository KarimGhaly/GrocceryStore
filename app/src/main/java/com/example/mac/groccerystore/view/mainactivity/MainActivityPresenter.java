package com.example.mac.groccerystore.view.mainactivity;

import com.example.mac.groccerystore.data.model.Remote.APIService;
import com.example.mac.groccerystore.data.model.local.JsonResponse;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by mac on 1/11/18.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {
    public static final String format = "JSON";
    public static final String ApiKEY = "64kj2sd7rh9e6bv26eqpa5s6";

    Retrofit retrofit;
    MainActivityContract.View view;

    @Inject
    public MainActivityPresenter(Retrofit retrofit, MainActivityContract.View view) {
        this.retrofit = retrofit;
        this.view = view;
    }

    @Override
    public void loadPosts() {
        retrofit.create(APIService.class).getPostsList("Chicken", format,ApiKEY).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io()).subscribe(new Observer<JsonResponse>() {
            @Override
            public void onCompleted() {
                view.showComplete();
            }

            @Override
            public void onError(Throwable e) {
                view.showError(e.getMessage());
            }

            @Override
            public void onNext(JsonResponse jsonResponse) {
                view.showPosts(jsonResponse.getItems());
            }
        });
    }
}
