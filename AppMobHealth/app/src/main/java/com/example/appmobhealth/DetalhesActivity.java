package com.example.appmobhealth;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import com.example.appmobhealth.databinding.ActivityDetalhesBinding;

public class DetalhesActivity extends AppCompatActivity {

    ActivityDetalhesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetalhesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();
        if (intent != null){
            String name = intent.getStringExtra("name");
            int descricao = intent.getIntExtra("descricao", R.string.extensoraDescricao);
            int etapas = intent.getIntExtra("etapas", R.string.extensoraEtapas);
            int image = intent.getIntExtra("image", R.drawable.extensora);

            binding.detailName.setText(name);
            binding.detailEtapas.setText(etapas);
            binding.detailDescricao.setText(descricao);
            binding.detailImage.setImageResource(image);
        }
    }
}