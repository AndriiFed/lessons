import zoo.Animal;
import zoo.Bear;
import zoo.Tiger;
import zoo.Lion;
import zoo.WildCat;
import zoo.Food;
import zoo.Nothing;

public class Main {
  public static void main(final String ... args) {
    //Animal animal = new Animal();
    Bear bear = new Bear();
    Tiger tiger = new Tiger();
    Lion lion = new Lion();

    Animal[] zoo = {bear, tiger, lion};
    for (int i = 0; i < zoo.length; i++) {
      zoo[i].makeNoise();
    }

    //bear.makeNoise();
    System.out.println(Animal.PSEUDO_CONST);
    bear.eatFood(Food.MEAT);

    Nothing bear2 = new Bear();
    Bear bear3 = (Bear) bear2;
    bear3.makeNoise();

  }
}
