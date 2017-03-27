package com.jaimetoqu.hacks.views.signupcompany;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jaimetoqu.hacks.R;
import com.jaimetoqu.hacks.views.directory.DirectoryActivity;


public class SignUpCompanyActivity extends AppCompatActivity implements SignUpCompanyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_company);
        getSupportActionBar().setTitle("Registrate como Empresa");

        final EditText nameEt = (EditText) findViewById(R.id.nameEt);
        final EditText bountyEt = (EditText) findViewById(R.id.bountyEt);
        final EditText emailEt = (EditText) findViewById(R.id.emailEt);
        final EditText webSiteEt = (EditText) findViewById(R.id.webSiteEt);

        Button sendBtn = (Button) findViewById(R.id.sendBt);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = nameEt.getText().toString();
                final String bounty = bountyEt.getText().toString();
                final String email = emailEt.getText().toString();
                final String webSite = webSiteEt.getText().toString();

                CreateSignUpCompany createSignUpCompany = new CreateSignUpCompany(SignUpCompanyActivity.this);
                createSignUpCompany.valid(name, bounty, email, webSite);

            }
        });
    }

    @Override
    public void signedCompany(String name, int bounty, String email, String webSite) {

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Bienvenido!").setMessage("Gracias por registrarte como empresa").show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SignUpCompanyActivity.this, DirectoryActivity.class);
                startActivity(intent);
            }
        }, 2000);
    }

    @Override
    public void noCompany() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Faltan datos!").setMessage("Por favor llena la informacion restante").show();
    }
}
