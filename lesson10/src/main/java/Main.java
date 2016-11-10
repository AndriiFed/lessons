import zoo.Tiger;
import zoo.Lion;
import zoo.Bear;
import zoo.Animal;
import zoo.WildCat;
import zoo.Food;
import zoo.Nothing;

class Main {
  public static void main(String ...args) {
    //Animal animal = new Animal();
    //WildCat WildCat = new WildCat();
    Tiger tiger = new Tiger();
    Lion lion = new Lion();
    Bear bear = new Bear();
    Nothing bear2 = new Bear();
    //bear2.makeNoise(); // fails
    Bear bear3 = (Bear) bear2;
    bear3.makeNoise();

    Animal[] zoo = {tiger, bear};
    zoo[1].makeNoise();

    bear.eatFood(Food.MEAT);
    //System.err.println(Animal.PSEUDO_CONST);
  }
}
