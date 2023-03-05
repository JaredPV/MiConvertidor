package com.example.convertidor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btn_temperatura, btn_masa, btn_volumen, btn_longitud;
    private ArrayList<String> unidades = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_temperatura = findViewById(R.id.btn_temperatura);
        btn_masa = findViewById(R.id.btn_masa);
        btn_volumen = findViewById(R.id.btn_volumen);
        btn_longitud = findViewById(R.id.btn_longitud);

        btn_temperatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unidades.clear();
                unidades.add("Fahrenheit");
                unidades.add("Celsius");
                unidades.add("Kelvin");
                Intent aCalculador = new Intent(getApplicationContext(), Convertidor.class);
                aCalculador.putExtra("unidades", unidades);
                startActivity(aCalculador);
            }
        });

        btn_masa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unidades.clear();
                unidades.add("Kilogramo");
                unidades.add("Gramo");
                unidades.add("Libra");
                unidades.add("Onza");
                Intent aCalculador = new Intent(getApplicationContext(), Convertidor.class);
                aCalculador.putExtra("unidades", unidades);
                startActivity(aCalculador);
            }
        });

        btn_volumen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unidades.clear();
                unidades.add("Litro");
                unidades.add("Mililitro");
                unidades.add("Galon");
                unidades.add("Onza Liquida");
                Intent aCalculador = new Intent(getApplicationContext(), Convertidor.class);
                aCalculador.putExtra("unidades", unidades);
                startActivity(aCalculador);
            }
        });

        btn_longitud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unidades.clear();
                unidades.add("Metro");
                unidades.add("Centimetro");
                unidades.add("Kilometro");
                unidades.add("Pulgada");
                unidades.add("Pie");
                unidades.add("Milla");
                Intent aCalculador = new Intent(getApplicationContext(), Convertidor.class);
                aCalculador.putExtra("unidades", unidades);
                startActivity(aCalculador);
            }
        });
    }


}