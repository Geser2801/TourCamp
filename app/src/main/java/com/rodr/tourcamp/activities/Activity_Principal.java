package com.rodr.tourcamp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.rodr.tourcamp.R;

public class Activity_Principal extends AppCompatActivity {

    androidx.appcompat.widget.Toolbar toobalPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        //initGui();
        //soporteToolbar();
    }

    private void initGui(){
        //toobalPrincipal = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar_Principal);
    }

    private void soporteToolbar(){
        setSupportActionBar(toobalPrincipal);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.login:
                Toast.makeText(getApplicationContext(), "Login", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.help:
                //showHelp();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}