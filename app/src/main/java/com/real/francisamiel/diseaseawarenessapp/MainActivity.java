package com.real.francisamiel.diseaseawarenessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void process (View v){
        Intent i = null, chooser = null;
        if (v.getId() == R.id.diseases){
            i = new Intent(this, DiseaseList.class );
            startActivity(i);
        }

        else if (v.getId() == R.id.symptoms){
            i = new Intent(this, SymptomsSearch.class);
            startActivity(i);
        }

        else if (v.getId() == R.id.about){
            i = new Intent(this, About.class);
            startActivity(i);
        }
    }

}
