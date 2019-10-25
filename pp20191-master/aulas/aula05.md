## Introdução a Plataforma Java

### Breve histórico

* O Java foi iniciado como um projeto chamado "Oak" por James Gosling em junho de 1991
  
![Foto de Jame Gosling](https://mappingthejourney.com/wp-content/uploads/2017/08/james_gosling.jpg)


* Os objetivos de Gosling eram implementar uma máquina virtual e uma linguagem que tivesse uma notação similar a C, mas com maior uniformidade e simplicidade. 
  
* A primeira implementação pública foi Java 1.0 em 1995 com o seguinte lema: "Write Once, Run Anywhere"
 
*  Era razoavelmente seguro e sua segurança era configurável, permitindo que o acesso a redes e arquivos fosse limitado. Os principais navegadores da Web incorporaram-no em suas configurações padrão em uma configuração segura de "applet" que se tornou popular rapidamente. 
*  Novas versões para plataformas grandes e pequenas (J2EE e J2ME) logo foram projetadas com o advento do "Java 2". 
*  Grandes mudanças ocorreram com o advento do Java 5, e mais recente com o Java 8, e a novoa politica de atualizações.

Referencia: http://www.freejavaguide.com/history.html



### Os cinco princípios

Havia cinco objetivos principais na criação da linguagem Java:

1. Deve usar a metodologia de programação orientada a objetos.
2. Deve permitir que o mesmo programa seja executado em vários sistemas operacionais.
3. Ele deve conter suporte interno para o uso de redes de computadores.
4. Deve ser projetado para executar código de fontes remotas de forma segura.
5. Deve ser fácil de usar, selecionando os melhores recursos de outras linguagens orientadas a objeto.

> 


Referencia: http://www.freejavaguide.com/history.html



***

### A plataforma Java

* Para dominar o ecossistema é preciso compreender toda a plataforma, que inclui não apenas a linguagem.
  * Esse é um dos motivos da sua fama de ser uma linguagem complexa.
  
* JRE (Java Runtime Environment) está presente na maioria dos computadores, sendo basicamente a máquina virtual que irá executar as aplicações Java.
* JDK (Java Development Kit) é o kit que permite desenvolver aplicações Java, incluindo bibliotecas, compilador, e utilitarios.
  - É possível usar tanto o JDK mantido pela Oracle, quanto usar o OpenJDK mantido pela 

***
### A plataforma Java

* A plataforma de desenvolvimento inclui:
  - Java SE (Java Platform, Standard Edition). É a base da plataforma;
    - inclui o ambiente de execução (JVM) e as bibliotecas comuns (trabalhar com entrada e saída de dados, Strings, coleções).

  - Java EE (Java Platform, Enterprise Edition). A edição voltada para o desenvolvimento de aplicações corporativas e para internet.

  - Java ME (Java Platform, Micro Edition). A edição para o
    desenvolvimento de aplicações para dispositivos móveis e embarcados. Atualmente é provavelmente pouco utilizada, dado as plataformas mobiles atuais.


> Nos últimos anos, o processo de atualizações mudou muito, como podemos [ver aqui](https://en.wikipedia.org/wiki/Java_version_history). 
***

### 


### O clássico "Ola Mundo"



<!--
visualizar bytecode

javap -v Arquivo.class

-->
****

### A linguagem

* A sintaxe da linguagem foi muito influenciada pelas linguagens C/C++.
* Com relação ao C++, ela se diferenciava por não ser uma linguagem híbrida e por possuir um "garbage collector".
* Um programa na linguagem Java é uma coleção de classes que se relacioname, onde cada classe possui atributos e métodos.
* Atualmente se encontra versão 12 (https://docs.oracle.com/javase/specs/)
  
***

#### Comparação com outras linguagens

Referencia: Java in nutshell

##### Java em comparação com C

* Java é orientado a objetos; C é procedural.
* Java é portável como arquivos de classe; C precisa ser recompilado.
* Java não possui ponteiros e nada equivalente a aritmética de ponteiros.
* Java fornece gerenciamento automático de memória por meio da coleta de lixo.
* O Java não tem capacidade de distribuir memória em baixo nível (sem structs).
* Java não tem pré-processador.

***

##### Java em comparação com o C ++
* Java tem um modelo de objeto simplificado comparado ao C++.
* O despacho do Java é virtual por padrão.
* Passagem de argumentos em Java é sempre por valor (mas uma das possibilidades para os valores de Java são
referências de objetos).
* Java não suporta herança múltipla.
* Os genéricos de Java são menos poderosos (mas também menos perigosos) que os templates C++.
  * (todo: pensar em algum exemplo que explique essa afirmação)
* Java não tem sobrecarga de operador.


***

##### Java comparado ao PHP
* Java é estaticamente tipada; PHP é dinamicamente tipada.
* Java tem um JIT; PHP não (mas pode vir a ter na versão 6).
* Java é uma linguagem de propósito geral; PHP raramente é encontrado fora dos sites.
* Java é multithreaded; PHP não é.


***

##### Java comparado ao JavaScript
* Java é estaticamente tipada; JavaScript é dinamicamente tipada.
* Java usa objetos baseados em classes; JavaScript é baseado em protótipos (a partir da versão 6 JavaScript começou a usar classes).
* Java fornece bom encapsulamento de objetos; Javascript não (está mudando tambem a partir da versão 6).
* Java possui namespaces; JavaScript não.
* Java é multithreaded; JavaScript não é.

***






