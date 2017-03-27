package com.jaimetoqu.hacks.views.post;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jaimetoqu.hacks.R;
import com.jaimetoqu.hacks.views.history.HistoryActivity;

public class PostActivity extends AppCompatActivity implements PostCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        getSupportActionBar().setTitle("Hacker");

        final EditText postEt = (EditText) findViewById(R.id.postEt);

        Button sendBtn = (Button) findViewById(R.id.sendBtn);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new CreatePost(PostActivity.this).hackerPost(postEt.getText().toString());
            }
        });
    }

    @Override
    public void newPost() {
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }

    @Override
    public void noData() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Faltan datos!").setMessage("Llena el campo para realizar tu post").show();
    }
}
