package com.example.miprimeraapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.miprimeraapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private boolean isAvailable = true;
    private int numeroProyectos = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        inicializarEventos();
    }

    private void inicializarEventos(){
        binding.btnContactar.setOnClickListener(v -> {
            Toast.makeText(this, "Enviando correo...", Toast.LENGTH_SHORT).show();

            numeroProyectos++;
            actualizarContadores();
        });

        binding.btnEstado.setOnClickListener(v -> {
            isAvailable = !isAvailable;
            actualizarVisualizacionEstado();
        });
    }

    private void actualizarContadores() {
        binding.tvProyectosCount.setText(String.valueOf(numeroProyectos));
    }

    private void actualizarVisualizacionEstado(){
        if (isAvailable){
            binding.btnEstado.setText("Disponible");
            binding.btnEstado.setBackgroundColor(getColor(R.color.teal));
            binding.tvCargo.setText("Android Developer");
        } else {
            binding.btnEstado.setText("Ocupado");
            binding.btnEstado.setBackgroundColor(getColor(R.color.darkRed));
            binding.tvCargo.setText("No molestar");

        }
    }
}