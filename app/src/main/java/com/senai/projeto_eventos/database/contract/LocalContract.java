package com.senai.projeto_eventos.database.contract;

import com.senai.projeto_eventos.database.entity.LocalEntity;

public final class LocalContract {

    private LocalContract() {
    }

    public static final String criarTabela() {
        return "CREATE TABLE " + LocalEntity.TABLE_NAME + " (" +
                LocalEntity._ID + " INTEGER PRIMARY KEY," +
                LocalEntity.COLUMN_NAME_DESCRICAO + " TEXT," +
                LocalEntity.COLUMN_NAME_BAIRRO + " TEXT," +
                LocalEntity.COLUMN_NAME_CIDADE + " TEXT)";
    }

    public static final String removerTabela() {
        return "DROP TABLE IF EXISTS " + LocalEntity.TABLE_NAME;
    }
}
