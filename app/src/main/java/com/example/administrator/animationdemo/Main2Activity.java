package com.example.administrator.animationdemo;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    private ImageView animationIV;
    private Button buttonA, buttonB, buttonC;
    private AnimationDrawable animationDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main2);
        animationIV = (ImageView) findViewById(R.id.animationIV);
        buttonA = (Button) findViewById(R.id.buttonA);
        buttonB = (Button) findViewById(R.id.buttonB);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonA.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                animationIV.setImageResource(R.drawable.animation1);
                animationDrawable = (AnimationDrawable) animationIV.getDrawable();
                animationDrawable.start();
            }

        });

        buttonB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                animationDrawable = (AnimationDrawable) animationIV.getDrawable();
                animationDrawable.stop();
            }

        });

        buttonC.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                animationIV.setImageResource(R.drawable.animation2);
                animationDrawable = (AnimationDrawable) animationIV.getDrawable();
                animationDrawable.start();
            }
        });
    }
}