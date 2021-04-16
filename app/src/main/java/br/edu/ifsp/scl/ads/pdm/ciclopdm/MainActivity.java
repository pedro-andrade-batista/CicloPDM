package br.edu.ifsp.scl.ads.pdm.ciclopdm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import br.edu.ifsp.scl.ads.pdm.ciclopdm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    //Constante de filtro do LogCAt

    private final String CICLO_PDM_TAG = "CICLO_PDM_TAG";

    // Constante de dados de instacia
    private final String TELEFONE = "TELEFONE";
    private ActivityMainBinding activityMainBinding;

    //Views dinâmicas

    private TextView telefoneTv;
    private EditText telefoneEt;


    //SALVAR DADOS DE LAYOUT NESSE MÉTODO
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        //Views dinâmicas

        telefoneTv = new TextView(this);
        telefoneTv.setText("Telefone");
        telefoneEt = new EditText(this);
        telefoneEt.setInputType(InputType.TYPE_CLASS_PHONE);

        //Restaurando dados de instancias antigos, se necessario

//        if (savedInstanceState != null){
//            telefoneEt.setText(savedInstanceState.getString(TELEFONE,""));
//        }

        // Adicionando views dinamicas ao linear Layout

        activityMainBinding.linearLayout.addView(telefoneTv);
        activityMainBinding.linearLayout.addView(telefoneEt);

        Log.v(CICLO_PDM_TAG, "onCreate: Iniciando ciclo COMPLETO");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(CICLO_PDM_TAG, "OnStart: Iniciando ciclo VISIVEL");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(CICLO_PDM_TAG, "OnResume: iniciando ciclo em PRIMEIRO PLANO");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(CICLO_PDM_TAG, "OnPause: finalizando ciclo em PRIMEIRO PLANO");
    }

    // PARA SALVAR OS DADOS EM CLOUD OU EM ARQUIVOS, ESSE É O MÉTODO RECOMENDADO PARA ISSO
    @Override
    protected void onStop() {
        super.onStop();
        Log.v(CICLO_PDM_TAG, "OnStop: finalizando ciclo VISIVEL");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(CICLO_PDM_TAG, "OnDestroy: finalizando ciclo em COMPLETO");
    }

    //opcional
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(CICLO_PDM_TAG, "OnRestart: preparando pra chamar o OnStart");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        //salvando dados de instacia

        outState.putString(TELEFONE, telefoneEt.getText().toString());
    }

    //SALVAR DADOS QUE NÃO SÃO DE LAYOUTS
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        telefoneEt.setText(savedInstanceState.getString(TELEFONE,""));
    }
}