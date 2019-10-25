## Herança, Polimorfismo, Sobrescrita e Ligação dinâmica

### Herança

A herança é um tipo de relação nos ajuda a tratar modelagens que lidam com categorias de objetos que são relacionados de modo hierárquico, como relações de pais e filhos (Similar a biologia). Além disso, 
na programação ela favorece a reusabilidade. 
 * A reusabilidade é uma qualidade desejável no desenvolvimento de grandes sistemas. 

Como discutido previamente, os tipos abstratos de dados (TAD), com seu encapsulamento e controle de acesso, são as unidades de reuso nas linguagens orientadas a objetos. TADs em linguagens orientadas a objetos são chamadas de classes, e suas instâncias de objetos. Contudo as capacidades de um tipo existente podem não atender plenamente as necessidades da aplicação cliente, requerendo adaptações. Porém, isso iria requerer o acesso e a compreensão do codigo existente dentro do tipo.


Por exemplo, dada uma classe Circle, já com alguns metodos útéis:


    public class Circle {
            public static final double PI = 3.14159; // A constant
            public double r; // An instance field that holds the radius of the circle
            // The constructor method: initialize the radius field 
            public Circle(double r) { this.r = r; }
            // The instance methods: compute values based on the radius 
            public double circumference() { return 2 * PI * r; }
            public double area() { return PI * r*r; }
    }

Poderia ser extendida para suportar a sua localização em um plano cartesiano. Assim, podendo agora implementar o método inside.


    public class PlaneCircle extends Circle {
            // New instance fields that store the center point of the circle 
            public double cx, cy;
            public PlaneCircle(double r, double x, double y) {
                    super(r); 
                    this.cx = x; 
                    this.cy = y;
            }
            public boolean isInside(double x, double y) {
                    double dx = x - cx, dy = y - cy;
                    double distance = Math.sqrt(dx*dx + dy*dy); 
                    return (distance < r);
            }
    }

Então, poderiamos usar em uma aplicação:


    PlaneCircle pc = new PlaneCircle(1.0, 0.0, 0.0); // Unit circle at the origin 
    double ratio = pc.circumference() / pc.area()



### Polimorfismo de inclusão

> veremos depois outros tipos de polimorfismos

Este tipo de polimorfismo requer que os tipos sejam relacionados dentro de um hierarquia de classes. Por exemplo:

    Circle c = pc;         // Assigned to a Circle variable without casting

Observação: “Every PlaneCircle object is also a perfectly legal Circle object. If pc refers to a PlaneCircle object, we can assign it to a Circle variable and forget all about its extra positioning capabilities”. Esse é o princípio básico para o polimorfismo de inclusão, como veremos mais a frente

Uma definição simples para polimorfismo de inclusão é encontrada em (Grady Brooch. Object-Oriented Analysis and Design with Applications. 1993)

> “When a name denotes instances of many different classes related by some common superclass.” 


Em termos de código, podemos considerar as seguintes classes:

```java
class Geometry {
        protected double x, y;
        public void draw () {. . .} 
        ...
        
class Circle extends Geometry {
        private double r;
        ...
        

class Rectangle extends Geometry {
        private double w, h;
        ...
        
```

Então, em uma aplicação poderíamos ter um mesmo nome (geo) associado a instâncias de diferentes tipos (Rectangle e Circle) desde que relacionado por uma mesma super classe (Geometry).

```java
Geometry geo;
...
geo = new Rectangle (3.0, 4.0);
...
geo = new Circle(3.0, 4.0, 5.0);
```

Outra definições mais completa é encontrada em (David Watt):


> “Inclusion polymorphism is a type system in which a type may have subtypes, which inherit operations from that type. Where a type T is a set of values, equipped with some operations. A subtype of T is a subset of the values of T, equipped with the same operations as T. Every value of the subtype is also a value of type T, and therefore may be used in a context where a value of type T is expected”.


Ainda segundo o mesmo autor:

> “Inclusion polymorphism is a key concept, enabling an object of a subclass to be treated like an object of its superclass. This allows us, for instance, to build a heterogeneous collection of objects of different classes, provided that the collection is defined in terms of some common ancestor class”.


Uma definição dada por Kim Bruce:


> “Because values may have multiple types in languages supporting subtyping, we say these languages support subtype polymorphism. If v has type T, subtype polymorphism allows it to be used in any context that expects a value of some type U as long as T is a subtype of U.”


Aproveitando o mesmo exemplo anterior:

```java
...
List<Geometry> l = new LinkedList<Geometry>();
// insere os elementos
...
// desenha todas geometrias
for (Geometry geo: l) {
    geo.draw(); // essa parte da aplicação não precisa saber qual a instãncia
}
```

### Sobrescrita e ligação dinâmica


Voltando ao exemplo anterior, na prática seria pouco provável que o método `draw` definido na super classe fosse capaz de desenhar qualquer tipo de geometria. Em geral, teriamos uma implementação específica em cada classe:

```java
class Geometry {
        protected double x, y;
        public void draw () {
            System.out.println ("executando o método de Geometry");
        } 
        ...
        
class Circle extends Geometry {
        private double r;
        public void draw () {
            System.out.println ("executando o método de Circle");
        }
        ...

class Rectangle extends Geometry {
        private double w, h;
        public void draw () {
            System.out.println ("executando o método de Rectangle");
        }
        ...
```

Agora, o que será impresso considerando o seguinte código ?

```java
Geometry geo = new Circle();
geo.draw()
```
Considere agora uma implementação similar em C++. O que será impressso nesse caso ?

```c++
class Geometry {
    protected:
        double x, y;
    public:
        void draw ();
};

void Geometry::draw () {
    cout << "executando o método de Geometry" << endl;
}

class Circle : public Geometry{
    private:
        double r;
    public:
        void draw ();
};

void Circle::draw () {
    cout << "executando o método de Circle" << endl;
}

int main () {

    Geometry *geo = new Circle();
    geo->draw();

}
```

Para alcançarmos o mesmo resultado do Java, teriamos que declarar o método draw como virtual. Então, o compilador do C++ irá criar uma tabela virtual, para conseguir decidir em tempo de compilação qual implementação usar.

```c++
class Geometry {
    protected:
        double x, y;
    public:
        virtual void draw ();
};
```
Observe então que a ligação dinâmica não é o padrão em C++.




