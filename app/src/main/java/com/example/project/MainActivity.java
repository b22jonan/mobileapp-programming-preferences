package com.example.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    // in My MainActivity class
    private SharedPreferences myPreferenceRef;
    private SharedPreferences.Editor myPreferenceEditor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // In onCreate()
        myPreferenceRef = getSharedPreferences("preferences", MODE_PRIVATE);
        myPreferenceEditor = myPreferenceRef.edit();

        Button button = findViewById(R.id.button);

        final TextView editText = findViewById(R.id.preferenceText);
        editText.setText(myPreferenceRef.getString("MyPersistentData", "No data found."));



        // set onClickListener for button
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.d("iamlogginglikehell", "iamlogginglikehell");
                Intent intent = new Intent(MainActivity.this, secondactivity.class);
                // start second activity
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView preferenceView = findViewById(R.id.preferenceText);
        preferenceView.setText(myPreferenceRef.getString("MyPersistentData", "No preference found."));
        myPreferenceEditor.apply();
    }
}


