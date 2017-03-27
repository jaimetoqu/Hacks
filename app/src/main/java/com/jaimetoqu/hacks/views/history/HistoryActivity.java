package com.jaimetoqu.hacks.views.history;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jaimetoqu.hacks.R;
import com.jaimetoqu.hacks.views.directory.DirectoryActivity;
import com.jaimetoqu.hacks.views.post.PostActivity;
import com.jaimetoqu.hacks.views.signupcompany.SignUpCompanyActivity;

public class HistoryActivity extends AppCompatActivity {


    private FloatingActionButton menuFab, companyFab, profileFab, companiesFab;
    private String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hackers);
        getSupportActionBar().setTitle("Historia");


        menuFab = (FloatingActionButton) findViewById(R.id.menuFab);
        companyFab = (FloatingActionButton) findViewById(R.id.companyFab);
        companiesFab = (FloatingActionButton) findViewById(R.id.companiesFab);
        profileFab = (FloatingActionButton) findViewById(R.id.profileFab);
        menuFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (menuFab.getRotation() != 0) {
                    hideFabs();
                } else {
                    showFabs();
                }
            }
        });

        companyFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HistoryActivity.this, SignUpCompanyActivity.class);
                startActivity(intent);
            }
        });

        companiesFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HistoryActivity.this, DirectoryActivity.class);
                startActivity(intent);
            }
        });

        profileFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HistoryActivity.this, PostActivity.class);
                startActivity(intent);
            }
        });

    }

    private void showFabs() {
        menuFab.animate().rotation(90).translationY(0).translationX(0).setDuration(400).start();
        companyFab.animate().translationX(-150).setDuration(600).start();
        companiesFab.animate().translationY(-150).setDuration(600).start();
        profileFab.animate().translationX(150).setDuration(600).start();

    }

    private void hideFabs() {
        menuFab.animate().rotation(0).translationY(0).translationX(0).setDuration(400).start();
        companyFab.animate().translationX(0).setDuration(600).start();
        companiesFab.animate().translationY(0).setDuration(600).start();
        profileFab.animate().translationX(0).setDuration(600).start();
    }

}

