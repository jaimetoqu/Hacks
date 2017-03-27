package com.jaimetoqu.hacks.views.signin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.BuildConfig;
import com.firebase.ui.auth.ResultCodes;
import com.jaimetoqu.hacks.R;
import com.jaimetoqu.hacks.views.history.HistoryActivity;

import java.util.Arrays;

public class SigninActivity extends AppCompatActivity implements SigninCallback {

    private static final int RC_SIGN_IN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        getSupportActionBar().hide();
        new SigninValidation(this).valid();

    }

    @Override
    public void signed() {
        startActivity(new Intent(this, HistoryActivity.class));
    }

    @Override
    public void sign() {
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setProviders(Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build()))
                        .setIsSmartLockEnabled(!BuildConfig.DEBUG)
                        .setTheme(R.style.FullscreenTheme)
                        .setLogo(R.color.colorPrimary)
                        .build(),
                RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (RC_SIGN_IN == requestCode) {
            if (ResultCodes.OK == resultCode) {
                signed();
            }
        }
    }
}
