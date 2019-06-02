package com.example.going_to_next_page;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   static final int REQUEST_CODE=20;

    EditText nametxt;
    EditText passwordtxt;
    EditText emailtxt;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nametxt=(EditText) findViewById(R.id.nametxt);
        passwordtxt=(EditText) findViewById(R.id.passwordtxt);
        emailtxt=(EditText) findViewById(R.id.emailtxt);
        button=(Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent=new Intent(MainActivity.this,next_page.class);
                myIntent.putExtra("Name",nametxt.getText().toString());
                myIntent.putExtra("Password",passwordtxt.getText().toString());
                myIntent.putExtra("Email",emailtxt.getText().toString());

                Toast.makeText(getApplicationContext(),"Button is Clicked",Toast.LENGTH_SHORT).show();

                startActivityForResult(myIntent,REQUEST_CODE);
            }
        });


    }
    @Override
        protected void onActivityResult(int request_Code,int result_Code,Intent data) {
        if ((request_Code == REQUEST_CODE) && (result_Code == RESULT_OK))
        {
            TextView messegeTextView = (TextView) findViewById(R.id.messegeTextView);
            messegeTextView .append(data.getExtras().getString("Messege"));
        }


    }
}
