package com.example.appmobhealth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appmobhealth.databinding.ActivityListaExerciciosBinding;

import java.util.ArrayList;

public class ListaExerciciosActivity extends AppCompatActivity {

    ActivityListaExerciciosBinding binding;
    ListaAdapter listAdapter;
    ArrayList<ListaData> dataArrayList = new ArrayList<>();
    ListaData listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListaExerciciosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageList = {R.drawable.crucifixo, R.drawable.extensora, R.drawable.supinoreto, R.drawable.remadacurvada, R.drawable.roscadiretapolia, R.drawable.supinodeclinadohalteres, R.drawable.elevacaolateral};
        int[] descricaoList = {R.string.crucifixoDescricao, R.string.extensoraDescricao,R.string.supinoretoDescricao,R.string.remadacurvadaDescricao,R.string.roscadiretaDescricao, R.string.supinodeclinadoDescricao, R.string.elevacaolateralDescricao};
        int[] etapasList = {R.string.crucifixoEtapas, R.string.extensoraEtapas, R.string.supinoretoEtapas,R.string.remadacurvadaEtapas,R.string.roscadiretaEtapas, R.string.supinoretoEtapas, R.string.elevacaolateralEtapas};
        String[] nameList = {"Crucifixo", "Extensora", "Supino Reto", "Remada Curvada", "Rosca direta na polia","Supino declinado com halteres", "Elevação lateral"};


        for (int i = 0; i < imageList.length; i++){
            listData = new ListaData(nameList[i], descricaoList[i], etapasList[i], imageList[i]);
            dataArrayList.add(listData);
        }
        listAdapter = new ListaAdapter(ListaExerciciosActivity.this, dataArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);

        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListaExerciciosActivity.this, DetalhesActivity.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("descricao", descricaoList[i]);
                intent.putExtra("etapas", etapasList[i]);
                intent.putExtra("image", imageList[i]);
                startActivity(intent);
            }
        });
    }
}