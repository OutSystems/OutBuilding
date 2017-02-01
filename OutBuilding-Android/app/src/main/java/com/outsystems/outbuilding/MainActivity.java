package com.outsystems.outbuilding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;

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

        // Add adapter to AutoCompleteTextView
        autoCompleteTextView.setAdapter(adapter);

        autoCompleteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("AUTO_COMPLETE", "Click");

                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.blackBackground);
                linearLayout.setVisibility(View.VISIBLE);
            }
        });

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Log.d("AUTO_COMPLETE", "Item position: " + position);
                Log.d("AUTO_COMPLETE", "Item Value: " + parent.getItemAtPosition(position));

                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.blackBackground);
                linearLayout.setVisibility(View.INVISIBLE);
            }
        });
    }
}
