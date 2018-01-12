package com.example.mac.groccerystore.view.mainactivity;

import com.example.mac.groccerystore.data.model.local.Item;

import java.util.List;

/**
 * Created by mac on 1/11/18.
 */

public interface MainActivityContract {
    interface View{
        void showPosts(List<Item> itemList);
        void  showError(String msg);
        void showComplete();
    }
    interface Presenter{
        void loadPosts();
    }
}
