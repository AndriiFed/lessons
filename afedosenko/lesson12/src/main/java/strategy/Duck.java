package strategy;

abstract public class Duck {
  //private String name;
  private FlyBehavier flybehavier;

  public Duck(FlyBehavier flybehavier) {
    this.flybehavier = flybehavier;
  }
  abstract public void display();

  public void quack() {
    System.out.println("Quack-Quack!");
  }

  public void swim() {
  }

  public void fly() {
    flybehavier.fly();
  }

}
