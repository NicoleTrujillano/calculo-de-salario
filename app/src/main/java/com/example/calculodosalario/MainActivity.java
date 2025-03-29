package com.example.calculodosalario;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText edtValor;
    private RadioGroup rdgGrupo;
    private RadioButton rdb40, rdb45, rdb50;
    private Button btnMostrar;
    private TextView txtNovo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializando as variáveis
        edtValor = findViewById(R.id.edtValor);
        rdgGrupo = findViewById(R.id.rdgGrupo);
        rdb40 = findViewById(R.id.rdb40);
        rdb45 = findViewById(R.id.rdb45);
        rdb50 = findViewById(R.id.rdb50);
        btnMostrar = findViewById(R.id.btnMostrar);
        txtNovo = findViewById(R.id.txtNovo);
    }


    public void mostrar(View v) {
        txtNovo.setText("");

        String valorString = edtValor.getText().toString(); // Converte o valor do EditText para String corretamente

        if (!valorString.isEmpty()) {
            int valor = Integer.parseInt(valorString); // Converte a String para inteiro
            double novo = 0;

            if (rdb40.isChecked()) {
                novo = valor * 1.40;
            } else if (rdb45.isChecked()){
                novo = valor * 1.45;
            } else if (rdb50.isChecked()){
                novo = valor * 1.50;
            }
            txtNovo.setText(String.valueOf(novo));

        } else {
            txtNovo.setText("Por favor, digite um valor.");
        }
    }
}