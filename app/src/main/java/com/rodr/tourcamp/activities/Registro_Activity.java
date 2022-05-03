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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.rodr.tourcamp.R;

public class Registro_Activity extends AppCompatActivity {
    ImageView imgLogoRegistro;
    EditText txtNombreRegistro, txtApellidoPRegistro, txtApellidoMRegistro, txtEmailRegistro, txtContraseniaRegistro, txtConfirmarContraseniaRegistro;
    TextView txtTituloRegistro, txtGeneroRegistro, txtTermCondiRegistro;
    RadioGroup rbGroudGeneroRegistro;
    RadioButton rbMasculinoRegistro, rbFemeninoRegistro;
    Button btnRegistrarseRegistro, btnRegresarLogin;
    Animation animacionDesplazamientoArriba, animacionDesplazamientoAbajo, animacionDesplazamientoIzquierda, animacionDesplazamientoDerecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        initGui();
        animacionRegistro();
        registrarse();
        backLogin();
    }

    private void initGui(){
        imgLogoRegistro = (ImageView) findViewById(R.id.img_Logo_Registro);
        txtNombreRegistro = (EditText) findViewById(R.id.txt_Nombre_Registro);
        txtApellidoPRegistro = (EditText) findViewById(R.id.txt_ApellidoP_Registro);
        txtApellidoMRegistro = (EditText) findViewById(R.id.txt_ApellidoM_Registro);
        txtEmailRegistro = (EditText) findViewById(R.id.txt_Email_Registro);
        txtContraseniaRegistro = (EditText) findViewById(R.id.txt_Contrasenia_Registro);
        txtConfirmarContraseniaRegistro = (EditText) findViewById(R.id.txt_Confirmar_Contrasenia_Registro);
        txtTituloRegistro = (TextView) findViewById(R.id.txt_Titulo_Registro);
        txtGeneroRegistro = (TextView) findViewById(R.id.txt_Genero_Registro);
        txtTermCondiRegistro = (TextView) findViewById(R.id.txt_Term_Condi_Registro);
        rbGroudGeneroRegistro = (RadioGroup) findViewById(R.id.rb_Groud_Genero_Registro);
        rbMasculinoRegistro = (RadioButton) findViewById(R.id.rb_Masculino_Registro);
        rbFemeninoRegistro = (RadioButton) findViewById(R.id.rb_Femenino_Registro);
        btnRegistrarseRegistro = (Button) findViewById(R.id.btn_Registrarse_Registro);
        btnRegresarLogin = (Button) findViewById(R.id.btn_Regresar_Login);
    }

    private void animacionRegistro(){
        animacionDesplazamientoArriba = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animacion_desplazamiento_arriba);
        animacionDesplazamientoAbajo = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animacion_desplazamiento_abajo);
        animacionDesplazamientoDerecha = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animacion_desplazamiento_derecha);
        animacionDesplazamientoIzquierda = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animacion_desplazamiento_izquierda);

        imgLogoRegistro.setAnimation(animacionDesplazamientoIzquierda);
        txtTituloRegistro.setAnimation(animacionDesplazamientoDerecha);
        txtNombreRegistro.setAnimation(animacionDesplazamientoAbajo);
        txtApellidoPRegistro.setAnimation(animacionDesplazamientoAbajo);
        txtApellidoMRegistro.setAnimation(animacionDesplazamientoAbajo);
        rbGroudGeneroRegistro.setAnimation(animacionDesplazamientoAbajo);
        txtEmailRegistro.setAnimation(animacionDesplazamientoAbajo);
        txtContraseniaRegistro.setAnimation(animacionDesplazamientoAbajo);
        txtConfirmarContraseniaRegistro.setAnimation(animacionDesplazamientoAbajo);
        btnRegistrarseRegistro.setAnimation(animacionDesplazamientoAbajo);
        txtTermCondiRegistro.setAnimation(animacionDesplazamientoAbajo);
    }

    private void registrarse(){
        btnRegistrarseRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarCamposRegistro();
            }
        });
    }

    private void backLogin(){
        btnRegresarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login_Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void validarCamposRegistro(){
        String fraseNombre, fraseApellidoP, fraseApellidoM, fraseEmail, frasePassword, frasePassConfirm;
        String strPass = txtContraseniaRegistro.getText().toString();
        String strPassConfirm = txtConfirmarContraseniaRegistro.getText().toString();

        fraseNombre = txtNombreRegistro.getText().toString();
        fraseApellidoP = txtApellidoPRegistro.getText().toString();
        fraseApellidoM = txtApellidoMRegistro.getText().toString();
        fraseEmail = txtEmailRegistro.getText().toString();
        frasePassword = txtContraseniaRegistro.getText().toString();
        frasePassConfirm = txtConfirmarContraseniaRegistro.getText().toString();


        //group.getCheckedRadioButtonId()<=0
        // rbMasculinoRegistro.isChecked() || rbFemeninoRegistro.isChecked()

        if (fraseNombre.isEmpty())
            txtNombreRegistro.setError("Introduzca un nombre");
        if (fraseApellidoP.isEmpty())
            txtApellidoPRegistro.setError("Agregue su Apellido Paterno");
        if (fraseApellidoM.isEmpty())
            txtApellidoMRegistro.setError("Agregue su Apellido Materno");
        if (rbMasculinoRegistro.isChecked() || rbFemeninoRegistro.isChecked()) {
            //Toast.makeText(getApplication(), "Seleccione el genero", Toast.LENGTH_SHORT).show();
            rbFemeninoRegistro.setError(null);
        } else {
            // Toast.makeText(getApplication(), "Seleccione el genero", Toast.LENGTH_SHORT).show();
            rbFemeninoRegistro.setError("Seleccione el genero");
        }
        if (fraseEmail.isEmpty())
            txtEmailRegistro.setError("Introduzca su correo");
        if (frasePassword.isEmpty())
            txtContraseniaRegistro.setError("Introduzca su contraseña");
        if (frasePassConfirm.isEmpty())
            txtConfirmarContraseniaRegistro.setError("Confirme su contraseña");
        else {
            if (Patterns.EMAIL_ADDRESS.matcher(fraseEmail).matches()){
                if (strPass.equals(strPassConfirm)) {
                    Intent intent = new Intent(getApplicationContext(), Login_Activity.class);
                    startActivity(intent);
                    finish();
                } else {
                    txtContraseniaRegistro.setError("Contraseña no compatibles");
                    txtConfirmarContraseniaRegistro.setError("Contraseña no compatibles");
                }
            } else {
                //Toast.makeText(getApplication(), "Formato de correo electronico", Toast.LENGTH_SHORT).show();
                txtEmailRegistro.setError("Correo no valido");
            }
        }
    }
}