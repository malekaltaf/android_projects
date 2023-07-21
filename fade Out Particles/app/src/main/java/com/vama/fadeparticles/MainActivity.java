package com.vama.fadeparticles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.appgozar.fadeoutparticle.FadeOutParticleFrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        FadeOutParticleFrameLayout fadeOutParticleFrameLayout = findViewById(R.id.fade_out_particle);
        //fadeOutParticleFrameLayout.startAnimation();
        Button hide = (Button) findViewById(R.id.hide);
        Button show = (Button) findViewById(R.id.show);

        hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fadeOutParticleFrameLayout.startAnimation();
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fadeOutParticleFrameLayout.reset();
            }
        });

    }
}