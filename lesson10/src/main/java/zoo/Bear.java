package zoo;

//import Animal;

public class Bear implements Animal, Nothing {
  public void makeNoise() {
    System.out.println("Growl!");
  }

  public void eatFood(Food food) {}
}
