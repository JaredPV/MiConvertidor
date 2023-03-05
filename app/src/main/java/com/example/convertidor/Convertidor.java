package com.example.convertidor;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class Convertidor extends AppCompatActivity {

    private Spinner sp_unidad1, sp_unidad2;
    private EditText tn_entrada1, tn_entrada2;
    private ImageView iv_referencia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertidor);
        ArrayList<String> unidades_al = (ArrayList<String>) getIntent().getSerializableExtra("unidades");

        sp_unidad1 = findViewById(R.id.sp_unidad1);
        sp_unidad2 = findViewById(R.id.sp_unidad2);

        tn_entrada1 = findViewById(R.id.tn_entrada1);
        tn_entrada2 = findViewById(R.id.tn_entrada2);

        iv_referencia = findViewById(R.id.iv_referencia);

        if(unidades_al.get(0).equals("Fahrenheit")){
            getSupportActionBar().setTitle(R.string.btn_temperatura);
            iv_referencia.setImageResource(R.drawable.temperatura);
        } else if (unidades_al.get(0).equals("Kilogramo")) {
            getSupportActionBar().setTitle(R.string.btn_masa);
            iv_referencia.setImageResource(R.drawable.masa);
        } else if (unidades_al.get(0).equals("Litro")) {
            getSupportActionBar().setTitle(R.string.btn_volumen);
            iv_referencia.setImageResource(R.drawable.volumen);
        }else{
            getSupportActionBar().setTitle(R.string.btn_longitud);
            iv_referencia.setImageResource(R.drawable.longitud);
        }

        ArrayAdapter unidades_aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item,unidades_al);

        unidades_aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp_unidad1.setAdapter(unidades_aa);
        sp_unidad2.setAdapter(unidades_aa);

        tn_entrada1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction()==KeyEvent.ACTION_UP){
                    if(tn_entrada1.getText().length()==0){
                        tn_entrada2.setText(null);
                        return false;
                    }
                    if(unidades_al.get(0).equals("Fahrenheit")){
                        double resultado = calcularTemperatura(Double.parseDouble(tn_entrada1.getText().toString()),sp_unidad1.getSelectedItem().toString(), sp_unidad2.getSelectedItem().toString());
                        tn_entrada2.setText(String.valueOf(resultado));
                    } else if (unidades_al.get(0).equals("Kilogramo")) {
                        double resultado = calcularMasa(Double.parseDouble(tn_entrada1.getText().toString()),sp_unidad1.getSelectedItem().toString(), sp_unidad2.getSelectedItem().toString());
                        tn_entrada2.setText(String.valueOf(resultado));
                    } else if (unidades_al.get(0).equals("Litro")) {
                        double resultado = calcularVolumen(Double.parseDouble(tn_entrada1.getText().toString()),sp_unidad1.getSelectedItem().toString(), sp_unidad2.getSelectedItem().toString());
                        tn_entrada2.setText(String.valueOf(resultado));
                    } else {
                        double resultado = calcularLongitud(Double.parseDouble(tn_entrada1.getText().toString()),sp_unidad1.getSelectedItem().toString(), sp_unidad2.getSelectedItem().toString());
                        tn_entrada2.setText(String.valueOf(resultado));
                    }

                }

                return false;
            }
        });
        tn_entrada2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction()==KeyEvent.ACTION_UP){
                    if(tn_entrada2.getText().length()==0){
                        tn_entrada1.setText(null);
                        return false;
                    }
                    if(unidades_al.get(0).equals("Fahrenheit")){
                        double resultado = calcularTemperatura(Double.parseDouble(tn_entrada2.getText().toString()),sp_unidad2.getSelectedItem().toString(), sp_unidad1.getSelectedItem().toString());
                        tn_entrada1.setText(String.valueOf(resultado));
                    } else if (unidades_al.get(0).equals("Kilogramo")) {
                        double resultado = calcularMasa(Double.parseDouble(tn_entrada2.getText().toString()),sp_unidad2.getSelectedItem().toString(), sp_unidad1.getSelectedItem().toString());
                        tn_entrada1.setText(String.valueOf(resultado));
                    } else if (unidades_al.get(0).equals("Litro")) {
                        double resultado = calcularVolumen(Double.parseDouble(tn_entrada2.getText().toString()),sp_unidad2.getSelectedItem().toString(), sp_unidad1.getSelectedItem().toString());
                        tn_entrada1.setText(String.valueOf(resultado));
                    } else {
                        double resultado = calcularLongitud(Double.parseDouble(tn_entrada2.getText().toString()),sp_unidad2.getSelectedItem().toString(), sp_unidad1.getSelectedItem().toString());
                        tn_entrada1.setText(String.valueOf(resultado));
                    }

                }

                return false;
            }
        });

        sp_unidad1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(tn_entrada1.getText().length()!= 0 || tn_entrada1.getText().length()!=0){
                    if (unidades_al.get(0).equals("Fahrenheit")) {
                        double resultado = calcularTemperatura(Double.parseDouble(tn_entrada1.getText().toString()), sp_unidad1.getSelectedItem().toString(), sp_unidad2.getSelectedItem().toString());
                        tn_entrada2.setText(String.valueOf(resultado));
                    } else if (unidades_al.get(0).equals("Kilogramo")) {
                        double resultado = calcularMasa(Double.parseDouble(tn_entrada1.getText().toString()), sp_unidad1.getSelectedItem().toString(), sp_unidad2.getSelectedItem().toString());
                        tn_entrada2.setText(String.valueOf(resultado));
                    } else if (unidades_al.get(0).equals("Litro")) {
                        double resultado = calcularVolumen(Double.parseDouble(tn_entrada1.getText().toString()), sp_unidad1.getSelectedItem().toString(), sp_unidad2.getSelectedItem().toString());
                        tn_entrada2.setText(String.valueOf(resultado));
                    } else {
                        double resultado = calcularLongitud(Double.parseDouble(tn_entrada1.getText().toString()), sp_unidad1.getSelectedItem().toString(), sp_unidad2.getSelectedItem().toString());
                        tn_entrada2.setText(String.valueOf(resultado));
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sp_unidad2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(tn_entrada1.getText().length()!= 0 || tn_entrada1.getText().length()!=0){
                    if (unidades_al.get(0).equals("Fahrenheit")) {
                        double resultado = calcularTemperatura(Double.parseDouble(tn_entrada1.getText().toString()), sp_unidad1.getSelectedItem().toString(), sp_unidad2.getSelectedItem().toString());
                        tn_entrada2.setText(String.valueOf(resultado));
                    } else if (unidades_al.get(0).equals("Kilogramo")) {
                        double resultado = calcularMasa(Double.parseDouble(tn_entrada1.getText().toString()), sp_unidad1.getSelectedItem().toString(), sp_unidad2.getSelectedItem().toString());
                        tn_entrada2.setText(String.valueOf(resultado));
                    } else if (unidades_al.get(0).equals("Litro")) {
                        double resultado = calcularVolumen(Double.parseDouble(tn_entrada1.getText().toString()), sp_unidad1.getSelectedItem().toString(), sp_unidad2.getSelectedItem().toString());
                        tn_entrada2.setText(String.valueOf(resultado));
                    } else {
                        double resultado = calcularLongitud(Double.parseDouble(tn_entrada1.getText().toString()), sp_unidad1.getSelectedItem().toString(), sp_unidad2.getSelectedItem().toString());
                        tn_entrada2.setText(String.valueOf(resultado));
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public double calcularTemperatura(double input, String entrada, String salida){
        double resultado;
        if(!entrada.equals(salida)){
            if(entrada.equals("Fahrenheit")){
                if(salida.equals("Celsius")){
                    resultado = ((input-32)*5)/9;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                }else{
                    resultado = (((input-32)*5)/9)+273.15;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                }
            } else if (entrada.equals("Celsius")) {
                if(salida.equals("Fahrenheit")){
                    resultado = ((input*9)/5)+32;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                }else {
                    resultado = input+273.15;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                }
            }else{
                if(salida.equals("Celsius")){
                    resultado = input-273.15;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                }else {
                    resultado = (((input-273.15)*9)/5)+32;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                }
            }
        }
        return input;
    }

    public double calcularMasa(double input, String entrada, String salida){
        double resultado;
        if(sp_unidad1.getSelectedItem()!=sp_unidad2.getSelectedItem()){
            if(entrada.equals("Kilogramo")){
                if(salida.equals("Gramo")){
                    resultado = input*1000;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                } else if (salida.equals("Libra")) {
                    resultado = input*2.205;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return resultado;
                }else {
                    resultado = input*35.274;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return resultado;
                }
            } else if (entrada.equals("Gramo")) {
                if (salida.equals("Kilogramo")){
                    resultado = input/1000;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                } else if (salida.equals("Libra")) {
                    resultado = input/453.6;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                } else {
                    resultado = input/28.35;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                }
            } else if (entrada.equals("Libra")) {
                if (salida.equals("Kilogramo")){
                    resultado = input/2.205;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                } else if (salida.equals("Gramo")) {
                    resultado = input*453.6;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                }else {
                    resultado = input*16;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                }
            }else{
                if (salida.equals("Kilogramo")){
                    resultado = input/35.274;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                } else if (salida.equals("Gramo")) {
                    resultado = input*28.35;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                }else {
                    resultado = input/16;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                }
            }
        }
        return input;
    }

    public double calcularVolumen(double input, String entrada, String salida){
        double resultado;
        if(sp_unidad1.getSelectedItem()!=sp_unidad2.getSelectedItem()){
            if (entrada.equals("Litro")){
                if(salida.equals("Mililitro")){
                    resultado = input*1000;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                } else if (salida.equals("Galon")) {
                    resultado = input/3.785;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                } else {
                    resultado = input*33.814;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                }
            } else if (entrada.equals("Mililitro")) {
                if(salida.equals("Litro")){
                    resultado = input/1000;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                } else if (salida.equals("Galon")) {
                    resultado = input/3785;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                } else {
                    resultado = input*29.574;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                }
            } else if (entrada.equals("Galon")) {
                if(salida.equals("Litro")){
                    resultado = input*3.785;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                } else if (salida.equals("Mililitro")) {
                    resultado = input*3785;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                } else {
                    resultado = input*128;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                }
            }else{
                if(salida.equals("Litro")){
                    resultado = input/33.814;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                } else if (salida.equals("Mililitro")) {
                    resultado = input*29.574;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                } else {
                    resultado = input/128;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                }
            }
        }
        return input;
    }

    public double calcularLongitud(double input, String entrada, String salida){
        double resultado;
        if(sp_unidad1.getSelectedItem()!=sp_unidad2.getSelectedItem()){
            if(entrada.equals("Metro")){
                if(salida.equals("Centimetro")){
                    resultado = input*100;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                } else if (salida.equals("Kilometro")) {
                    resultado = input/1000;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                } else if (salida.equals("Pulgada")) {
                    resultado = input*39.37;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                } else if (salida.equals("Pie")) {
                    resultado = input*3.281;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                }else {
                    resultado = input/1609;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                }
            } else if (entrada.equals("Centimetro")) {
                if(salida.equals("Metro")){
                    resultado = input/100;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                } else if (salida.equals("Kilometro")) {
                    resultado = input/100000;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                } else if (salida.equals("Pulgada")) {
                    resultado = input*2.54;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                } else if (salida.equals("Pie")) {
                    resultado = input*30.48;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                }else {
                    resultado = input/160900;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                }
            } else if (entrada.equals("Kilometro")) {
                if(salida.equals("Metro")){
                    resultado = input*1000;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                } else if (salida.equals("Centimetro")) {
                    resultado = input*100000;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                } else if (salida.equals("Pulgada")) {
                    resultado = input*39370;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                } else if (salida.equals("Pie")) {
                    resultado = input*3281;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                }else {
                    resultado = input/1.609;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                }
            } else if (entrada.equals("Pulgada")) {
                if(salida.equals("Metro")){
                    resultado = input/39.37;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                } else if (salida.equals("Centimetro")) {
                    resultado = input*2.54;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                } else if (salida.equals("Kilometro")) {
                    resultado = input/39370;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                } else if (salida.equals("Pie")) {
                    resultado = input/12;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                }else {
                    resultado = input/63360;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                }
            } else if (entrada.equals("Pie")) {
                if(salida.equals("Metro")){
                    resultado = input/3.281;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                } else if (salida.equals("Centimetro")) {
                    resultado = input*30.48;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                } else if (salida.equals("Kilometro")) {
                    resultado = input/3281;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                } else if (salida.equals("Pulgada")) {
                    resultado = input*12;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                }else {
                    resultado = input/5280;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                }
            }else {
                if(salida.equals("Metro")){
                    resultado = input*1609;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                } else if (salida.equals("Centimetro")) {
                    resultado = input*160900;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                } else if (salida.equals("Kilometro")) {
                    resultado = input*1.609;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                } else if (salida.equals("Pie")) {
                    resultado = input*5280;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                }else {
                    resultado = input*63360;
                    resultado = Math.round(resultado * 100.0)/100.0;
                    return  resultado;
                }
            }
        }
        return input;
    }
}