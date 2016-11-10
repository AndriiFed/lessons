import shape.example1.Shape;

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

    Shape shape = new Shape(2, 4, 5);
    System.out.format("%nAREAS OF SHAPES:%n");
    System.out.format("%.2f %n", shape.calculateArea(Shape.ShapeType.SQUARE));
    System.out.format("%.2f %n", shape.calculateArea(Shape.ShapeType.RECTANGLE));
    System.out.format("%.2f %n", shape.calculateArea(Shape.ShapeType.CIRCLE));
  }
}
