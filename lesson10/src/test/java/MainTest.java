import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {
  @Test
  public void test_nothing() {

    assertEquals(true, true);
  }

  @Test
  public void test_casting() {
      AnimalClass animal = new AnimalClass();
      Cat cat = new Cat();
      Dog dog = new Dog();

      animal = cat; // works fine


      //dog = (Dog) animal; fails in runtime
      //cat = dog;  // fails
  }


}
