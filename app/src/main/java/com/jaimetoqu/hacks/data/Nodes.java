package com.jaimetoqu.hacks.data;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by jaime on 3/18/17.
 */

public class Nodes {

    private DatabaseReference root() {
        return FirebaseDatabase.getInstance().getReference();
    }

    public DatabaseReference companies() {
        return root().child("companies");
    }

    public DatabaseReference hackers() {
        return root().child("hackers");
    }

    public DatabaseReference companyName(String name) {
        return companies().child(name);
    }

    public DatabaseReference hackerId(String id) {
        return hackers().child(id);
    }

    public DatabaseReference hackerPost(String postId) {return hackers().child(postId);}

}
