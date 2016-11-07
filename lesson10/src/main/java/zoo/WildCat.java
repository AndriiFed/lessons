package zoo;

public abstract class WildCat implements Animal {
  public void makeNoise() {
    System.out.println("Roar!");
  }

  public void eatFood(Food food) {}
}
