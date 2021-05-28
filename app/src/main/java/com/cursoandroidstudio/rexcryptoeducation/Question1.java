package com.cursoandroidstudio.rexcryptoeducation;

public class Question1 {

    public static String question1Content(String coursePart) {

        String question1 = null;

        switch (coursePart) {
            case "Parte I":
                question1 = "Em janeiro de 2009, a primeira transação de Bitcoin foi realizada, entre:";
                break;
            case "Parte II":
                question1 = "O Bitcoin foi a primeira moeda virtual a ser criada com sucesso. Porém, diversas outras tentativas de criação de criptomoedas foram feitas, mas esbarravam em um problema. Que problema era esse?";
                break;
            case "Parte III":
                question1 = "O que são e para que servem as carteiras (wallets) de Bitcoin?";
                break;
            case "Parte IV":
                question1 = "Explique o que é criptografia, aplicada em tecnologias que se baseiam em Blockchain";
                break;
            case "Parte V":
                question1 = "Marque a alternativa correta quanto a transações de Bitcoins:";
                break;
        }

        return question1;

    }

    public static String[] question1Alternatives(String coursePart) {

        String[] alternatives = new String[0];

        switch (coursePart) {
            case "Parte I":
                alternatives = new String []{
                        "Bill Gates e Elon Musk",
                        "Jeff Bezos e Satoshi Nakamoto",
                        "Satoshi Nakamoto e Hal Finney",
                        "Satoshi Nakamoto e Mike Finney"
                };
                break;
            case "Parte II":
                alternatives = new String []{
                        "As criptomoedas foram desenvolvidas de maneira incompleta, fazendo com que fosse necessário intermediários no processo",
                        "As criptomoedas antes criadas eram funcionais, mas não eram transacionadas",
                        "O processo era centralizado, era necessário confiar em uma terceira parte para intermediar e verificar a transação",
                        "O Blockchain dessas criptomoedas não era seguro, sendo possível fraudar uma negociação"
                };
                break;
            case "Parte III":
                alternatives = new String []{
                        "São locais onde são armazenados apenas o Bitcoin, sendo possível apenas guardá-los e retirá-los, sem transacionar",
                        "São usadas apenas para transacionar seus criptoativos, por meio de uma chave pública, e sendo impossível armazenar valores",
                        "São carteiras usadas para armazenar criptoativos, com a mesma função de uma conta bancária. Porém são recursos extremamente caros, sendo impossível ter uma wallet gratuita",
                        "São carteiras usadas para armazenar e transacionar criptoativos. A utilização de uma chave pública do destinatário e sua chave privada é o que torna possível uma transação de Bitcoin dentro do Blockchain"
                };
                break;
            /*
            case "Parte IV":
                alternatives = new String []{
                "";
                };
                break;
            */
            case "Parte V":
                alternatives = new String []{
                        "Transações de Bitcoin são exatamente iguais a uma transação bancária, sendo necessário inserir as informações corretas e aguardar a autorização e verificação de uma terceira parte, como uma empresa",
                        "As transações de Bitcoin são verificadas pelo processo da mineração, sendo assim um processo seguro e descentralizado. Porém, as etapas são demoradas para serem concluídas, levando cerca de semanas para terminarem.",
                        "As transações de Bitcoin são descentralizadas, sendo feitas pelo processo da mineração e do Blockchain, porém são processos que uma vez concluídos, podem ser alterados.",
                        "Transações de Bitcoin são verificadas e efetivadas pelo processo da mineração, sendo que essas transações ficam armazenadas em blocos, dentros do Blockchain, e uma vez verificadas, são inalteráveis"
                };
                break;
        }

        return alternatives;

    }

}
