package com.example.project;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class secondactivity extends AppCompatActivity {


    private SharedPreferences myPreferenceRef;
    private SharedPreferences.Editor myPreferenceEditor;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myPreferenceRef = getPreferences(MODE_PRIVATE);
        myPreferenceEditor = myPreferenceRef.edit();

        final EditText editText = findViewById(R.id.editTextText);
        editText.setText(myPreferenceRef.getString("MyPersistentData", "No data found."));
        Button button = findViewById(R.id.button2);

        button.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                myPreferenceEditor.putString("MyPersistentData", editText.getText().toString());
                myPreferenceEditor.apply();
                finish();
            }
        });



    }
}
