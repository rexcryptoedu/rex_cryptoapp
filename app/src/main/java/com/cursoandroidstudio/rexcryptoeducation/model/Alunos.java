package com.cursoandroidstudio.rexcryptoeducation.model;

public class Alunos {
    private long id;
    private String nomeAluno;
    private String emailAluno;
    private String cidadeAluno;
    private long dataIngressao;
    private long dataConclusao;
    private String senha;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getEmailAluno() {
        return emailAluno;
    }

    public void setEmailAluno(String emailAluno) {
        this.emailAluno = emailAluno;
    }

    public String getCidadeAluno() {
        return cidadeAluno;
    }

    public void setCidadeAluno(String cidadeAluno) {
        this.cidadeAluno = cidadeAluno;
    }

    public long getDataIngressao() {
        return dataIngressao;
    }

    public void setDataIngressao(long dataIngressao) {
        this.dataIngressao = dataIngressao;
    }

    public long getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(long dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
