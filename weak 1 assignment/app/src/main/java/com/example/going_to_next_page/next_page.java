package com.example.going_to_next_page;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class next_page extends AppCompatActivity {
    TextView nametxt2;
    TextView passwordtxt2;
    TextView emailtxt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_page);

        nametxt2=(TextView) findViewById(R.id.nametxt2);
        passwordtxt2=(TextView) findViewById(R.id.passwordtxt2);
        emailtxt2=(TextView) findViewById(R.id.emailtxt2);
        Button messegeButton=(Button) findViewById(R.id.messegeButton);

        messegeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Bundle extractedData= getIntent().getExtras();
        nametxt2.append(extractedData.getString("Name"));
        passwordtxt2.append(extractedData.getString("Password"));
        emailtxt2.append(extractedData.getString("Email"));
    }
    @Override
    public void finish() {
        Intent intent2ndActivity=new Intent();
        EditText messegefor1stActivityEditText=(EditText) findViewById(R.id.messegeFor1stActivity);
        intent2ndActivity.putExtra("Messege",messegefor1stActivityEditText.getText().toString());

        setResult(RESULT_OK,intent2ndActivity);
        super.finish();
    }

}
