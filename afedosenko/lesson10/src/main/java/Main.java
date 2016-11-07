import zoo.Animal;
import zoo.Bear;
import zoo.Tiger;
import zoo.Lion;

public class Main {
  public static void main(final String ... args) {
    //Animal animal = new Animal();
    Bear bear = new Bear();
    Tiger tiger = new Tiger();
    Lion lion = new Lion();
    Bear bear2 = new Bear();

    Animal[] zoo = {bear, tiger, lion, bear2};
    for (int i = 0; i < zoo.length; i++) {
      zoo[i].makeNoise();
    }

    //bear.makeNoise();

  }
}
