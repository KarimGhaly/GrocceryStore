package com.example.mac.groccerystore.data.component;

import com.example.mac.groccerystore.data.module.AppModule;
import com.example.mac.groccerystore.data.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by mac on 1/11/18.
 */
@Singleton
@Component(modules = {AppModule.class , NetModule.class} )
public interface NetComponent {
    Retrofit retrofit();
}
