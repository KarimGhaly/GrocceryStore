package com.example.mac.groccerystore;

import android.app.Application;

import com.example.mac.groccerystore.data.component.DaggerNetComponent;
import com.example.mac.groccerystore.data.component.NetComponent;
import com.example.mac.groccerystore.data.module.AppModule;
import com.example.mac.groccerystore.data.module.NetModule;

/**
 * Created by mac on 1/11/18.
 */

public class App extends Application {

    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://jsonplaceholder.typicode.com/"))
                .build();
    }
    public NetComponent getNetComponent(){
        return mNetComponent;
    }

}
