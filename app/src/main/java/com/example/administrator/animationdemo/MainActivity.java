package com.example.administrator.animationdemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
ImageView imageView;
    Button button;
    private Animation myAnimation;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView= (ImageView) findViewById(R.id.ig);
        button5= (Button) findViewById(R.id.zhen);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent);
                finish();
            }
        });
        button= (Button) findViewById(R.id.but);
        button.setOnClickListener(this);
        button1= (Button) findViewById(R.id.but2);
        button1.setOnClickListener(this);
        button2= (Button) findViewById(R.id.but1);
        button2.setOnClickListener(this);
        button3= (Button) findViewById(R.id.but3);
        button3.setOnClickListener(this);
        button4= (Button) findViewById(R.id.but4);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //xml 补间动画
            case R.id.but2:
                myAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_anim);
                imageView.startAnimation(myAnimation);
                break;
            case R.id.but:
                myAnimation = AnimationUtils.loadAnimation(this, R.anim.my_anim);
                imageView.startAnimation(myAnimation);
                break;
            case R.id.but1:
                myAnimation=AnimationUtils.loadAnimation(this,R.anim.translate_anim);
                imageView.startAnimation(myAnimation);
                break;
            case R.id.but3:
                myAnimation=AnimationUtils.loadAnimation(this,R.anim.rotate);
                imageView.startAnimation(myAnimation);
                break;
            //java补间动画
            case R.id.but4:
                ObjectAnimator moveIn = ObjectAnimator.ofFloat(imageView, "translationX", -500f, 0f);
                ObjectAnimator animator=ObjectAnimator.ofFloat(imageView,"alpha", 1f, 0f, 1f);
                ObjectAnimator rotate = ObjectAnimator.ofFloat(imageView, "rotation", 0f, 360f);
                AnimatorSet animSet = new AnimatorSet();
                animSet.play(animator).with(rotate).after(moveIn);
                animSet.setDuration(5000);
                animSet.start();
                animSet.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        Toast.makeText(MainActivity.this,"结束",Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }
    }

}
