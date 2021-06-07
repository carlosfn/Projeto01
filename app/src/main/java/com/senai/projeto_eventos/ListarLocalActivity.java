package com.senai.projeto_eventos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.senai.projeto_eventos.database.LocalDAO;
import com.senai.projeto_eventos.modelo.Local;

public class ListarLocalActivity extends AppCompatActivity {

    private final int id = 0;
    private ListView listaDeLocais;
    private ArrayAdapter<Local> adapterLocais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_locais);
        setTitle("Cadastro de Locais");

        listaDeLocais = findViewById(R.id.ListView_locais);
        definirOnClickListenerListView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalDAO localDAO = new LocalDAO(getBaseContext());
        adapterLocais = new ArrayAdapter<>(ListarLocalActivity.this,
                android.R.layout.simple_list_item_1,
                localDAO.listar());
        listaDeLocais.setAdapter(adapterLocais);

    }

    private void definirOnClickListenerListView() {
        listaDeLocais.setOnItemClickListener((parent, view, position, id) -> {
            Local localClicado = adapterLocais.getItem(position);
            Intent intent = new Intent(ListarLocalActivity.this, CadastrarLocalActivity.class);
            intent.putExtra("localEdicao", localClicado);
            startActivity(intent);
        });
    }

    public void onClickCadastrarLocal(View v) {
        Intent intent = new Intent(ListarLocalActivity.this, CadastrarLocalActivity.class);
        startActivity(intent);
    }

    public void onClickEventos(View v) {
        Intent intent = new Intent(ListarLocalActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
