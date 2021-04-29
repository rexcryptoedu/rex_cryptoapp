package com.cursoandroidstudio.rexcryptoeducation.DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.cursoandroidstudio.rexcryptoeducation.model.AdmRex;
import com.cursoandroidstudio.rexcryptoeducation.model.Alunos;
import com.cursoandroidstudio.rexcryptoeducation.model.EmissaoCertificado;

import java.util.ArrayList;

public class BDRex extends SQLiteOpenHelper {

    private static final String DATABASE = "rexinvestimentos";
    private static final int VERSION = 1;

    public BDRex(Context context){
        super(context, DATABASE, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String rex = "CREATE TABLE alunos (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nome TEXT NOT NULL," +
                "email TEXT NOT NULL, cidade TEXT NOT NULL, dataingressao DATE NOT NULL, dataconclusao DATE NOT NULL," +
                "senha TEXT NOT NULL);";
        db.execSQL(rex);

        rex = "CREATE TABLE admrex (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nome TEXT NOT NULL," +
                "EMAIL TEXT NOT NULL, SENHA TEXT NOT NULL)";
        db.execSQL(rex);

        rex = "CREATE TABLE loginrex (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, email TEXT NOT NULL," +
                "senha TEXT NOT NULL);";
        db.execSQL(rex);

        rex = "CREATE TABLE emissaocertificado (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nomecompleto TEXT NOT NULL," +
                "rendimento INTEGER, cpf TEXT NOT NULL, telefone TEXT NOT NULL);";
        db.execSQL(rex);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String rex = "DROP TABLE IF EXISTS alunos";
        db.execSQL(rex);

        rex = "DROP TABLE IF EXISTS admrex";
        db.execSQL(rex);

        rex = "DROP TABLE IF EXISTS loginrex";
        db.execSQL(rex);

        rex = "DROP TABLE IF EXISTS emissaocertificado";
        db.execSQL(rex);
    }
    public void salvarAluno(Alunos alunos){
        ContentValues values = new ContentValues();

        values.put("nomeAluno", alunos.getNomeAluno());
        values.put("emailAluno", alunos.getEmailAluno());
        values.put("cidadeAluno", alunos.getCidadeAluno());
        values.put("dataIngressao", alunos.getDataIngressao());
        values.put("dataConclusao", alunos.getDataConclusao());
        values.put("senha", alunos.getSenha());

        getWritableDatabase().insert("alunos", null, values);
    }
    public void salvarAdmRex(AdmRex admRex){
        ContentValues values = new ContentValues();

        values.put("nome", admRex.getNome());
        values.put("email", admRex.getEmail());
        values.put("senha", admRex.getSenha());

        getWritableDatabase().insert("admrex", null, values);
    }
    public void salvaEmissaoCertificado(EmissaoCertificado emissaoCertificado){
        ContentValues values = new ContentValues();

        values.put("nomeCompleto", emissaoCertificado.getNomeCompleto());
        values.put("rendimento", emissaoCertificado.getRendimento());
        values.put("cpf", emissaoCertificado.getRendimento());
        values.put("telefone", emissaoCertificado.getTelefone());

        getWritableDatabase().insert("emissaocertificado", null, values);
    }
    public ArrayList<Alunos> getLista(){
        String columns = ("id, nome, email, cidade, dataingressao, dataconclusao, senha");
        Cursor cursor = getWritableDatabase().query(Boolean.parseBoolean("alunos"), columns, null, null, null,
                null, null, null, null);
        ArrayList<Alunos> alunos = new ArrayList<Alunos>();

        while (cursor.moveToNext()){
            Alunos aluno = new Alunos();
            aluno.setId(cursor.getLong(0));
            aluno.setNomeAluno(cursor.getString(1));
            aluno.setEmailAluno(cursor.getString(2));
            aluno.setCidadeAluno(cursor.getString(3));
            aluno.setDataIngressao(cursor.getLong(4));
            aluno.setDataConclusao(cursor.getLong(5));
            aluno.setSenha(cursor.getString(6));

            alunos.add(aluno);
        }
        return alunos;
    }
}