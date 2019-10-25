## Classes abstratas e interfaces

## Contexto

- Suppose we plan to implement a number of shape classes: Rectangle, Square, Ellipse, Triangle, and so on. 
- We can give these shape classes our two basic area( ) and circumference() methods. 
- We want the Shape class to encapsulate whatever features all our shapes have in common (e.g., the area() and circumference( ) methods). But our generic Shape class doesn't represent any real kind of shape, so it cannot defne useful implementations of the methods. 
- Java handles this situation with abstract methods and classes.


## Método abstrato


- Java lets us define a method without implementing it by declaring the method with the abstract modifer. 
- An abstract method has no body; it simply has a signature definition followed by a semicolon 
- An abstract method in Java is something like a pure virtual function in C++ (i.e., a virtual func- tion that is declared = 0). In C++, a class that contains a pure virtual function is called an abstract class and cannot be instantiated. The same is true of Java classes that contain abstract methods.
- static, private, and final methods cannot be abstract since these types of methods cannot be overridden by a subclass. 


## Classe abstrata


- Any class with an abstract method is automatically abstract itself and must be declared as such. 
- An abstract class cannot be instantiated. 
- A subclass of an abstract class can be instantiated only if it overrides each of the abstract methods of its superclass and provides an implementation (i.e., a method body) for all of them. Such a class is often called a concrete subclass, to emphasize the fact that it is not abstract. 
- If a subclass of an abstract class does not implement all the abstract methods it inherits, that subclass is itself abstract and must be declared as such.
- A final class cannot contain any abstract methods, dado que ela não pode ter subclasses.
- A class can be declared abstract even if it does not actually have any abstract methods. Declaring such a class abstract indicates that the implementation is somehow incomplete and is meant to serve as a superclass for one or more sub- classes that complete the implementation. Such a class cannot be instantiated.

Usando estes conceitos, a classe shape seria abstrata:

```java
    public abstract class Shape {
            public abstract double area(); // Abstract methods: note 
            public abstract double circumference(); // semicolon instead of body.
    }
```
Então, poderiamos criar as classes concretas Circle:

```java
    class Circle extends Shape {
            public static final double PI = 3.14159265358979323846;
            protected double r;
            public Circle(double r) { this.r = r; }
            public double getRadius() { return r; }
            public double area() { return PI*r*r; }
            public double circumference() { return 2*PI*r; }
    
    }
```

e Rectangle

```java
    class Rectangle extends Shape {
            protected double w, h;
            public Rectangle(double w, double h) {
                    this.w = w; 
                    this.h = h; 
            }
            public double getWidth() { return w; }
            public double getHeight() { return h; }
            public double area() { return w*h; }
            public double circumference() { return 2*(w + h); }
    }
```

Então, poderiamos calcular a área total de uma coleção de formas, indepententemente de qual o subtipo. Observer que aqui também é um bom exemplo de polimorfismo.

```java
    Shape[] shapes = new Shape[3]; 
    shapes[0] = new Circle(2.0); 
    shapes[1] = new Rectangle(1.0, 3.0); 
    shapes[2] = new Rectangle(4.0, 2.0);
    double total_area = 0;
    for(int i = 0; i < shapes.length; i++)
            total_area += shapes[i].area();
```

“Subclasses of Shape can be assigned to elements of an array of Shape. No cast is necessary. You can invoke the area() and circumference() methods for any Shape object, even though the Shape class does not define a body for these methods. When you do this, the method to be invoked is found using dynamic method lookup, so the area of a circle is computed using the method defined by Circle, and the area of a rectangle is computed using the method defined by Rectangle.”


## Interfaces

As its name implies, an interface specifies only an API: in general all of its methods are abstract and have no bodies.  A partir do Java 8, as interfaces podem possuir métodos default, que são similares a métodos concretos.

It is not possible to directly instantiate an interface and create a member of the interface type. Instead, a class must implement the interface to provide the necessary method bodies. 

Interfaces provide a limited but very powerful alternative to multiple inheritance.* Classes in Java can inherit members from only a single superclass, but they can implement any number of interfaces.

