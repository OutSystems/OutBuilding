package com.outsystems.outbuilding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the image view so we can use for overlays
        //TouchImageView touchImg = (TouchImageView) findViewById(R.id.touchImageView);
    }
}
