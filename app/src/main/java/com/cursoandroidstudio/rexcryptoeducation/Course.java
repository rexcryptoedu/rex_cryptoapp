package com.cursoandroidstudio.rexcryptoeducation;

public class Course {

    public static int courseAudio(String coursePart) {

        int audio = 0;

        switch (coursePart) {
            case "Parte I":
                audio = R.raw.teste;
                break;
            case "Parte II":
                audio = R.raw.bach;
                break;
            case "Parte III":
                audio = R.raw.teste;
                break;
        }

        return audio;

    }

    public static String courseText(String coursePart) {
        
        String text = "";
        
        switch (coursePart) {
            case "Parte I":
                text = "Até hoje, ninguém sabe ao certo quem é o criador do Bitcoin, nem como surgiram suas ideias. Há várias suposições de quem seja essa pessoa, mas nada definitivo, uma vez que sua idealização nasceu em uma publicação de um usuário em um fórum, em 2008. \n" +
                        "\n" +
                        "Em 31 de outubro de 2008, um usuário chamado Satoshi Nakamoto (pseudônimo) publicou em um fórum de criptografia um White Paper do Bitcoin, um documento, onde era explicado a ideia de um dinheiro eletrônico, que seria transacionado de pessoa a pessoa, sem um governo ou uma entidade central que controlasse esse dinheiro, que se intitulou como “Bitcoin, a peer-to-peer Eletronic Cash System” – Bitcoin, um sistema de dinheiro eletrônico de ponta a ponta.\n" +
                        "\n" +
                        "White paper do bitcoin: https://bitcoin.org/bitcoin.pdf \n" +
                        "\n" +
                        "Em janeiro de 2009, a primeira transação de Bitcoin foi realizada, entre Satoshi Nakamoto e Hal Finney. Nesse dia, Satoshi enviou 10 Bitcoins à Hal Finney. Hal Finney morreu em 2014, vítima de uma doença degenerativa, e existem teorias que apontam que Hal Finney tenha sido Satoshi Nakamoto.\n" +
                        "\n" +
                        "Em 2021, se completou 12 anos desde essa primeira transação. O sistema do bitcoin, o Blockchain, nunca saiu do ar, ou parou de funcionar. Um sistema descentralizado, que ajudou o sistema financeiro com transações mais rápidas, dando autonomia às pessoas para cuidarem de seu próprio dinheiro de forma autônoma, rápida e segura.\n" +
                        "\n" +
                        "O bitcoin não foi a primeira criptomoeda da história, e foi a junção de várias tecnologias já existentes. Ele foi extremamente revolucionário por ter resolvido o problema do gasto duplo, de ter \"cópias\" de moeda ao ser transferida, problema comum de outras criptomoedas anteriores, e eliminando a necessidade de ter alguém ou alguma entidade por trás controlando e gerenciando essa tecnologia, uma vez que se tornou extremamente autônoma e infraudavel. Por isso, o Bitcoin é considerado a primeira criptomoeda realmente funcional da história. \n";
                break;
            case "Parte II":
                text = "O surgimento do Blockchain está totalmente atrelado ao bitcoin, e o bitcoin à ele.\n" +
                        "\n" +
                        "Antes do Bitcoin, diversas outras tentativas de criação de criptomoedas foram feitas, e todas elas se esbarravam em um problema: o processo era centralizado. Era necessário confiar em uma terceira parte, uma empresa ou a pessoa que tinha desenvolvido aquela criptomoeda, para intermediar e verificar a transação.\n" +
                        "\n" +
                        "Outro grande entrave era o problema do Gasto Duplo. Imagine o envio de uma imagem, ou um arquivo qualquer. Ao uma pessoa enviar uma imagem para outra, através do e-mail, whatsapp etc, a imagem enviada continuará no dispositivo de quem a enviou, e também passará a estar no dispositivo do outro usuário, fazendo assim ter várias cópias desse mesmo arquivo. Com o blockchain, ao enviar esse mesmo arquivo, ele passa a desaparecer do dispositivo de envio, e é transferido para outro.\n" +
                        "\n" +
                        "O blockchain conseguiu descentralizar o processo e eliminar o problema do Gasto Duplo. O Blockchain propriamente dito, é uma tecnologia, mas não uma única tecnologia. Ele foi criado da junção de tecnologias diversas, e funciona como se fosse um livro, sendo cada página encadeada uma às outras. As transações de Bitcoin, por exemplo, são registradas nessas páginas (blocos), e esses blocos vão se ligando aos seus sequentes, formando uma cadeia de blocos (Blockchain).\n" +
                        "\n" +
                        "Em cada bloco com transações ou informações postas, é gerado um código a ele, e em caso de um desses blocos, uma vez verificado, fosse voltado atrás e alterado, o código nele também se modificaria, sendo assim, impossível alterar o conteúdo de um bloco sem que seu código fosse mudado, a chamada Criptografia de Hash.\n" +
                        "\n" +
                        "O Bitcoin é a aplicação financeira do Blockchain. Porém, este pode ser usado em diversos outros ramos, uma vez que com ele é possível fazer a verificação de documentos e autenticidade de quaisquer obras, podendo evidenciar alterações.\n";
                break;
            case "Parte III":
                text = "A Wallet(carteira) de Bitcoin segue o mesmo princípio de uma conta bancária: armazenar informações e o valor monetário. Quando criada uma carteira de Bitcoin, duas chaves serão geradas, a chave pública e a privada.\n" +
                        "\n" +
                        "A chave pública é como se fosse o número de conta corrente, seu endereço de conta bancária, que você compartilha com outras pessoas para que elas possam fazer transações com você. As chaves públicas são um conjunto de números, formando um código. Um exemplo é o PIX, onde a chave criada segue o mesmo princípio da chave pública do Bitcoin.\n" +
                        "\n" +
                        "Já a chave privada é usada para a configuração da sua carteira. Elas são responsáveis por autorizar digitalmente as transações de Bitcoin, e dão o direito ao dono à propriedade dos valores. São formadas por um conjunto de 12 palavras aleatórias. Mas por que palavras? A chave privada, assim como a pública, também é um conjunto de números, porém, ela é extremamente maior que a pública, tornando muito difícil de anotar, e impossível de decorar. As carteiras possuem um método onde essas palavras são transformadas em números, que formam a chave privada. Essa chave garante o backup e o controle/acesso dos Bitcoin dentro do Blockchain.\n" +
                        "\n" +
                        "E se perder a chave privada? Consegue recuperar os Bitcoins? Não. Em caso de perda, não será possível recuperar o saldo do seu Bitcoin. E se tiver a conta da carteira invadida, você perde? Também não, pois a outra pessoa também não terá as palavras para a chave privada, assim como você. Portanto, é necessário anotar de forma segura essas palavras em um ou mais lugares, e de preferência, de modo offline, como em um papel, e guardá-lo de forma segura.\n";
                break;
        }

        return text;

    }


}
