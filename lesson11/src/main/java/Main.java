//import shape.example1.Shape;
//import shape.example2.Shape;
//import shape.example2.Circle;
import shape.example3.Shape;
import shape.example3.Circle;
import shape.example3.Square;
import shape.example3.Rectangle;

import template.Foo;
import template.Foo2;

class Main {
  public static void main(String ...args) {
    System.out.println("Lesson 11");

    instanceOfExample();

    //Shape shape = new Shape();
    //System.out.println(shape.calculateArea(new Circle(10.0)));

    Shape[] shapes = { new Circle(5.0), new Square(4.0), new Rectangle(10.0, 2.0)};
    for (Shape shape : shapes) {
      System.out.println(shape.calculateArea());
    }

    //------ Template method -------
    Foo foo = new Foo();
    Foo2 foo2 = new Foo2();
    foo2.init();
  }

  private static void instanceOfExample() {
    Animal animal = new Animal();
    Dog dog = new Dog();
    Cat cat = new Cat();

  //  animal = dog;

    Cat catNull = null;

    if (dog instanceof Dog) {
      System.out.println("Dog");
    }

    /*if (dog instanceof cat) {
      System.out.println("wrong");
    }*/


    if (animal instanceof Animal) {
      System.out.println("Dog2");
    } else {
      System.out.println("not a Dog");
    }

    if (catNull instanceof Animal) {
      System.out.println("A");
    }
  }
}
