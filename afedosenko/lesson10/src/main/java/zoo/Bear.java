package zoo;

public class Bear implements Animal, Nothing {
  @Override
  public void makeNoise() {
    System.out.println("GROWL");
  }

  @Override
  public void eatFood(Food food) {
    System.out.println(food);
  }


}
