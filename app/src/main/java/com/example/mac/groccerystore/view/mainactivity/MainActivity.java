package com.example.mac.groccerystore.view.mainactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.mac.groccerystore.App;
import com.example.mac.groccerystore.R;
import com.example.mac.groccerystore.data.component.DaggerMainActivityComponent;
import com.example.mac.groccerystore.data.model.local.Item;
import com.example.mac.groccerystore.data.module.MainActivityModule;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View{
    public static final String TAG = "MainActivityTAG";

    @Inject
    MainActivityPresenter presenter;

    RecyclerView RVList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RVList = findViewById(R.id.RVlist);

        DaggerMainActivityComponent.builder().netComponent(((App) getApplicationContext()).getNetComponent())
                .mainActivityModule(new MainActivityModule(this)).build().inject(this);

        presenter.loadPosts();
    }

    @Override
    public void showPosts(List<Item> itemList) {
        Adapter adapter = new Adapter(itemList);
        RVList.setAdapter(adapter);
        RVList.setLayoutManager(new LinearLayoutManager(this));
        RVList.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "showError: "+msg);
    }

    @Override
    public void showComplete() {
        Toast.makeText(this, "Completed", Toast.LENGTH_SHORT).show();

    }
}
