package com.cursoandroidstudio.rexcryptoeducation;

public class Question2 {

    public static String question2Content(String coursePart) {

        String question2 = null;

        switch (coursePart) {
            case "Parte I":
                question2 = "O Bitcoin não foi a primeira criptomoeda da história, foi a junção de várias tecnologias já existentes. Ele foi extremamente revolucionário por ter resolvido o problema do ____________, de ter \"cópias\" de moeda ao ser transferida.\n";
                break;
            case "Parte II":
                question2 = "O __________(1) descentralizou o processo das transações, eliminando a necessidade de um intermediário no negócio. O Blockchain é uma tecnologia, mas não uma única tecnologia, e tem por exemplo o _________(2) como aplicação financeira.\n";
                break;

        }

        return question2;

    }

}
