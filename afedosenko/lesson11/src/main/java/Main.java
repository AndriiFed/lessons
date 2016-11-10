
public class Main {
  public static void main(String ... args) {
    Animal animal = new Animal();
    Dog dog = new Dog();
    Cat cat = new Cat();

    if (animal instanceof Animal) {
      System.out.println("Animal");
    }
    if (dog instanceof Dog) {
      System.out.println("Dog");
    }
    if (cat instanceof Cat) {
      System.out.println("Cat");
    }

    

  }
}
