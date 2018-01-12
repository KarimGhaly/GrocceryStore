package com.example.mac.groccerystore.data.module;

import com.example.mac.groccerystore.util.CustomScope;
import com.example.mac.groccerystore.view.mainactivity.MainActivityContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mac on 1/11/18.
 */
@Module
public class MainActivityModule {
    private final MainActivityContract.View mView;

    public MainActivityModule(MainActivityContract.View mView) {
        this.mView = mView;
    }

    @Provides
    @CustomScope
    MainActivityContract.View providesMainActivityScreenContractView(){
        return mView;
    }

}
