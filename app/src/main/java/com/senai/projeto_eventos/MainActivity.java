package com.senai.projeto_eventos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.senai.projeto_eventos.database.EventoDAO;
import com.senai.projeto_eventos.modelo.Evento;

public class MainActivity extends AppCompatActivity {

    private final int id = 0;
    private ListView listaDeEventos;
    private ArrayAdapter<Evento> adapterEventos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Cadastro de Eventos");

        listaDeEventos = findViewById(R.id.ListView_eventos);
        definirOnClickListenerListView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventoDAO eventoDAO = new EventoDAO(getBaseContext());
        adapterEventos = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                eventoDAO.listar());
        listaDeEventos.setAdapter(adapterEventos);

    }


    private void definirOnClickListenerListView() {
        listaDeEventos.setOnItemClickListener((parent, view, position, id) -> {
            Evento eventoClicado = adapterEventos.getItem(position);
            Intent intent = new Intent(MainActivity.this, CadastrarEventoActivity.class);
            intent.putExtra("eventoEdicao", eventoClicado);
            startActivity(intent);
        });
    }

    public void onClickAgendarEvento(View v) {
        Intent intent = new Intent(MainActivity.this, CadastrarEventoActivity.class);
        startActivity(intent);
    }

    public void onClickLocais(View v) {
        Intent intent = new Intent(MainActivity.this, ListarLocalActivity.class);
        startActivity(intent);
        finish();
    }

}
