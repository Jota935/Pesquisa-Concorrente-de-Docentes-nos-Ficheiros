📘 README – Pesquisa Concorrente de Docentes

📌 Descrição do Projeto

Este projeto implementa uma solução concorrente para acelerar a pesquisa de nomes de docentes em múltiplos ficheiros de registo da Secretaria da Universidade de Mindelo.

A solução utiliza o padrão Produtor–Consumidor, com threads, buffer compartilhado e mecanismos de sincronização (wait, notify, notifyAll), permitindo que vários ficheiros sejam pesquisados em paralelo, reduzindo significativamente o tempo de resposta.

🎯 Objetivo

Pesquisar um nome de docente em 9 ficheiros, cada um contendo 1000 nomes.

Utilizar Programação Concorrente para realizar a pesquisa de forma eficiente.

Interromper imediatamente todos os processos assim que o nome for encontrado.

Indicar o ficheiro e a linha onde o nome foi localizado.

🧩 Tecnologias Utilizadas

Java

Threads

Programação Concorrente

Padrão Produtor–Consumidor

synchronized

wait(), notify(), notifyAll()

Manipulação de ficheiros (BufferedReader, FileReader)

📂 Estrutura do Projeto
📁 projeto/
│
├── Main.java
├── Producer.java
├── Consumer.java
├── SharedBuffer.java
├── NameTask.java
├── SearchController.java
│
├── ficha1.txt
├── ficha2.txt
├── ficha3.txt
├── ficha4.txt
├── ficha5.txt
├── ficha6.txt
├── ficha7.txt
├── ficha8.txt
└── ficha9.txt

🔄 Funcionamento do Sistema
🔹 Produtores

Cada thread produtora lê um ficheiro linha por linha.

Cada linha (nome do docente) é colocada no buffer compartilhado.

🔹 Buffer Compartilhado

Estrutura sincronizada que armazena temporariamente os nomes.

Controla o acesso concorrente usando wait() e notifyAll().

🔹 Consumidores

As threads consumidoras retiram nomes do buffer.

Comparam cada nome com o nome procurado.

Quando o nome é encontrado, notificam todas as threads para encerrar a execução.

🛑 Encerramento da Execução

Assim que o nome é encontrado:

Todos os produtores e consumidores são interrompidos.

O ficheiro e a linha são registados.

Se o nome não existir em nenhum ficheiro:

O sistema informa que o nome não foi encontrado.

📥 Entrada do Programa

Nome do docente a ser pesquisado.

Conjunto de 9 ficheiros de texto (ficha1.txt a ficha9.txt).

Exemplo:

String targetName = "Maria Silva";

📤 Saída Esperada
✔ Caso o nome seja encontrado:
Nome encontrado no ficheiro: ficha5.txt, na linha: 734

❌ Caso o nome não seja encontrado:
Nome não encontrado em nenhum dos ficheiros.

⚠️ Tratamento de Erros

O programa trata:

Ficheiros inexistentes ou corrompidos

Interrupções de threads

Sincronização incorreta entre threads

Encerramento seguro da aplicação

✅ Requisitos Atendidos

✔ Uso de threads produtoras e consumidoras

✔ Buffer sincronizado

✔ Uso explícito de wait, notify, notifyAll

✔ Interrupção global ao encontrar o nome

✔ Suporte a 9 ficheiros simultâneos

✔ Código modular e organizado

🧠 Conceitos Aplicados

Programação Concorrente

Comunicação entre threads

Exclusão mútua

Sincronização

Paralelismo

Padrões de projeto concorrentes
