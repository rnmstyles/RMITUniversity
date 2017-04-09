package com.example.android.rmituniversity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.app.Activity;
import android.util.Log;
import android.widget.Button;

import com.example.androidswitchviews.R;

import static android.R.id.input;


public class MainActivity extends Activity {

    // Initializing variables
    EditText inputName;
    EditText inputBY;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //collecting variables
        inputName = (EditText) findViewById(R.id.name);
        inputBY = (EditText) findViewById(R.id.BY);
        Button eligibility = (Button) findViewById(R.id.eligibility);
        Button sendmessage = (Button) findViewById(R.id.sendmessage);


        //setting a listner for the button
        eligibility.setOnClickListener(new View.OnClickListener() {
            //the method the button runs
            public void onClick(View v) {
                //send it to the next screen
                Intent nextScreen = new Intent(getApplicationContext(), DisplayActivity.class);
                nextScreen.putExtra("name", inputName.getText().toString());
                nextScreen.putExtra("BY", inputBY.getText().toString());
                Log.e("n", inputName.getText() + "." + inputBY.getText());
                inputName.setText("");
                inputBY.setText("");
                startActivity(nextScreen);
            }
        });


        //setting a listner for the map button
        sendmessage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText name = (EditText) findViewById(R.id.name);
                String message = "Dear "+name.getText().toString()+
                        "This is an email about your eligibility for the course you applied for";
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:"));
                intent.putExtra("sms_body", message);
                if (intent.resolveActivity(getPackageManager()) !=null) {
                    startActivity(intent);
                }

            }

        });

    }
}

