//import shape.example1.Shape;
import shape.example3.*;
import template.Foo;
import template.Foo2;


public class Main {
  public static void main(String ... args) {
    Animal animal = new Animal();
    Dog dog = new Dog();
    Cat cat = new Cat();

    Cat catNull = null;

    if (animal instanceof Animal) {
      System.out.println("Animal");
    }
    if (dog instanceof Dog) {
      System.out.println("Dog");
    }
    if (cat instanceof Cat) {
      System.out.println("Cat");
    }

    if (catNull instanceof Cat) {
      System.out.println("A");
    }

    /* Shape shape = new Shape(2, 4, 5);
    System.out.format("%nAREAS OF SHAPES:%n");
    System.out.format("%.2f %n", shape.calculateArea(Shape.ShapeType.SQUARE));
    System.out.format("%.2f %n", shape.calculateArea(Shape.ShapeType.RECTANGLE));
    System.out.format("%.2f %n", shape.calculateArea(Shape.ShapeType.CIRCLE));
    */

    Shape circle = new Circle(5.0);
    System.out.format("%.2f %n", circle.calculateArea());

    Shape square = new Square(10.0);
    System.out.format("%.2f %n", square.calculateArea());

    Shape rectangle = new Rectangle(10.0, 20.0);
    System.out.format("%.2f %n", rectangle.calculateArea());

    Shape[] shapes = {new Circle(5.0), new Square(6.0), new Rectangle(10.0, 2.0)};
    for (Shape shape : shapes) {
      System.out.format("%.2f %n", shape.calculateArea());
    }

    Foo foo = new Foo();
    Foo2 foo2 = new Foo2();

  }
}
