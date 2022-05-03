package com.rodr.tourcamp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.rodr.tourcamp.activities.Login_Activity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    TextView txtFrom, txtBeta;
    ImageView imgSplashScreen;
    Animation animacionDesplazamientoArriba, animacionDesplazamientoAbajo, animacionDesplazamientoIzquierda, animacionDesplazamientoDerecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //animacionLanzarLogin();
        initGui();
        animacionSplash();
    }

    /*private void animacionLanzarLogin(){
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), Login_Activity.class);
                startActivity(intent);
                finish();
            }
        };
        Timer tiempo = new Timer();
        tiempo.schedule(tarea, 5000);
    }*/

    private void initGui(){
        txtFrom = (TextView) findViewById(R.id.txt_From);
        txtBeta = (TextView) findViewById(R.id.txt_Beta);
        imgSplashScreen = (ImageView) findViewById(R.id.img_SplashScreen);

    }

    private void animacionSplash(){
        animacionDesplazamientoArriba = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animacion_desplazamiento_arriba);
        animacionDesplazamientoAbajo = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animacion_desplazamiento_abajo);
        animacionDesplazamientoDerecha = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animacion_desplazamiento_derecha);
        animacionDesplazamientoIzquierda = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animacion_desplazamiento_izquierda);

        txtFrom.setAnimation(animacionDesplazamientoAbajo);
        txtBeta.setAnimation(animacionDesplazamientoAbajo);
        imgSplashScreen.setAnimation(animacionDesplazamientoArriba);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), Login_Activity.class);
                startActivity(intent);
                finish();
            }
        },4000);
    }
}