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

        }

        return question3;

    }

}
