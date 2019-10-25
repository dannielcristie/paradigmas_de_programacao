## Sistema de tipos


* Introdução
* Checagem de tipos
* Linguagens estáticas vs dinâmicas
* Tipos de dados
* Completude de tipos


## Introdução
Duas excelentes referência sobre sistema de tipos são:

* Cardelli - On understanding types, data abstraction, and polymorphism
* Benjamin C. Pierce - Advanced topics in types and programming languages

Segundo estes autores:

> Type systems are generally formulated as collections of rules for checking the “consistency” of programs. (Piercy, 2004)

>  In mathematics as in programming, types impose constraints which help to enforce correctness (Cardelli 1985).

> "The fundamental purpose of a type system is to prevent the occurrence of execution errors during the running of a program." (Cardelli, 2004)

Sobre sistemas de tipos, iremos falar sobre:

* Chegagem de tipos
* Linguagens estáticas vs dinâmicas
* Tipos de dados
  

***

### Checagem de tipos

* O processo de verificação de erros de tipos ou checagem de tipos.
  
* **Checagem de tipos** assegura que uma dada operação é aplicada a operandos adequados.
* As checagem de tipos podem ser executadas em 
  * **tempo de compilação** (estática),
  * em **tempo de execução** (dinamica),
  *  ou em ambos.

* Um erro de tipo ocorre se o programa executa uma operação com tipos incompatíveis, tais como multiplicar uma string por um valor booleano

* Uma linguagem é dita **fortemente tipada** se os erros de tipo são sempre detectados, seja em tempo de compilação ou em tempo de execução.  Por exemplo, a linguagem C é fracamente tipada, mesmo tendo verificação de tipos em tempo de compilação.

Por exemplo, em Kotlin a seguinte linha é identificada como um erro de tipo, dado que x é Double e o resultado de `10 / 5` é um Int.

```kotlin
 var x : Double = 10 / 5
 ```

 Um outro exemplo que mostra que Kotlin é mais fortemente tipada que Java:

```kotlin
fun maior (x: Double, y: Double) : Double {
    return if (x > y) x else y
}

fun main(args: Array<String>) {
	println (maior (10,5)) // não compila, dado que 10 e 5 são Ints 
}
```

> OBSERVAÇÃO: Uma linguagem pode ser fortemente tipada sendo dinâmica ou estática. A diferença que as linguagens estáticas podem verificar na compilação e as dinâmicas apenas na execução.

***

### Linguagens estáticas vs dinâmicas

Classificação de Linguagens do sistema de tipos:

* **Estaticamente tipadas** - toda variável e parâmetro está amarrado a um tipo em tempo de compilação, deste modo as checagens de tipo podem ser feitas estaticamente  (Pascal, C, C++, Haskell, Ada, Swift). 
  
  > "Programming languages in which the type of every expression can be determined by static program analysis are said to be statically typed (Cardelli).
  
  
* Por exemplo em C:

```C
int max(int a,int b) {
    if (a > b)  
        return a;
    else   
        return b
}
max (4, 5) // retorna 5
max (3.5,3.1) // retornar 3, pois como C é fracamente tipada, ocorre aqui uma conversão para inteiro. Em uma linguagem fortemente tipada como Kotlin, daria um erro de compilação
```

  
* **Dinamicamente tipadas** - apenas valores são amarrados a tipos. Variáveis e parâmetros não possuem um tipo, podendo assumir valores de diferentes tipos em tempo de execução, (Smalltalk, Clipper, SNOBOL, Python, Ruby, Lua,  Java Script). Usando a definição de (Cardelli, 1985):
  
  
* Por exemplo em Lua

```lua
function max (a, b)
    if a > b then 
return a 
    else 
return b end
end
print (max (3.2, 3.6))
print (max ("a","b"))
```

***

### Linguagens estáticas vs dinâmicas

Cardelli, faz uma boa discussão sobre linguagens estáticas e dinâmicas, em seu artigo: On understanding types, data abstraction, and polymorphism. 

Ele apresenta as seguintes vantagens das linguages estaticamente tipadas:

> Static typing allows type inconsistencies to be discovered at compile time and guarantees that executed programs are type-consistent. It facilitates early detection of type errors and allows greater execution-time efficiency. It enforces a programming discipline on the programmer that makes programs more structured and easier to read." 

Depois ele apresenta a principal desvantagem:

> But static typing may also lead to a loss of flexibility and expressive power by prematurely constraining the behavior of objects to that associated with a particular type. . For example they exclude generic procedures, e.g. sorting, that capture the structure of an algorithm uniformly applicable to a range of types.

