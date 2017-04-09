package com.example.android.rmituniversity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.example.androidswitchviews.R;


public class DisplayActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displayactivity);


        //set and collect variables
        int currentYear = 2017;
        Intent intent = getIntent();
        String birthYear = intent.getStringExtra("BY");
        String name = intent.getStringExtra("name");


        //calculate/convert the age variable using year and current year
        int intYear = Integer.parseInt(birthYear);
        int age = currentYear - intYear;
        //convert back to string
        String currentAge = Integer.toString(age);



        //if else statement for their eligibility (if they are over 20 years old)
        if(age >= 20){
            //print it in the txtOver
            TextView elegible = (TextView) findViewById(R.id.txtOver);
            elegible.setText("Your Age Is over 20 - ELIGIBLE");
        }else{
            TextView elegible = (TextView) findViewById(R.id.txtOver);
            elegible.setText("You are younger than 20 - NOT ELIGIBLE");
        }

        //printing the calculations and collections into the required boxes
        final TextView txtName = (TextView) findViewById(R.id.txtName);
        final TextView txtYob = (TextView) findViewById(R.id.txtBy);
        final TextView txtAge = (TextView) findViewById(R.id.txtAge);
        txtName.setText(name);
        txtYob.setText(birthYear);
        txtAge.setText("Your age is " +currentAge );





    }


}

