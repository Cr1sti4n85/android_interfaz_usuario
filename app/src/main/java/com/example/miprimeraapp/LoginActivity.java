package com.example.miprimeraapp;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.miprimeraapp.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLogin.setOnClickListener(v -> {
            validarCredenciales();
        });

        binding.tvForgot.setOnClickListener(v -> {
            Toast.makeText(this, "Funcionalidad no implementada", Toast.LENGTH_LONG).show();
        });


    }

    private void validarCredenciales(){
        // obtener textos del usuario
        String email = binding.etEmail.getText().toString().trim();

        String password = binding.etPassword.getText().toString().trim();

        if (email.isBlank()){
            binding.etEmail.setError("Campo requerido");
            binding.etEmail.requestFocus();

            return;
        } else if (password.isBlank()){
            binding.etPassword.setError("Campo requerido");
            binding.etPassword.requestFocus();
            return;
        }

        if (!email.equalsIgnoreCase("cperez@gmail.com") || !password.equals("12345")){
            Toast.makeText(this, "Credenciales inválidas", Toast.LENGTH_LONG).show();
            return;
        }

        loginUser();

    }

    private void loginUser(){
        binding.tvWelcome.setText("Has iniciado sesión");
        binding.tvWelcome.setTextColor(Color.MAGENTA);
        binding.btnLogin.setEnabled(false);
        binding.btnLogin.setText("Redireccionando...");
    }
}















