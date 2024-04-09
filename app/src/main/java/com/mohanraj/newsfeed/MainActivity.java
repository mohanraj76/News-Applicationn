package com.mohanraj.newsfeed;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static int splash_scn = 3000;

    Animation tpanim, btmanim;
    ImageView image;
    TextView logo, sswrd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        tpanim = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        btmanim = AnimationUtils.loadAnimation(this, R.anim.botom_anim);

        image = findViewById(R.id.image1);
        logo = findViewById(R.id.text1);
        sswrd = findViewById(R.id.text2);


        image.setAnimation(tpanim);
        logo.setAnimation(btmanim);
        sswrd.setAnimation(btmanim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();

            }
        }, splash_scn);

    }
}