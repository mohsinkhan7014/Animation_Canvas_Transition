package com.mohsin.mohsinassaignmentca2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.nio.file.Path;

public class paint1 extends AppCompatActivity {

    Sketch_Pencil sketch_pencil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_paint1);
        sketch_pencil=new Sketch_Pencil(this);
        setContentView(sketch_pencil);
    }

    @Override
    public void finish() {
        super.finish();
        paint1.this.overridePendingTransition(R.anim.end_anim_startscene,R.anim.ending_scene);
    }
}