package com.example.myapp.fragments;

import android.util.Log;

import com.example.myapp.Post;
import com.parse.ParseQuery;
import com.parse.ParseUser;

public class ProfileFragment extends PostsFragment {
    @Override
    protected void queryPosts() {
        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
        query.include(Post.KEY_USER);
        query.setLimit(20);
        query.whereEqualTo(Post.KEY_USER, ParseUser.getCurrentUser());
        query.addDescendingOrder(Post.KEY_CREATED_AT);
        query.findInBackground((posts, e) -> {
            if (e != null) {
                Log.e(TAG, "Issue with login", e);
                return;
            }
            mPosts.addAll(posts);
            adapter.notifyDataSetChanged();
            for (Post post : posts) {
                Log.i(TAG, "Post: " + post.getDescription() + ", username:" + post.getUser().getUsername());
            }



        });
    }
}


