package com.jaimetoqu.hacks.data;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by jaime on 3/20/17.
 */

public class CurrentUser {

    public FirebaseUser get() {
        return FirebaseAuth.getInstance().getCurrentUser();
    }

    public String userId() {
        return get().getUid();
    }

    public String email() {
        return get().getEmail();
    }


}
