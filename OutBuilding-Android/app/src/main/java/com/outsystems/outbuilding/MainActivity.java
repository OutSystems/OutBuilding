package com.outsystems.outbuilding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    private String[] people = {"Cesar Afonso", "Bruno Grácio", "João Ferreira", "Carlos Simões", "Calhau", "Calhordas", "CaCenas"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the image view so we can use for overlays
        //TouchImageView touchImg = (TouchImageView) findViewById(R.id.touchImageView);

        // Get a reference to the AutoCompleteTextView in the layout
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);

        // Create the adapter and set it to the AutoCompleteTextView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, people);
        autoCompleteTextView.setAdapter(adapter);
    }
}
