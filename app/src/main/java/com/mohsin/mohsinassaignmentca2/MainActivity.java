package com.mohsin.mohsinassaignmentca2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity {


    ImageView image1;
    Button zoomin,zoomout,rotate,nextpage,combo,transition;
    AnimationDrawable animationDrawable;
    Animation ZoomInAnimation,ZoomOutAnimation,RotateAnimation,Movedown,comboanim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image1=findViewById(R.id.im1);
        zoomin=findViewById(R.id.zoomin);
        zoomout=findViewById(R.id.zoomout);
        rotate=findViewById(R.id.rotate);
        nextpage=findViewById(R.id.next);
        ZoomInAnimation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.zoomin);
        zoomin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    image1.startAnimation(ZoomInAnimation);

            }
        });

        ZoomOutAnimation=AnimationUtils.loadAnimation(MainActivity.this,R.anim.zoomout);
        zoomout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image1.startAnimation(ZoomOutAnimation);
            }
        });


        RotateAnimation=AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate);
        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image1.startAnimation(RotateAnimation);
            }
        });

        animationDrawable= (AnimationDrawable) image1.getBackground();
        Movedown=AnimationUtils.loadAnimation(MainActivity.this,R.anim.animation_moving);
        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image1.startAnimation(Movedown);
                animationDrawable.start();
            }
        });

        combo=findViewById(R.id.combo);
        comboanim=AnimationUtils.loadAnimation(MainActivity.this,R.anim.zoom_in_out_rotate);
        combo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 image1.startAnimation(comboanim);
            }
        });


        transition=findViewById(R.id.transition);
        transition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,paint1.class);
                startActivity(intent);
                MainActivity.this.overridePendingTransition(R.anim.starting_scene,R.anim.ending_scene);
            }
        });

    }
}