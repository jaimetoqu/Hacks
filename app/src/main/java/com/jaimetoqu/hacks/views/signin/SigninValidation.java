package com.jaimetoqu.hacks.views.signin;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by jaime on 3/15/17.
 */

public class SigninValidation {

    private SigninCallback callback;

    public SigninValidation(SigninCallback callback) {
        this.callback = callback;
    }

    public void valid() {
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            callback.signed();
        } else {
            callback.sign();
        }
    }
}
