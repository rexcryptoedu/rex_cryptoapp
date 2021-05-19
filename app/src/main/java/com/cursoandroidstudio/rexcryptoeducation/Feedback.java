package com.cursoandroidstudio.rexcryptoeducation;

public class Feedback {

    public static boolean question1Feedback(
            String coursePart, String answerQuestion1) {

        boolean question1 = false;

        switch (coursePart) {
            case "Parte I":
                if ( answerQuestion1 == "Satoshi Nakamoto e Hal Finney" ) {
                    question1 = true;
                } else {
                    question1 = false;
                }
                break;
            case "Parte II":
                if ( answerQuestion1 == "O processo era centralizado, era necessário confiar em " +
                        "uma terceira parte para intermediar e verificar a transação" ) {
                    question1 = true;
                } else {
                    question1 = false;
                }
                break;
            case "Parte III":
                if ( answerQuestion1 == "São carteiras usadas para armazenar e transacionar criptoativos. " +
                        "A utilização de uma chave pública do destinatário e sua chave privada " +
                        "é o que torna possível uma transação de Bitcoin dentro do Blockchain") {
                    question1 = true;
                } else {
                    question1 = false;
                }
                break;
        }

        return question1;

    }

    public static boolean question2Feedback(
            String coursePart, String[] answerQuestion2) {

        boolean question2 = false;

        switch (coursePart) {
            case "Parte I":
                if ( answerQuestion2[0] == "gasto duplo" && answerQuestion2[1] == "" ) {
                    question2 = true;
                } else {
                    question2 = false;
                }
                break;
            case "Parte II":
                if ( answerQuestion2[0] == "Blockchain" && answerQuestion2[1] == "Bitcoin" ) {
                    question2 = true;
                } else {
                    question2 = false;
                }
                break;
            case "Parte III":
                if ( answerQuestion2[0] == "") {
                    question2 = true;
                } else {
                    question2 = false;
                }
                break;
        }

        return question2;

    }

}
