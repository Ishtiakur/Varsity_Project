package com.example.shobojit.siuapp.Home.Faculty_Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.shobojit.siuapp.Home.Syllabus_Activity.Cse_syl;
import com.example.shobojit.siuapp.Home.Syllabus_Activity.Ece_syl;
import com.example.shobojit.siuapp.Home.lab.cse_lab;
import com.example.shobojit.siuapp.R;

public class Eng_fac extends AppCompatActivity {
    Toolbar tl;
    Button csesyl,csisyl,ecesyl,cselab,csilab,ecelab;
    private Context cn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eng_fac);
        cn=this;
        Initialization();

        csesyl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         new Runnable(){
             @Override
             public void run() {
                 startActivity(new Intent(cn,Cse_syl.class));
             }
         }.run();

            }
        });
        cselab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Runnable(){
                    @Override
                    public void run() {
                startActivity(new Intent(cn,cse_lab.class).putExtra("Toolbar","Cse Lab"));}
                }.run();}
        });

        csilab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Runnable(){
                    @Override
                    public void run() {
                        startActivity(new Intent(cn,cse_lab.class).putExtra("Toolbar","Csi Lab"));}
                }.run();}
        });

        csisyl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Runnable(){
                    @Override
                    public void run() {
                        startActivity(new Intent(cn,Cse_syl.class));
                    }
                }.run();


            }
        });

        ecesyl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(cn,Ece_syl.class));

            }
        });
    }
    void Initialization(){
        tl= (Toolbar) findViewById(R.id.engtol);
        setSupportActionBar(tl);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        csesyl= (Button) findViewById(R.id.csesyl);
        csisyl= (Button) findViewById(R.id.csisyl);
        ecesyl= (Button) findViewById(R.id.ecesyl);
        cselab= (Button) findViewById(R.id.cselab);
        csilab= (Button) findViewById(R.id.csilab);
        ecelab= (Button) findViewById(R.id.ecelab);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}

