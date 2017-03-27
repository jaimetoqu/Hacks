package com.jaimetoqu.hacks.views.post;

import com.google.firebase.database.DatabaseReference;
import com.jaimetoqu.hacks.data.CurrentUser;
import com.jaimetoqu.hacks.data.Nodes;
import com.jaimetoqu.hacks.models.Post;

/**
 * Created by jaime on 2/27/17.
 */

public class CreatePost {

    private PostCallback callback;

    public CreatePost(PostCallback callback) {
        this.callback = callback;
    }

    public void hackerPost(String post) {

        if (post.trim().length() > 0) {

            CurrentUser user = new CurrentUser();
            String uid = user.userId();
            DatabaseReference reference = new Nodes().hackerPost(uid);
            String key = reference.push().getKey();
            Post newPost = new Post();
            newPost.setPost(post);
            newPost.setPostId(key);
            reference.child(key).setValue(newPost);

            callback.newPost();

        } else {
            callback.noData();
        }
    }
}
