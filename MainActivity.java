package com.example.tp1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Vector;

import javax.xml.parsers.SAXParser;

public class MainActivity extends AppCompatActivity {

    TextView affichage;
    String operation, nombre, chif_mem_S;
    boolean op1=true, op2=false, nett_ecran=true;
    double nombre1, nombre2, mem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        affichage=(TextView) findViewById(R.id.affichage);
        if (savedInstanceState!=null) {
            nombre1 = (double) savedInstanceState.getDouble("nombre11");
            nombre2 = (double) savedInstanceState.getDouble("nombre21");
            mem = (double) savedInstanceState.getDouble("mem1");
            op1 = (boolean) savedInstanceState.getBoolean("op11");
            op2 = (boolean) savedInstanceState.getBoolean("op21");
            nett_ecran = (boolean) savedInstanceState.getBoolean("clr_screen1");
            operation=(String) savedInstanceState.getString("operation1");
            nombre=(String) savedInstanceState.getString("nombre1");
            chif_mem_S=(String) savedInstanceState.getString("chif_mem1");
        }
        else {
            nombre1 = 0;
            nombre2 = 0;
            mem = 0;
            op2=false;
            op1=true;
            nett_ecran=true;
            operation="";
            nombre="";
            chif_mem_S="";
        }
        affichage.setText(nombre);
    }
    public void chiffre(View view){
        if (nett_ecran){
            nombre = "";
            nett_ecran=false;
        }
        switch (view.getId()){
            case R.id.un: nombre +="1"; break;
            case R.id.deux: nombre +="2"; break;
            case R.id.trois: nombre +="3"; break;
            case R.id.quatre: nombre +="4"; break;
            case R.id.cinq: nombre +="5"; break;
            case R.id.six: nombre +="6"; break;
            case R.id.sept: nombre +="7"; break;
            case R.id.huit: nombre +="8"; break;
            case R.id.neuf: nombre +="9"; break;
            case R.id.zero: nombre +="0"; break;
            case R.id.point: nombre +="."; break;
            case R.id.insert_memoire: nombre += chif_mem_S; break;

        }
        affichage.setText(nombre);
        if (op1){
            nombre1=Double.parseDouble(nombre);
        }
        if (op2){
            nombre2=Double.parseDouble(nombre);
        }
    }
    public void CE (View view){
        affichage.setText("0");
        op1=true; op2=false; nett_ecran=true;
    }
    public void signe(View view) {
        switch (view.getId()){
            case R.id.bt_plus : operation="+"; break;
            case R.id.bt_moins : operation="-"; break;
            case R.id.bt_mult : operation="*"; break;
            case R.id.bt_div : operation="/"; break;
            default : return;
        }
        op1=false;
        op2=true;
        nett_ecran=true;
    }

    public void résulat(View view) {
        double rslt;
        switch (operation){
            case "+" : rslt = nombre1 + nombre2 ; break;
            case "-" : rslt = nombre1 - nombre2 ; break;
            case "*" : rslt = nombre1 * nombre2 ; break;
            case "/" : rslt = nombre1 / nombre2 ; break;
            default:return;
        }
        String resultat=Double.toString(rslt);
        affichage.setText(resultat);
        op1=true; op2=false; nett_ecran=true;
    }

    public void memoire(View view) {
        switch(view.getId()){
            case R.id.memoriser: mem=Double.parseDouble(affichage.getText().toString()); break;
            case R.id.sup_mem: mem=0; break;
            default:return;
        }
        chif_mem_S=Double.toString(mem);
    }
    protected void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        saveInstanceState.putDouble("nombre11", nombre1);
        saveInstanceState.putDouble("nombre21", nombre2);
        saveInstanceState.putDouble("mem1", mem);
        saveInstanceState.putBoolean("op11",op1);
        saveInstanceState.putBoolean("op21",op2);
        saveInstanceState.putBoolean("olr_screen1",nett_ecran);
        saveInstanceState.putString("operation1",operation);
        saveInstanceState.putString("nombre1",nombre);
        saveInstanceState.putString("chif_mem1",chif_mem_S);
    }
}
