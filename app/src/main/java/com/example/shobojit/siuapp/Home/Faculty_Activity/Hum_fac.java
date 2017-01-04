package com.example.shobojit.siuapp.Home.Faculty_Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.shobojit.siuapp.Home.Faculty_Activity.Teacher_Detail.Eng_Teacher_Detail;
import com.example.shobojit.siuapp.R;

public class Hum_fac extends AppCompatActivity {
Toolbar tl;
    Button humfac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hum_fac);
        Initialization();
        humfac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Eng_Teacher_Detail.class));
            }
        });
    }

    void Initialization(){
        tl= (Toolbar) findViewById(R.id.humtol);
        setSupportActionBar(tl);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        humfac = (Button) findViewById(R.id.humfac);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
