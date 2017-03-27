package com.jaimetoqu.hacks.models;

import com.orm.SugarRecord;

/**
 * Created by jaime on 3/12/17.
 */

public class Hacker extends SugarRecord{

    private String post, email;

    public Hacker() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPost(String user) {
        this.post = user;
    }

    public String getPost() {
        return post;
    }
}
