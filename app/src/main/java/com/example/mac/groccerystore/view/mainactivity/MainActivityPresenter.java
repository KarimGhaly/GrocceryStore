package com.example.mac.groccerystore.view.mainactivity;

import com.example.mac.groccerystore.data.model.Remote.APIService;
import com.example.mac.groccerystore.data.model.local.Post;

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

    Retrofit retrofit;
    MainActivityContract.View view;

    @Inject
    public MainActivityPresenter(Retrofit retrofit, MainActivityContract.View view) {
        this.retrofit = retrofit;
        this.view = view;
    }

    @Override
    public void loadPosts() {
        retrofit.create(APIService.class).getPostsList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io()).subscribe(new Observer<List<Post>>() {
            @Override
            public void onCompleted() {
                view.showComplete();
            }

            @Override
            public void onError(Throwable e) {
                view.showError(e.getMessage());
            }

            @Override
            public void onNext(List<Post> postList) {
                view.showPosts(postList);
            }
        });
    }
}
