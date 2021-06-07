package com.senai.projeto_eventos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.senai.projeto_eventos.database.LocalDAO;
import com.senai.projeto_eventos.modelo.Local;

public class CadastrarLocalActivity extends AppCompatActivity {

    private int id = 0;
    private EditText editTextDescricao;
    private EditText editTextBairro;
    private EditText editTextCidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_local);
        setTitle("Cadastro de Locais");
        editTextDescricao = findViewById(R.id.editText_descricao);
        editTextBairro = findViewById(R.id.editText_bairro);
        editTextCidade = findViewById(R.id.editText_cidade);
        carregarLocal();


        Button btn_salvar = findViewById(R.id.btn_salvar2);
        btn_salvar.setOnClickListener(new View.OnClickListener() {

            public String validar() {
                String campoVazio = "";

                if (editTextDescricao.getText().toString().equals("")) {
                    campoVazio = "Campo Decrição é obrigatório. ";
                    editTextDescricao.setError("Este campo é obrigatório");
                }
                if (editTextBairro.getText().toString().equals("")) {
                    campoVazio = "Campo Bairro é obrigatório. ";
                    editTextBairro.setError("Este campo é obrigatório");
                }
                if (editTextCidade.getText().toString().equals("")) {
                    campoVazio = "Campo Cidade é obrigatório. ";
                    editTextCidade.setError("Este campo é obrigatório");
                }

                return campoVazio;
            }

            @Override
            public void onClick(View v) {

                String descricao = editTextDescricao.getText().toString();
                String bairro = editTextBairro.getText().toString();
                String cidade = editTextCidade.getText().toString();

                Local local = new Local(id, descricao, bairro, cidade);

                String campoVazio = validar();
                if (campoVazio.equals("")) {
                    LocalDAO localDAO = new LocalDAO(getBaseContext());
                    localDAO.salvar(local);
                    Toast.makeText(CadastrarLocalActivity.this, "Local cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(CadastrarLocalActivity.this, "Erro ao salvar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void carregarLocal() {
        Intent intent = getIntent();
        if (intent != null && intent.getExtras() != null && intent.getExtras().get("localEdicao") != null) {
            Local local = (Local) intent.getExtras().get("localEdicao");
            editTextDescricao.setText(local.getDescricao());
            editTextBairro.setText(local.getBairro());
            editTextCidade.setText(local.getCidade());
            id = local.getId();
        }
    }

    public void onClickVoltar(View v) {
        finish();
    }


    public void onClickExcluir(View v) {

        String descricao = editTextDescricao.getText().toString();
        String bairro = editTextBairro.getText().toString();
        String cidade = editTextCidade.getText().toString();

        Local local = new Local(id, descricao, bairro, cidade);
        LocalDAO localDAO = new LocalDAO(getBaseContext());
        boolean excluiu = localDAO.excluir(local);
        if (excluiu) {
            finish();
            Toast.makeText(CadastrarLocalActivity.this, "Local excluído com sucesso!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(CadastrarLocalActivity.this, "Erro ao excluir", Toast.LENGTH_SHORT).show();
        }
    }
}