* Como veremos no decorrer do curso, o **Polimorfismo** está relacionado aos mecanismos que permitem que as linguagens estaticamente tipadas se tornem mais flexíveis.
* Outro recurso presente nas linguagens estaticas modernas é a **inferência de tipos**, presentes em linguagens como Haskell, Swift, Scala, Kotlin e parcialmente suportado por Java. Por exemplo em Kotlin o tipo da variável x é inferido para Integer, então a execução da terceira linha levaria a um erro de compilação:


```kotlin
fun main () {
	var x = 10
	println (x)    
    //x = "ola"
}
```



***

### Duck typing

A linguagem Python, possui um sistema de tipos dinâmico e usa o conceito de Duck Typing.

> Este nome vem da seguinte constatação: se um objeto anda como um pato e faz quack como um pato então ele é um pato.

Conceitualmente, podemos definir Duck Typing como:

> _"Duck Typing é uma técnica que funciona com qualquer linguagem de programação com suporte ao paradigma OO e diz basicamente que: se o seu objeto responde à uma determinada mensagem (chamada de método) característica de um determinado tipo de objeto então esse objeto também pode ser considerado do mesmo tipo". https://osantana.me/duck-typing/_


***
### Duck typing: exemplos

Para ilustrar o conceito de _duck typing_, considere três classes distintas que coincidentemente possuem um método com o mesmo nome. Neste caso, o método getNome que retorna o nome daquele objeto. Contudo, estas classes fazem parte de uma biblioteca externa, então você pode apenas usar. Caso este cenário ocorra em Python, poderiamos ter as seguintes classes definidas.

```python
class Docente:
    def __init__(self,nome):
        self.nome = nome
    def getNome(self):
        return self.nome

class Discente:
    def __init__(self,nome):
        self.nome = nome
    def getNome(self):
        return self.nome

class Curso:
    def __init__(self,nome):
        self.nome = nome
    def getNome(self):
        return self.nome   
```

Dado estas caraterísticas desta linguagem, logo pode-se criar uma função imprimeNomes que para cada objeto de uma lista ela aplica o método getNome. Deste modo, o único pre-requisito desta função é que os métodos da lista implementem este método. Caso contrário, um erro irá ocorrer em tempo de execução.

```python
def imprimeNomes (l):
    for i in l:
        print (i.getNome())

imprimeNomes([Curso ("Engenharia da Computacao"),
     Docente ("Claudio Aroucha"), Discente ("Luiz Fernando")]
```

### Tipos de dados


> The type of an object determines the set of values it can have and what operations can be performed on it (The C Programming Language, Ritchie e Kernighan).

* Valores são agrupados por tipos de acordo com as operações poderão ser executadas sobre eles. Então podemos dizer que um tipo é um conjunto de valores: 
 
```
v é um valor de tipo T se v Є T
```

* Um tipo é um conjunto de valores que exibe um comportamento uniforme sob operações associadas a este conjunto. Por exemplo, para Boolean temos:

  - Valores: `{true, false}`, 
  - Operações: `and, or, not`


* Dado que o tipo é um conjunto, então a cardinalidade de um tipo T, escrito #T, e a quantidade de valores do tipo T. Por exemplo, #Boolean = 2

***

### Classificação dos tipos de dados

Os tipos de dados podem ser classificados em primitivos e compostos:

- Tipo primitivo é onde os valores são primitivos. Valores primitivos são aqueles cujos valores são atômicos – não podem ser decompostos em valores mais simples. Exemplos: char, integer, double, boolean 
- Tipo composto é um tipo cujos valores são compostos. Um valor composto ou estruturado é quando o seu valor é composto a partir de valores mais simples. Exemplos: struct, array, unions, records, tuples, lists …

De acordo com (David Watt, 2006) , os tipos compostos podem ser categorizados em:

- Cartesian products (tuples, structures, records)
- Mappings (arrays, functions),
- Disjoint unions (algebraic data types, discriminated records, objects) e
- Recursive types (lists, trees, etc.)

> um bom livro sobre tipos de dados foi escrito durante o desenvolvimento da programação estruturada: Hoare - [Notes on Data Structuring](https://pdfs.semanticscholar.org/baf7/f3bd10c4e84d61e3b7eafbdbfb66bab367a9.pdf)

***

### Completude de tipos

Algumas linguagens restringem essas operações sobre alguns valores.

- **Valores de segunda classe** - podem ser passados como argumentos, mas não podem ser avaliados, atribuídos, ou fazer parte de valores compostos. 
- **Valores de primeira classe** - podem ser passados com argumentos, avaliados, atribuídos e fazer parte de valores compostos.

>Nas linguagens funcionais, por exemplo,   funções são tratadas como valores de primeira classe. Algumas linguagens como JavaScript, Python, Ruby e Lua tem tratado funções como valores de primeira classe.

Um simples código em JavaScript:

```javascript
    $(“button”).click(function(){
        facaAlgo();
    });
