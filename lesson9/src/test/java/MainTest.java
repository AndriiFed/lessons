import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {
  @Test
  public void test_nothing() {
    new Hello();
    assertEquals(true, true);
  }

  class Hello {}
}