An interface definition is much like a class definition in which all the methods are abstract Ior default) and the keyword class has been replaced with interface. For example, the following code shows the definition of an interface named Centered.

```java
    public interface Centered {
            void setCenter(double x, double y); 
            double getCenterX();
            double getCenterY();
    }
```

All methods of an interface are implicitly abstract and must have a semicolon in place of a method body. The abstract modifier is allowed but, by convention, is usually omitted. Caso exista uma implementação, será necessário explicitar usando a palavra chave default.

Since static methods may not be abstract, the methods of an interface may not be declared static.

An interface defines a public API. All members of an interface are implicitly public, and it is conventional to omit the unnecessary public modifier. It is an error to define a protected or private method in an interface.

An interface may not define any instance fields. Fields are an implementation detail, and an interface is a pure specification without any implementation. The only fields allowed in an interface definition are constants that are declared both static and final.

An interface cannot be instantiated, so it does not define a constructor.

If a class implements an interface but does not provide an implementation for every interface method, it inherits those unimplemented abstract methods from the interface and must itself be declared abstract.

If a class implements more than one interface, it must implement every method of each interface it implements (or be declared abstract).

The following code shows how we can define a CenteredRectangle class that extends the Rectangle class from earlier and implements our Centered interface.

```java
    public class CenteredRectangle extends Rectangle implements Centered {
            private double cx, cy;
            public CenteredRectangle(double cx, double cy, double w, double h) {
                    super(w, h); 
                    this.cx = cx; 
                    this.cy = cy;
            }
            // provide implementations of all the Centered methods. 
            public void setCenter(double x, double y) { cx = x; cy = y; } 
            public double getCenterX() { return cx; }
            public double getCenterY() { return cy; }
    }
```
Podemos então, testar as classes:

```java
    Shape[] shapes = new Shape[3]; // Create an array to hold shapes
    // Create some centered shapes, and store them in the Shape[] 
    // No cast necessary: these are all widening conversions 
    shapes[0] = new CenteredCircle(1.0, 1.0, 1.0);
    shapes[1] = new CenteredSquare(2.5, 2, 3);
    shapes[2] = new CenteredRectangle(2.3, 4.5, 3, 4);
    // Compute average area of the shapes and average distance from the origin 
    double totalArea = 0;
    double totalDistance = 0;
    for(int i = 0; i < shapes.length; i++) {
            totalArea += shapes[i].area(); // Compute the area of the shapes 
            if (shapes[i] instanceof Centered) { 
                    Centered c = (Centered) shapes[i];  // required cast.
                    double cx = c.getCenterX();
                    double cy = c.getCenterY(); 
                    totalDistance += Math.sqrt(cx*cx + cy*cy) 
            }
    }
    System.out.println("Average area: " + totalArea/shapes.length); 
    System.out.println("Average distance: " + totalDistance/shapes.length);
```

(algumas considerações sobre Interfaces)
Até o Java 8, as interfaces não podiam ter métodos concretos. E isso levava a um problema, que era  quando voce adicionava um novo método a sua interface, quebrava-se todo o sistema. Dado que todas as classes que implementavam aquela interface precisa escreve um codigo novo. O que não acontecia com as classes abstratas, já que bastaria adicionar um método concreto, com alguma implementação, até mesmo que lançasse uma exceção.  Com o Java 8, as interfaces passaram a ter métodos defaults, que na prática são métodos concretos e que tem implementação. Com isso, uma interface pode evoluir adicionando métodos default, o que ocorreu com a interface List, do Java.utils.


Observe, que este era o mesmo caso do exemplo usado para demonstrar o polimorfismo. Nele qual seria a implementação do método *draw* na classe *Geometry* ?  Como não existe um reuso do método draw nas subclasses, ou seja, cada uma reimplementa o método. Então, em casos como estes o mais comum e declarar o método draw como abstrato, e consequentemente a classe tambem como abstrata:


```java
abstract class Geometry {
        protected double x, y;
        abstract public void draw () ;
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

## Atividades


https://www.dropbox.com/s/qm8x8npxziloll9/herancas_interfaces.pdf?dl=0