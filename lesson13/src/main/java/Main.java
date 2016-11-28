<<<<<<< HEAD
import template.Application;
import template.Application2;
import template.FwkApplication;

import comparable.Student;

import strategy.Duck;
import strategy.RedheadDuck;
import strategy.RubberDuck;

import java.util.Arrays;

class Main {
  public static void main(String ...args) {
    Application app = new Application();
    app.run();

    FwkApplication app2 = new Application2();
    app2.run();

    Student st1 = new Student("john", 10);
    Student st2 = new Student("jane", 20);
    Student st3 = new Student("joe", 30);

    Student[] students = {st1, st2, st3};
    int idx = Arrays.binarySearch(students, st2);
    System.out.println(students[idx]);

    System.out.println(st2.compareTo(st3));

    Duck duck1 = new RedheadDuck("RedHead");
    duck1.display();
    duck1.fly();

    Duck rubberDuck = new RubberDuck("Rubber duck");
    rubberDuck.display();
    rubberDuck.fly();
=======
import data.Bag;

class Main {
  public static void main(String ...args) {
    Bag<String> bag = new Bag<>();
    Bag<Integer> bag2 = new Bag<>();
    bag2.add(new Integer(10));
    bag2.add(20);
    bag2.add(30);
    //bag2.add("2111"); fails

    //Bag.Node<Integer> bnode = new Bag.Node();
    //bag.new Node<>(); // works
    //bag.new Node<String>(); // works
    //bag.new Node<Integer>(); // fails
    //new Bag().new Node();
    System.out.println("bag2 size: " + bag2.size());

    Bag.Iterator bagIterator = bag2.iterator();
    while(bagIterator.hasNext()) {
      System.out.println("bag2 contains: " + bagIterator.next());
    }
>>>>>>> aa1cc001ef647073b8d3f0f17c68f853f8a3cb72
  }
}
