package com.jaimetoqu.hacks.views.directory;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.jaimetoqu.hacks.R;
import com.jaimetoqu.hacks.models.Company;
import com.jaimetoqu.hacks.views.history.HistoryActivity;
import com.jaimetoqu.hacks.views.post.PostActivity;
import com.jaimetoqu.hacks.views.signupcompany.SignUpCompanyActivity;

import java.util.List;

public class DirectoryActivity extends AppCompatActivity implements DirectoryCallback {

    private DirectoryListFragment directoryListFragment;
    private FloatingActionButton menuFab, companyFab, profileFab, historyFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory);
        getSupportActionBar().setTitle("Directorio");

        directoryListFragment = (DirectoryListFragment) getSupportFragmentManager().findFragmentById(R.id.directoryListFragment);

        ImageButton searchIb = (ImageButton) findViewById(R.id.searchIb);
        searchIb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText searchEt = (EditText) findViewById(R.id.searchEt);
                String name = searchEt.getText().toString();
                SearchCompany searchCompany = new SearchCompany(DirectoryActivity.this);
                searchCompany.validate(name);
            }
        });

        menuFab = (FloatingActionButton) findViewById(R.id.menuFab);
        companyFab = (FloatingActionButton) findViewById(R.id.companyFab);
        historyFab = (FloatingActionButton) findViewById(R.id.historyFab);
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
                Intent intent = new Intent(DirectoryActivity.this, SignUpCompanyActivity.class);
                startActivity(intent);
            }
        });

        historyFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DirectoryActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });

        profileFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DirectoryActivity.this, PostActivity.class);
                startActivity(intent);
            }
        });

    }

    private void showFabs() {
        menuFab.animate().rotation(90).translationY(0).translationX(0).setDuration(400).start();
        companyFab.animate().translationX(-150).setDuration(600).start();
        historyFab.animate().translationY(-150).setDuration(600).start();
        profileFab.animate().translationX(150).setDuration(600).start();

    }

    private void hideFabs() {
        menuFab.animate().rotation(0).translationY(0).translationX(0).setDuration(400).start();
        companyFab.animate().translationX(0).setDuration(600).start();
        historyFab.animate().translationY(0).setDuration(600).start();
        profileFab.animate().translationX(0).setDuration(600).start();
    }


    @Override
    public void searched(List<Company> companies) {
        directoryListFragment.addCompany(companies);
    }

    @Override
    public void noName() {
        Toast.makeText(this, "Ingresa el nombre de la compañia", Toast.LENGTH_SHORT).show();
    }


}
