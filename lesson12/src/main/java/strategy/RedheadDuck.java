package strategy;

public class RedheadDuck extends Duck {
  public RedheadDuck(String name) {
    super(new FlyWithWings());
  }

  public void display() {
    System.out.println("I'm redhead duck");
  }
}
