package com.example.angulos;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;


import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.tan;

public class Main_Class extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        final int[] funcion = new int[1];
        final int[] grados = new int[1];

        final ImageView iv = findViewById(R.id.image1);
        final TextView Resultado = findViewById(R.id.Resultado);

        RadioGroup RG_Grados = findViewById(R.id.RadGp_Grados);
        final RadioButton R_45 = findViewById(R.id.Radio_45);
        final RadioButton R_90 = findViewById(R.id.Radio_90);
        final RadioButton R_180 = findViewById(R.id.Radio_180);

        RadioGroup RG_Fun = findViewById(R.id.RadGp_Fun);
        final RadioButton R_Sin = findViewById(R.id.Radio_sin);
        final RadioButton R_Cos = findViewById(R.id.Radio_cos);
        final RadioButton R_Tan = findViewById(R.id.Radio_tan);



        //Detectamos cambio en los Radiobutton de Funcion
        RG_Fun.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if      (R_Sin.getId()== checkedId) funcion[0] = 1;

                else if (R_Cos.getId() == checkedId) funcion[0] = 2;

                else if (checkedId == R_Tan.getId()) funcion[0] = 3;

                if(grados[0] != 0 && funcion[0]!=0) {
                    Resultado.setText("Resultado: " + String.format("%.4f",calcular_angulo(funcion[0], grados[0])));
                }
            }

        });

        //Detectamos cambio en los Radiobutton de Grados
        RG_Grados.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(R_45.getId()== checkedId){
                    iv.setImageResource(R.drawable.drawable_45g);
                    grados[0] = 45;

                }else{ if(R_90.getId() == checkedId){
                    iv.setImageResource(R.drawable.drawable_90g);
                    grados[0] = 90;

                }else{ if(R_180.getId() == checkedId){
                    iv.setImageResource(R.drawable.drawable_180g);
                    grados[0] = 180;
                }}}

                if(grados[0] != 0 && funcion[0]!=0) {
                    Resultado.setText("Resultado: " + String.format("%.4f",calcular_angulo(funcion[0], grados[0])));
                }
            }
        });
    }

    double calcular_angulo(int func, int grados){

        switch (func){
            case 0:
                return 0;

            case 1:
                return sin(grados*(PI/180));

            case 2:
                return cos(grados*(PI/180));

            case 3:
                return tan(grados*(PI/180));
        }

        return  0;
    }
}
