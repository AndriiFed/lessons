package zoo;

public abstract class WildCat implements  Animal {
  @Override
  public void makeNoise() {
    System.out.println("ROAR");
  }
  
  @Override
  public void eatFood(Food food) {
    //System.out.println("GROWL");
  }

}
