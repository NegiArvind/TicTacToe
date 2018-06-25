package com.example.arvind.tictactoe1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class firstPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
    }

    public void play(View view)
    {
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}
