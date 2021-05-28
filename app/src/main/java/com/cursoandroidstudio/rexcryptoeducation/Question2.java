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
            case "Parte III":
                question2 = "A chave _______(1) é usada para a configuração da sua carteira, dando acesso ao dono à propriedade e gerenciamento dos valores. São formadas por um conjunto de 12 palavras aleatórias. Essa chave garante o backup e o controle/acesso dos Bitcoin dentro do Blockchain. Já a chave ________(2) funciona como se fosse o número de conta corrente, seu endereço de conta bancária, que você compartilha com outras pessoas para que elas possam fazer transações com você.\n";
                break;
            case "Parte IV":
                question2 = "A criptografia é um pilar fundamental em tecnologias que se baseiam em Blockchain. Para garantir que nenhuma pessoa externa possa acessar os dados, há duas chaves de criptografia: a de chave ________ (1), que gera uma criptografia de hash (função criptografa), que facilita a distribuição de informações, e a de chave ________(2)(secreta), que criptografa e descriptografa informações entre o remetente e destinatário.\n";
                break;
            case "Parte V":
                question2 = "Em maio de 2020 aconteceu o 3º_________, onde, pela terceira vez, a recompensa dos mineradores caiu pela metade. Dessa forma, o Bitcoin fica cada vez mais escasso, valorizando-o e fazendo com que seja necessário ter equipamentos cada vez mais potentes.\n";
                break;
        }

        return question2;

    }

}
