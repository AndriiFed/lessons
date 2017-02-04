package strategy;

public class RubberDuck extends Duck {
  public RubberDuck(String name) {
    super(new FlyNoWay());
  }

  public void display() {
    System.out.println("I'm rubber duck");
  }
}
