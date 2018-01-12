package com.example.mac.groccerystore.view.mainactivity;

import com.example.mac.groccerystore.data.model.local.Post;

import java.util.List;

/**
 * Created by mac on 1/11/18.
 */

public interface MainActivityContract {
    interface View{
        void showPosts(List<Post> postList);
        void  showError(String msg);
        void showComplete();
    }
    interface Presenter{
        void loadPosts();
    }
}
