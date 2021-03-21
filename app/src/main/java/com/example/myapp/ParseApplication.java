package com.example.myapp;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();
        // set applicationId, and server server based on the values in the back4app settings.
        // any network interceptors must be added with the Configuration Builder given this syntax
        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("qpnnhRkzn8n2YaqoRau101W30PuA8IEAL4ZrMGSY")
                .clientKey("DthZShmOx8MzzhQn2fIjF1WThdEH9CBOsbYxr5fY")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
