package com.example.spinthebottle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView bottle;
    int currentPos = 0;
    Random random = new Random();
    boolean spinning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottle = findViewById(R.id.bottle);
    }

    public void spin(View view)
    {
        if(!spinning) {
            int newPos = random.nextInt(3600);
            float pivoteX = bottle.getWidth() / 2;
            float pivoteY = bottle.getHeight() / 2;
            Animation animation = new RotateAnimation(currentPos, newPos, pivoteX, pivoteY);
            animation.setDuration(2000);
            animation.setFillAfter(true);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spinning = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spinning = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            currentPos = newPos;
            bottle.startAnimation(animation);

        }
    }
}
