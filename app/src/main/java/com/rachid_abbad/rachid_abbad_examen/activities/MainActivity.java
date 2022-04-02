package com.rachid_abbad.rachid_abbad_examen.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rachid_abbad.rachid_abbad_examen.R;

public class MainActivity extends AppCompatActivity {

    Button profs,mods,infos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profs = findViewById(R.id.profs);
        mods = findViewById(R.id.mods);
        infos = findViewById(R.id.infos);

        profs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Prof_Rachid_Activity.class);
                startActivity(intent);
            }
        });

        mods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Mod_Rachid_Activity.class);
                startActivity(intent);
            }
        });

        infos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Informations_Rachid_Activity.class);
                startActivity(intent);
            }
        });

    }
}