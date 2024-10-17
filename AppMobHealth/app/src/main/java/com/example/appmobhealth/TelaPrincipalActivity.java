package com.example.appmobhealth;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaPrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_principal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void telalistadeexercicios(View view) {
        Intent in = new Intent(TelaPrincipalActivity.this, ListaExerciciosActivity.class);
        startActivity(in);
    }
    public void telatreinopersonalizado(View view) {
        Intent in = new Intent(TelaPrincipalActivity.this, TreinoPersonalizadoActivity.class);
        startActivity(in);
    }
}