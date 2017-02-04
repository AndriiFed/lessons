package strategy;

public class RubberDuck extends Duck {
  public RubberDuck(FlyBehavier flybehavier) {
    super(flybehavier);
  }

  public void display() {
    System.out.println("I am Rubber");
  }

}
