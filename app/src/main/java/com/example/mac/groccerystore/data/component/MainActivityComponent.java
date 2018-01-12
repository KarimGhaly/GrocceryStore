package com.example.mac.groccerystore.data.component;

import com.example.mac.groccerystore.data.module.MainActivityModule;
import com.example.mac.groccerystore.util.CustomScope;
import com.example.mac.groccerystore.view.mainactivity.MainActivity;

import dagger.Component;

/**
 * Created by mac on 1/11/18.
 */

@CustomScope
@Component(dependencies = NetComponent.class, modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(MainActivity activity);
}
