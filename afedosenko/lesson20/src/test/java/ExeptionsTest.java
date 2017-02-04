import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class ExeptionsTest {




  @Test
  public void test1() throws Exception {

    try {
      foo();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    //foo();  // fails

  }

  private void foo() throws Exception {
    throw new Exception("Hello Exception");
  }

  @Test
  public void test2() throws Exception {

    try {
      bar();

    } catch (MyException2 e) {
      System.out.println(e.getClass().getCanonicalName());
    } catch (MyException e) {
      System.out.println(e.getClass().getCanonicalName());
    } /*catch (RuntimeException e) {
      System.out.println(e.getClass().getCanonicalName());
    }*/ finally {
      close();
    }

  }

  private void close() {
    // nothing;
  }

  private static class MyException extends RuntimeException {

  }

  private static class MyException2 extends MyException {

  }

  private void bar() {
    throw new MyException();
  }

}
