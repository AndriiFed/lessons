package strategy;

public class FlyNoWay implements FlyBehavior {
  public void fly() {
    System.out.println("I'm not a flying duck. Sorry");
  }
}
