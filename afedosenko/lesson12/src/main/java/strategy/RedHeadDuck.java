package strategy;

public class RedHeadDuck extends Duck implements Flyable {
  public RedHeadDuck() {
  }

  public void fly() {
    System.out.println("I belive I can fly!");
  }

  public void display() {
    System.out.println("I am readHead");
  }
}
