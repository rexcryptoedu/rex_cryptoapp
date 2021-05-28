package com.cursoandroidstudio.rexcryptoeducation;

public class Question3 {

    public static String question3Content(String coursePart) {

        String question3 = null;

        switch (coursePart) {
            case "Parte I":
                question3 = "Por que o Bitcoin é considerado a primeira criptomoeda realmente funcional da história?";
                break;
            case "Parte II":
                question3 = "Por que Blockchain recebe esse nome? Traduzindo ao português como cadeia de blocos, e é comparado a um livro?";
                break;
            case "Parte III":
                question3 = "Explique o que é/como funciona uma Hard Wallet";
                break;
            case "Parte IV":
                question3 = "“Quando um usuário realizasse alguma tarefa, receberia alguma prova para que ele consiga ter acesso e utilização de algum serviço ou benefício. Essa ideia foi mais tarde utilizada por Satoshi Nakamoto, para a criação da primeira criptomoeda descentralizada: o Bitcoin”.";
                break;
            case "Parte V":
                question3 = "Explique o que é e como funciona o Halving de Bitcoin.\n";
                break;
        }

        return question3;

    }

}
