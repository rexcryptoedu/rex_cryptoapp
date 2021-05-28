package com.cursoandroidstudio.rexcryptoeducation;

public class Course {

    public static int courseAudio(String coursePart) {

        int audio = 0;

        switch (coursePart) {
            case "Parte I":
                audio = R.raw.part1_audio;
                break;
            case "Parte II":
                audio = R.raw.part2_audio;
                break;
            case "Parte III":
                audio = R.raw.part3_audio;
                break;
            case "Parte IV":
                audio = R.raw.part4_audio;
                break;
            case "Parte V":
                audio = R.raw.part5_audio;
                break;
            case "Parte VI":
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
                        "E se perder a chave privada? Consegue recuperar os Bitcoins? Não. Em caso de perda, não será possível recuperar o saldo do seu Bitcoin. E se tiver a conta da carteira invadida, você perde? Também não, pois a outra pessoa também não terá as palavras para a chave privada, assim como você. Portanto, é necessário anotar de forma segura essas palavras em um ou mais lugares, e de preferência, de modo offline, como em um papel, e guardá-lo de forma segura.\n" +
                        "\n" +
                        "Os três principais tipos de carteira:\n" +
                        "\n" +
                        "Paper Wallet: Bitcoins são armazenados dentro de uma chave privada, dentro do Blockchain, e é impresso o código em um papel. Há as vantagens de ser totalmente Offline, e há desvantagem de ser papel, podendo perder, estragar com facilidade e cair em mãos erradas.  Além disso, sua configuração também não é tão simples para iniciantes, sendo assim, uma carteira pouco recomendável. \n" +
                        "\n" +
                        "Desktop & Mobile Wallet: são carteiras de dispositivos, como celulares e computadores. As mais recomendadas são as de código aberto, e em geral, são de alta segurança. O sistema é seguro, mas existe o risco de alguém roubar seu celular, ou alguém entrar em seu computador. Um exemplo é a EXODUS. Essa carteira é multi-device (funciona em vários dispositivos de forma simultânea) e possui boa aceitação entre o público.\n" +
                        "\n" +
                        "Hard Wallet: As chamadas “carteiras físicas”. Funcionam como um pen drive. O bitcoin não “fica no pendrive”, ele fica no Blockchain. A Hard Wallet funciona como se fosse um token, um dispositivo com um protocolo, para que você consiga acessar todos os dados e valores dentro do Blockchain. Uma vez tendo esse dispositivo, você o configura no site da fabricante do mesmo para poder usá-lo. Ele não entra em conexão com a internet em seu funcionamento, garantindo ainda mais segurança. Porém, é um dispositivo caro, em razão de sua segurança, mas é muito viável para aqueles que possuem grandes valores em criptoativos.\n";
                break;
            case "Parte IV":
                text = "A criptografia é um termo antigo, que significa palavra secreta. Imagine em um envio de arquivo, onde é preciso, de alguma forma, embaralhar e esconder esse conteúdo, por algum motivo, de terceiros. Você utilizará palavras secretas, mais conhecidas como criptografia. A técnica foi muito comum em períodos de guerra, onde era necessário, de alguma forma, proteger o conteúdo da mensagem de terceiros.\n" +
                        "\n" +
                        "Com o crescente desenvolvimento da computação, a criptografia foi amplamente usada nesse sentido. É baseada em algoritmos matemáticos complexos, capazes de criptografar mensagens e informações de pessoas indevidas, e mesmo assim, de alguma forma, garantir que o destinatário consiga “desvendar” e entender a informação passada a ele. \n" +
                        "\n" +
                        "Na criação do Bitcoin, Satoshi Nakamoto usou a criptografia para garantir que a rede do Bitcoin fosse segura, que não fosse hackeada e nem manipulada. \n" +
                        "\n" +
                        "Hoje a criptografia é um pilar fundamental em tecnologias que se baseiam em Blockchain. Para garantir que nenhuma pessoa externa possa acessar os dados, há a criptografia de chave pública, e a de chave secreta. A de pública gera uma criptografia de Hash (função criptografa), que facilita a distribuição de informações, enquanto a chave secreta, uma chave privada, criptografa e descriptografa informações entre o remetente e destinatário.\n" +
                        "\n" +
                        "A Evolução da criptografia: \n" +
                        "\n" +
                        "1948/1949 - Fundamentos de criptografia por computador são estabelecidos nos artigos “Uma teoria matemática de comunicação” e “Teoria da comunicação dos sistemas de sigilo”, publicados por Claude Shannon, responsável por fundamentar a teoria e a criptografia moderna.\n" +
                        "\n" +
                        "1976 - Novas direções no estudo da criptografia. Artigos e teses desenvolvidas por Whitfield Diffie e Martin Hellman, onde foi definido o conceito de chave pública. (https://ee.stanford.edu/~hellman/publications/24.pdf).\n" +
                        "\n" +
                        "1981 - Criado um e-mail que não era rastreável, com um algoritmo por trás.\n" +
                        "\n" +
                        "1982 - Assinaturas digitais, uma tecnologia de assinatura cega, por David Chaum. Essa tecnologia foi projetada para garantir total privacidade dos usuários que realizassem transações on-line. Essa tecnologia foi importante para a criação da empresa de Chaum, em 1989, a DigiCash.\n" +
                        "\n" +
                        "1989 – O primeiro sistema de criptomoedas surgiu: a DigiCash, fundada por David Chaum. A moeda era uma forma de pagamento eletrônico antecipado e anônimo, e se tornou única na época por ser usada de forma anônima por conta de sua criptografia. Seu avanço tecnológico em chave pública e privada fez com que as transações fossem anônimas e não rastreáveis. Porém a DigiCash não conseguiu fazer a empresa crescer e decretou falência.\n" +
                        "\n" +
                        "1997 – Fundada a Hashcash, por Adam Back. Foi um sistema de prova de trabalho usado para limitar spam de email e ataques de navegação, mas ficou realmente conhecido por seu uso em Bitcoin como parte do algoritmo de mineração.\n" +
                        "\n" +
                        "1998 - Surge a B-Money, fundada por Wei Dai, um engenheiro de computação que desenvolveu a biblioteca criptográfica Crypto ++ e que em 1998 publicou o artigo “b-money, um sistema de caixa eletrônico anônimo e distribuído”, onde foi descrito todas as propriedades básicas de todos os sistemas modernos de criptomoedas. Seus principais conceitos foram implementados no Bitcoin e em outras criptomoedas.\n" +
                        "\n" +
                        "2004 - surge a ideia de Provas de trabalho reusáveis RPOW(Reusable Proofs of Work), criado por Hal Finney, no qual quando um usuário realizasse certa tarefa e recebesse a prova de trabalho dela, seria gerado um token, que conteria a própria prova, a dificuldade da prova e a assinatura do usuário que gerou esse token. Esse token nada mais seria a confirmação que o usuário conseguiu um certo valor por conta de seu trabalho realizado, que poderia ser usado como uma moeda. Essa ideia foi mais tarde utilizada por Satoshi Nakamoto, para a criação da primeira criptomoeda descentralizada: o Bitcoin.\n" +
                        "\n" +
                        "2009 – surge o Bitcoin, com seu Blockchain, por Satoshi Nakamoto, em um artigo postado e idealizado num fórum a respeito de criptografia, segurança de dados, entre outros.\n";
                break;
            case "Parte V":
                text = "Antes de tudo, é preciso entender que mineração de Bitcoin não é algo físico. Ela ocorre 100% no mundo digital, e para entender o conceito de mineração, é preciso primeiro entender como funciona uma transação de Bitcoin. \n" +
                        "\n" +
                        "As transações de Bitcoin têm a mesma lógica de uma transação bancária, onde é colocado o cadastro de outra pessoa e feito o envio dessa transação, onde ela ficará armazenada em servidores. Para a efetivação desta operação, é preciso que etapas sejam verificadas, como se existe o saldo na conta do remetente, se a conta realmente existe, se a conta de recebimento é válida e todas outras informações necessárias nesse processo. Os computadores responsáveis por essas ações são chamados de servidores e possuem um alto custo de investimento para manter armazenadas todas essas informações.\n" +
                        "\n" +
                        "Com o Bitcoin, não é tão diferente. Quando uma transação de Bitcoin é realizada, assim como em uma transação bancária, será preciso fazer a aprovação e validação de cada etapa do processo, feito pelo Blockchain e por toda a sua programação. As transações de Bitcoin são armazenadas em um bloco de transações, onde esse bloco será mandado aos mineradores para que eles façam a validação e verificação das transações por meio de computadores de mineração. E, uma vez que um bloco de transações seja efetivado, o processo será inalterável, sendo assim, impossível de se voltar atrás para fazer alguma modificação.\n" +
                        "\n" +
                        "Dessa forma, de maneira simplista, a mineração nada mais é que o processo de verificação e registro de transações de Bitcoin, que ficam armazenadas em blocos, dentro do Blockchain. Uma transação de Bitcoin hoje em dia demora, passando por todas etapas e sendo 100% concluída, cerca de 10 a 20 minutos.\n" +
                        "\n" +
                        "E o que os mineradores ganham com isso? Deixando os equipamentos ligados o dia todo gastando energia para verificar transações de Bitcoin?\n" +
                        "\n" +
                        "Eles ganham Bitcoins como recompensa de bloco minerado. No começo de tudo, Satoshi Nakamoto criou um mecanismo de deflação: os Bitcoins seriam gerados a cada bloco minerado, e a cada 210 mil blocos minerados (aproximadamente 4 anos), a recompensa desse bloco minerado seria “cortada” pela metade, processo conhecido como Halving. Em maio de 2020 aconteceu o 3º halving, onde, pela terceira vez, a recompensa dos mineradores caiu pela metade. Dessa forma, o Bitcoin fica cada vez mais escasso, valorizando-o e fazendo com que seja necessário ter equipamentos cada vez mais potentes.\n" +
                        "\n" +
                        "Satoshi definiu que seriam gerados ao todo 21 milhões de unidades de Bitcoin, através do processo de mineração. No começo, em 2009, eram gerados 50 unidades de Bitcoins por bloco minerado (sendo esse valor distribuído a todos que participaram da mineração). Em 2012, com o primeiro Halving, caiu para 25 BTC, e para 12,5 BTC em 2016. Em maio de 2020, ocorreu o terceiro Halving, fazendo com que a recompensa caísse para 6,25 BTC, e esse valor continuará até o próximo Halving. Todo esse mecanismo continuará até que o último Bitcoin seja gerado. Estima-se que isso ocorra em 2140.\n" +
                        "\n" +
                        "Existe a possibilidade da mineração de Bitcoin ser interrompida?\n" +
                        "\n" +
                        "Hoje no mundo, há milhares de equipamentos realizando esse processo. Por esses computadores estarem espalhados pelo mundo todo, não existe a possibilidade de algum governo, por algum motivo, banir e acabar com a mineração de Bitcoin. Além disso, mesmo que haja apenas uma máquina minerando, o Blockchain e o Bitcoin ainda sobreviverão.\n";
                break;
            case "Parte VI":
                text = "Atualmente, uma das formas mais fáceis de minerar é por meio do aplicativo NiceHash. Primeiramente entre no site https://www.nicehash.com/ e clique em “começar”. Insira seu email e senha e cadastre-se no site. Clique em “mining” e faça o download do app NiceHash Miner. Selecione a versão correta ao lado, baixe a versão mais atual e instale o programa baixado.\n" +
                        "\n" +
                        "Entre no aplicativo, faça login e escolha um nome para sua máquina que irá minerar. Em Benchmark, ele estará fazendo a análise de seu hardware para ver a lucratividade dele (selecione apenas GPU, uma vez que a CPU não é tão lucrativa). Abrirão outras telas no seu computador. Não as feche, pois são os mineradores em ação, mas você pode minimizá-las. Em poucos minutos aparecerá abaixo do botão de play na página inicial o valor estimado de lucratividade com sua máquina.\n" +
                        "\n" +
                        "Em Plugins, você pode instalar os plugins que estiverem sendo pedidos para serem instalados, que são extensões/ ferramentas a mais utilizadas para fazer a mineração. É indicado mantê-los sempre atualizados.\n" +
                        "\n" +
                        "Em Devices, você consegue selecionar o hardware a ser utilizado na mineração, escolhendo a sua GPU (placa de vídeo) e/ou a CPU (processador) a serem utilizados na mineração. É recomendado usar apenas a placa de vídeo, uma vez que o processador não é lucrativo.\n" +
                        "\n" +
                        "No canto superior direito, na engrenagem, você consegue conferir algumas informações importantes, como o seu endereço de carteira da NiceHash, o nome da sua máquina e o servidor que você está conectado (conectar se ao Brasil, por exemplo).\n" +
                        "\n" +
                        "Clicando em View Status Online você acessa o site da NiceHash, e pode conferir outras informações. Em seu Dashboard, aparecerá o número de suas máquinas que estão minerando em “active rigs”. Você pode colocar vários computadores minerando na mesma conta, tendo o controle e monitoramento deles. Clicando em “RIG MANAGER” você consegue checar temperatura, hardware utilizado e lucratividade gerada por cada máquina, ou placa de vídeo.\n" +
                        "\n" +
                        "Na aba Wallet (carteira), você consegue ver a quantidade de bitcoins decorrentes à sua mineração, e o valor em dólares ou outra moeda (real, euro, etc).\n" +
                        "\n" +
                        "Como sacar o valor da NiceHash?\n" +
                        "\n" +
                        "Vá no site da NiceHash, clique em wallet e vá em withdraw. Escolha a moeda da sua carteira (Bitcoin) e coloque em “withdraw to” o endereço de sua carteira, como a EXODUS, que você deseja mandar o valor da NiceHash. Há um montante mínimo para isso, e você também pagará uma taxa por essa transação, que será automaticamente descontada. Dentro de algumas horas, o valor estará na sua carteira selecionada.\n" +
                        "\n" +
                        "É possível minerar com um computador comum ou notebook? Vale a pena?\n" +
                        "\n" +
                        "Sim, é possível minerar com computadores convencionais ou até mesmo notebooks. Porém na maioria dos casos não valerá a pena deixar o equipamento ligado o dia todo fazendo isso, uma vez que gastará energia, e terá um baixo retorno. Para saber mais sobre isso, você pode acessar a NiceHash calculator para verificar a lucratividade de seu hardware.\n" +
                        "\n" +
                        "É por isso que para ter realmente um grande lucro é necessário ter um bom hardware, ter energia mais barata e também ter controle do ambiente e equipamento, uma vez que esse a mineração exige muito de seu hardware. Aplicativos de monitoramento de temperatura são recomendados para isso, como por exemplo o HWMONITOR.\n" +
                        "\n" +
                        "Porém, caso você possua uma placa de vídeo minimamente boa, já será possível ter algum retorno. Entretanto, não é nada instantâneo. Será preciso deixar o computador ligado por muito tempo realizando o procedimento.\n";
                break;
            case "Parte VII":
                text = "Há três importantes tipos de classificações de criptomoedas:\n" +
                        "\n" +
                        "Stablecoins: são moedas estáveis, e pareadas a outra moeda. Um exemplo é a USDT TETHER, uma moeda lastreada e pareada ao dólar, sendo basicamente um dólar criptografado. Ela deriva do Blockchain, e só é gerada uma vez que entre dólar na conta. Ao entrar por exemplo 1 milhão de dólares, 1 milhão de dólares tethers serão gerados. Você pode armazená-lo em uma Wallet, e pode fazer a transferência dele de forma mais rápida e para qualquer lugar do mundo, em comparação ao dólar comum, que dependeria de contas bancárias, agilizando o processo de manuseio de dinheiro e podendo assim, comprar Bitcoin por exemplo, a qualquer momento.\n" +
                        "\n" +
                        "Coins: criptomoedas, como o Bitcoin, que foram desenvolvidas para um dia substituir uma moeda local, do dia a dia. Mas ainda não são populares a esse ponto, e não há aceitação de algumas pessoas. O próprio Bitcoin, por exemplo, existe há cerca de 12 anos, mas só agora que está sendo realmente aceito por bancos, instituições e por fundos de investimento.\n" +
                        "\n" +
                        "Tokens: são ativos digitais criados a partir de um Blockchain secundário. É basicamente uma representação de um ativo físico num ambiente digital. Uma das principais características deles é que deriva de uma Blockchain já existente. Os mais comuns são os Tokens erc20, criados pelo Ethereum. Para criar um Token, você utiliza um Blockchain já existente para desenvolver a aplicação, por ser mais barato e rápido, e incorpora no seu desenvolvimento.\n" +
                        "\n" +
                        "Normalmente, Tokens representam alguma coisa. Há os Utility Tokens, que são utilizados como benefícios, podendo por exemplo trocá-los por energia. Há os security token, representação de security, como ações de propriedades lastreadas nesses tokens.\n" +
                        "\n" +
                        "Outra funcionalidade pode ser a compra de um apartamento, por exemplo, que já acontece hoje. Você pode comprar esse imóvel, “não com Tokens”, mas o Token representa a propriedade do ativo, então quando for transacionar esse ativo com alguém, é muito mais fácil e barato usar um Token do que fazer o registro no imóvel e toda aquela burocracia.\n" +
                        "\n" +
                        "Existem criptomoedas brasileiras?\n" +
                        "\n" +
                        "Sim. Há diversas criptomoedas criadas no Brasil. Dentro delas, destacam-se: Blood Donation Coin, Martex Coin, Lunes, CriptoReal, ZCore, Niobiocash, AmazonasCoin, Spero Coin, Bitblocks, Market Cash, Fanaticos Cash.\n" +
                        "\n" +
                        "A MastexCoin e a Dilma Coin (esta com caráter experimental) foram as primeiras criptomoedas do Brasil a serem criadas, em 2014.\n" +
                        "\n" +
                        "A maioria das criptomoedas brasileiras foram criadas entre 2017 a 2018, quando o Bitcoin começou a se popularizar bem, mas nenhuma dessas moedas chegaram a ser amplamente utilizadas no país. \n" +
                        "\n" +
                        "O Brasil, de acordo com uma pesquisa realizada pela Global Digital Report, é o 5° país do Mundo com maior quantidade de usuários de Bitcoin e criptomoedas. Cerca de 8,1% dos brasileiros entre 16 a 64 anos possuem alguma criptomoeda, estando acima da média mundial, que gira em torno de 5,5%.\n";
                break;
            case "Parte VIII":
                text = "Ethereum é uma DAPP (decentralized application) e tem o Ether(ETH) como sua própria criptomoeda(ambos os termos são comumente usados como sinônimos). Essa aplicação consiste em utilizar o Blockchain do protocolo do Ethereum para aplicar em outros negócios, por meio de contratos inteligentes. Dessa forma você não tem o custo de desenvolvimento, a rede vai se auto ajustando e você precisará de poucas pessoas para desenvolver o negócio, uma vez que já existe o Blockchain.\n" +
                        "\n" +
                        "Em 2013, a Ethereum foi idealizada pelo programador canadense Vitalik Buterin e, em 2015, a plataforma entrou online com uma tecnologia que pudesse desenvolver contratos inteligentes no âmbito do Blockchain. Desde então, vem ganhando cada vez mais popularidade.\n" +
                        "\n" +
                        "Mas o que é o Ethereum? É uma plataforma descentralizada capaz de criar e executar contratos inteligentes. E o que são esses contratos inteligentes? Imagine num acordo entre duas partes entre um serviço e um pagamento, para que quando acordado o contrato, entre ambas as partes, o serviço e os ativos financeiros sejam trocados entre ambas as posições, o chamado “swap”. Não é necessário ambas as pessoas se conhecerem, nem mesmo ter intermediários para certificar o negócio. Você tira intermediários na negociação para um sistema inteligente. Essa ideia foi muito revolucionária, pois essa plataforma permitia que as pessoas usassem essa tecnologia para aplicar em diversos outros negócios.\n" +
                        "\n" +
                        "O Blockchain do Ethereum hoje é extremamente usado por empresas e governos em diversas aplicações. Ele acelera o processo e torna mais automatizados. E como o Blockchain não é possível ter fraudes, as informações contidas nesses contratos são verdadeiras, eliminando a necessidade de ter alguém efetivando o processo.\n";
                break;
            case "Parte IX":
                text = "As transações de criptomoedas ocorrem na tecnologia Blockchain, entre o endereço remetente e o destinatário, usando uma chave pública. Utiliza-se para essas transações as carteiras digitais, que são meios de armazenar as informações digitais que permitem o usuário usar e enviar seus fundos em Bitcoin, através das chaves públicas (endereços para envio). \n" +
                        "\n" +
                        "As transações são feitas pelo Blockchain, e verificadas pelo processo da Mineração. Uma vez uma transação aprovada, o Bitcoin é transferido de uma pessoa a outra, e é “armazenado” numa carteira, que pode ser uma Hard Wallet (dispositivo físico), uma Desktop ou Mobile wallet (através de um APP), ou mesmo em um serviço de carteira, disponibilizado em um site. \n" +
                        "\n" +
                        "Trading de Criptomoedas nada mais é que a negociação, venda e compra, de seus criptoativos. Antes de tudo, é primeiramente preciso fazer um investimento, necessitando assim, um capital inicial. \n" +
                        "\n" +
                        "Com o dinheiro em mãos, é preciso transformá-lo em criptomoedas. Acesse o site da Binance www.binance.com para poder depositar o dinheiro e fazer a compra dos criptoativos. Você pode guardá-los numa carteira pensando numa valorização futura, ou tentar negociá-los em troca de bens ou serviços. Sem falar também, que uma criptomoeda é algo muito mais fácil de se manusear do que dinheiro físico, ou também muito mais fácil de transacionar com outra pessoa esse valor de forma internacional, uma vez que não haveria toda aquela burocracia com um dinheiro tradicional.\n" +
                        "\n" +
                        "A REX Investimentos terá sua própria Exchange, e quando for lançada oficialmente, ela contará com uma futura atualização que irá incluir a opção de trading.\n";
                break;
            case "Parte X":
                text = "1 – Colocando dinheiro na corretora.\n" +
                        "\n" +
                        "Primeiramente acesse o site www.binance.com, ou baixe o aplicativo da Binance. Crie uma conta em “registrar”, colocando o email e prosseguindo os passos requeridos.\n" +
                        "\n" +
                        "Clique em “Compre Cripto”, escolha a moeda e o método de pagamento. Deixe selecionado as opções de depósito e dinheiro. Em detalhes de pagamento, insira a quantia de dinheiro e outras informações requeridas. Clique em continuar." +
                        "\n" +
                        "A partir daí, vá na conta de seu banco e realize o pagamento via PIX, ou transferência normal.\n" +
                        "\n" +
                        "Realizado o pagamento, vá em “carteira” e clique em visão geral para ver seu saldo e outras informações. Com o dinheiro na corretora, agora é possível comprar Bitcoin ou qualquer outra criptomoeda disponível na Exchange.\n" +
                        "\n" +
                        "2 – Comprando criptomoedas\n" +
                        "\n" +
                        "Na parte superior do site da corretora, vá até a opção “Exchange”.\n" +
                        "\n" +
                        "Você pode ver toda a variação das criptomoedas desejadas por hora, dia ou mês. Ao lado, é possível selecionar a moeda desejada e também a criptomoeda a se analisar, atualizando o gráfico.\n" +
                        "\n" +
                        "Abaixo, é possível fazer a compra da moeda desejada. Você pode informar o valor que deseja comprar cada moeda e a quantidade a comprar da mesma. Há também uma linha de porcentagem de compra, onde é possível escolher a porcentagem de seu saldo a comprar uma moeda. Escolha quanto deseja comprar, ou quanto deseja gastar, e clique em comprar. Após isso, você pode conferir o saldo da criptomoeda comprada em carteira Fiat e Spot\n" +
                        "\n" +
                        "Futuramente, iremos criar nossa própria Exchange, a REX Investimentos, no qual todo usuário que possuir nosso plano vitalício do APP irá ganhar uma quantia de nossa criptomoeda, a REX Coin.\n";
                break;
            case "Parte XI":
                text = "Após a compra de bitcoins, é necessário guardá-los em um carteira, como por exemplo, a EXODUS. Acesse: https://www.exodus.com/ e faça o download, para desktop ou mobile.\n" +
                        "\n" +
                        "Com a carteira instalada, vá em Settings e clique em Backup. Crie uma senha, e ANOTE as palavras geradas. Faça num papel e guarde em segurança. Evite tirar prints ou salvar de modo online, uma vez que caso você tenha algum problema com seu computador ou celular, essas informações poderão ficar comprometidas. Finalize selecionando a palavra que existe nas que você anotou, e conclua.\n" +
                        "\n" +
                        "Feito o backup, agora é possível transferir as criptomoedas para a carteira. Volte a página principal e clique em Wallet na parte superior. Clique em Receive, e lá estará seu endereço de carteira, onde será possível transacionar e armazenar os bitcoins de alguma corretora, como a Binance.\n" +
                        "\n" +
                        "É possível sacar Bitcoin em um caixa eletrônico? \n" +
                        "\n" +
                        "Sim. Ao redor do mundo, já existem diversos caixas de Bitcoins (conhecido como BTC ATM). Esses caixas se assemelham muito aos caixas normais, porém os ATM de Bitcoin se diferenciam pelo fato de não se conectarem a uma conta bancária, e sim, a um sistema de câmbio de criptomoedas. Essencialmente, o BTC ATM não é um caixa tradicional, mas sim, terminais onde o usuário conecta-se à plataforma para fazer a compra e venda de criptomoedas. Hoje, existem mais de 800 máquinas espalhadas pelo mundo, em mais de 75 países\n" +
                        "\n" +
                        "E no Brasil? Em 2020, o primeiro caixa eletrônico de Bitcoins foi instalado, na cidade de São Paulo, em um lobby de um Hotel na avenida das Nações Unidas.\n" +
                        "\n" +
                        "O BTM da empresa americana Coin Cloud permite a compra e venda de criptomoedas. No processo, os criptoativos ficam armazenados numa carteira digital da própria empresa, chamada Coin Cloud Wallet. O Brasil foi o primeiro país fora dos EUA a ter um caixa eletrônico da Coin Cloud.\n";
                break;
            case "Parte XII":
                text = "O Bitcoin é a criptomoeda que mais vem se popularizando nos últimos anos, e também, atraindo mais pessoas e empresas a utilizá-la. Diversos comércios e empresas, de vários setores, utilizam o Bitcoin como forma de pagamento.\n" +
                        "\n" +
                        "1 – Viagens e turismo: \n" +
                        "\n" +
                        "É possível comprar passagens para viagens, em companhias aéreas como a CheapAir usando Bitcoins, por exemplo. Além disso, também é possível fazer reservas em hotéis com o criptoativo, em agências que aceitam o Bitcoin.\n" +
                        "\n" +
                        "2 – Lojas virtuais: \n" +
                        "\n" +
                        "Diversos comércios e empresas utilizam o Bitcoin como forma de pagamento. Dentro delas: a Overstock, que aceita esse pagamento desde 2014 e vende eletrodomésticos, móveis e joias; a Newegg, loja virtual norte americana de eletrônicos; a Amazon, que até mesmo oferece descontos à quem comprar utilizando Bitcoins; a Microsoft, onde é possível comprar apenas jogos na Windows Store; dentre outras. Há também a Dell, empresa gigante de tecnologia, que foi uma das primeiras a aceitarem esse tipo de pagamento. Porém, hoje, a empresa restringiu essa forma apenas aos Estados Unidos.\n" +
                        "\n" +
                        "3 - Alimentação: \n" +
                        "\n" +
                        "O setor de produtos alimentícios também é outro local onde é possível usar Bitcoins. A Subway é um dos exemplos, que utilizam, em algumas lojas nos Estados Unidos, essa criptomoeda como pagamento. No Brasil, há algumas lojas na cidade de São Paulo com essa possibilidade, como por exemplo, a Quero Vinho.\n" +
                        "\n" +
                        "4 - Acessórios: \n" +
                        "\n" +
                        "Lojas de roupas e vestuários também estão na lista. Em São Paulo, por exemplo, a Calvin Klein aceita Bitcoins como pagamento desde o final de 2018, e continua até hoje, onde é possível pagar em Bitcoins através do QR code.\n" +
                        "\n" +
                        "É possível também fazer doações usando a criptomoeda. A Save de Children, a The Water Project e a Cruz Vermelha são instituições onde é possível fazer doações de Bitcoins.\n";
                break;
            case "Parte XIII":
                text = "1 – FACILIDADE NAS NEGOCIAÇÕES\n" +
                        "\n" +
                        "Apesar de não parecer, investir em Bitcoins é muito mais fácil do que parece, pois não exige tantos conhecimentos técnicos e não é necessário calcular métricas como em alguns investimentos no mercado tradicional como fundos imobiliários e ações.\n" +
                        "\n" +
                        "2 – DINHEIRO UNIVERSAL\n" +
                        "\n" +
                        "Pense em mandar dinheiro para fora do país. Você terá despesas, taxas, custos e costuma ser muito trabalhoso. O Bitcoin quebra essas barreiras, pois é uma moeda internacional. Além disso, não há aquela burocracia toda, como em um sistema tradicional, onde existe um limite de câmbio, declaração do porquê da transação, entre outros.\n" +
                        "\n" +
                        "3 – DINHEIRO SEGURO\n" +
                        "\n" +
                        "Por ser uma moeda descentralizada, o governo e instituições financeiras não têm acesso a isso, não conseguindo manipular esse ativo em questão de preço. Então, “você cuida do seu dinheiro”, tendo maior segurança e total autonomia.\n" +
                        "\n" +
                        "4 – INFORMAÇÕES DE TRANSFERÊNCIAS E PAGAMENTOS SEGUROS\n" +
                        "\n" +
                        "Você tem todo o acesso e controle de sua conta. Com o Bitcoin, por ser um número de carteira pseudônimo, é possível proteger suas informações e todas as transações ficam registradas no Blockchain.\n" +
                        "\n" +
                        "5 – PROTEÇÃO DO SEU PATRIMÔNIO\n" +
                        "\n" +
                        "Proteção contra a inflação. O Bitcoin diferentemente do dinheiro tradicional tem uma quantidade máxima a ser criado. Em sua criação, programado por Satoshi Nakamoto, foi definido que o Bitcoin teria uma quantidade máxima a ser emitido através da mineração. Já o dinheiro tradicional, como euro, dólar e real, que é controlado por um banco central, eles têm a possibilidade de emissão de “novos dinheiros”. No Bitcoin, há o controle dessa emissão, existindo os halvings, que aumenta a escassez do ativo, valorizando-o.\n";
                break;


        }

        return text;

    }


}
