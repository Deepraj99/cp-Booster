package com.example.cpbooster;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1, button2;
    int clickedTag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setCustomView(R.layout.action_bar_layout);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }
    public void openActivity2(){
        Intent intent = new Intent(this, CalculationActivity.class);
        intent.putExtra("intVariableName", clickedTag);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        Button clickedButton = findViewById(v.getId());
        clickedTag = Integer.parseInt(v.getTag().toString());
        openActivity2();
    }
}

