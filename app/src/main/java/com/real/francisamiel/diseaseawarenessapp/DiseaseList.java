package com.real.francisamiel.diseaseawarenessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.FirebaseApp;

import java.util.ArrayList;

public class DiseaseList extends AppCompatActivity {

    ArrayList<String> myArrayList = new ArrayList<>();
    ListView myListView;
    Firebase myFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_list);

        Firebase.setAndroidContext(this);
        myFirebase = new Firebase("https://diseaseawarenessapp.firebaseio.com/");
        final ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myArrayList);
        myListView = (ListView) findViewById(R.id.disease_list);
        myListView.setAdapter(myArrayAdapter);

        myFirebase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String myChildValues = dataSnapshot.getValue(String.class);
                myArrayList.add(myChildValues);
                myArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                myArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent myIntent = new Intent(view.getContext(),Asthma.class);
                    startActivityForResult(myIntent,0);
                }
                if (position==1){
                    Intent myIntent = new Intent(view.getContext(),BreastCancer.class);
                    startActivityForResult(myIntent,1);
                }
                if (position==2){
                    Intent myIntent = new Intent(view.getContext(),ChronicKidneyDisease.class);
                    startActivityForResult(myIntent,2);
                }
                if (position==3){
                    Intent myIntent = new Intent(view.getContext(),CoronaryHeartDisease.class);
                    startActivityForResult(myIntent,3);
                }
                if (position==4){
                    Intent myIntent = new Intent(view.getContext(),Diabetes.class);
                    startActivityForResult(myIntent,4);
                }
                if (position==5){
                    Intent myIntent = new Intent(view.getContext(),Hypertension.class);
                    startActivityForResult(myIntent,5);
                }
                if (position==6){
                    Intent myIntent = new Intent(view.getContext(),Malaria.class);
                    startActivityForResult(myIntent,6);
                }
                if (position==7){
                    Intent myIntent = new Intent(view.getContext(),Pneumonia.class);
                    startActivityForResult(myIntent,7);
                }
                if (position==8){
                    Intent myIntent = new Intent(view.getContext(),Stroke.class);
                    startActivityForResult(myIntent,8);
                }
                if (position==9){
                    Intent myIntent = new Intent(view.getContext(),Tubercolosis.class);
                    startActivityForResult(myIntent,9);
                }
            }
        });

    }
}
