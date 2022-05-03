package com.rodr.tourcamp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rodr.tourcamp.R;

public class Login_Activity extends AppCompatActivity {

    Button btnIniciarSesion;
    EditText txtEmail, txtPassword;
    ImageView imgLogoLogin;
    TextView txtRegistrate, txtTituloLogin, txtRegistrateAqui;
    Animation animacionDesplazamientoArriba, animacionDesplazamientoAbajo, animacionDesplazamientoIzquierda, animacionDesplazamientoDerecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initGui();
        lanzarActivityPrincipal();
        lanzarRegistrarse();
        animacionLogin();
    }

    private void initGui(){
        btnIniciarSesion = (Button) findViewById(R.id.btn_Iniciar_Sesion);
        txtEmail = (EditText) findViewById(R.id.txt_Email);
        txtPassword = (EditText) findViewById(R.id.txt_Password);
        imgLogoLogin = (ImageView) findViewById(R.id.img_Logo_Login);
        txtRegistrate = (TextView) findViewById(R.id.txt_Registrate);
        txtTituloLogin = (TextView) findViewById(R.id.txt_Titulo_Login);
        txtRegistrateAqui = (TextView) findViewById(R.id.txt_Registrate_Aqui);
    }

    private void lanzarActivityPrincipal(){
        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*if (txtEmail.getText().length()==0 || txtPassword.getText().length()==0)
                    Toast.makeText(getApplicationContext(), "Verifique los datos", Toast.LENGTH_SHORT).show();
                else {
                    Intent intent = new Intent(getApplicationContext(), Activity_Principal.class);
                    startActivity(intent);
                    finish();
                }*/

                Intent intent = new Intent(getApplicationContext(), Activity_Principal.class);

                String fraseEmail = txtEmail.getText().toString();
                String frasePassword = txtPassword.getText().toString();

                if (fraseEmail.isEmpty())
                    txtEmail.setError("Introduzca su correo");
                if (frasePassword.isEmpty())
                    txtPassword.setError("Introduzca su contraseña");
                else {
                    if (Patterns.EMAIL_ADDRESS.matcher(fraseEmail).matches()) {
                        startActivity(intent);
                        finish();
                    } else {
                        //Toast.makeText(getApplicationContext(), "Correo incorrecto", Toast.LENGTH_SHORT).show();
                        txtEmail.setError("Correo no valido");
                    }
                }
            }
        });
    }

    private void lanzarRegistrarse(){
        txtRegistrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Registro_Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void animacionLogin(){
        animacionDesplazamientoArriba = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animacion_desplazamiento_arriba);
        animacionDesplazamientoAbajo = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animacion_desplazamiento_abajo);
        animacionDesplazamientoDerecha = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animacion_desplazamiento_derecha);
        animacionDesplazamientoIzquierda = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animacion_desplazamiento_izquierda);

        txtTituloLogin.setAnimation(animacionDesplazamientoArriba);
        imgLogoLogin.setAnimation(animacionDesplazamientoArriba);
        txtEmail.setAnimation(animacionDesplazamientoDerecha);
        txtPassword.setAnimation(animacionDesplazamientoIzquierda);
        btnIniciarSesion.setAnimation(animacionDesplazamientoAbajo);
        txtRegistrateAqui.setAnimation(animacionDesplazamientoAbajo);
        txtRegistrate.setAnimation(animacionDesplazamientoAbajo);
    }
}