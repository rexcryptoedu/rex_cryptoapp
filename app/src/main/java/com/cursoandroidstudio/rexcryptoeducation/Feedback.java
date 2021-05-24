package com.cursoandroidstudio.rexcryptoeducation;

import android.util.Log;

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
            String coursePart, String answerQuestion2) {

        String[] arrayQuestion2 = answerQuestion2.trim().split(", ");
        int arraySize = arrayQuestion2.length;
        System.out.println(arrayQuestion2[0]);
        System.out.println(arraySize);
        boolean question2 = false;

        switch (coursePart) {
            case "Parte I":
                if ( arrayQuestion2[0].equals("gasto duplo") ) {
                    question2 = true;
                } else {
                    question2 = false;
                }
                break;
            case "Parte II":
                if ( arraySize > 1 ) {
                    if (arrayQuestion2[0].equals("Blockchain") && arrayQuestion2[1].equals("Bitcoin")) {
                        question2 = true;
                    } else {
                        question2 = false;
                    }
                } else {
                    question2 = false;
                }
                break;
            case "Parte III":
                if ( arraySize > 1 ) {
                    if (arrayQuestion2[0].equals("privada") && arrayQuestion2[1].equals("pública")) {
                        question2 = true;
                    } else {
                        question2 = false;
                    }
                    break;
                }
        }

        return question2;

    }

    public static boolean question3Feedback(
            String coursePart, String answerQuestion3) {

        boolean question3 = false;

        return question3;

    }

}
