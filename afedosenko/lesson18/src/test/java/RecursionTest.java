import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import java.util.Map;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;


public class RecursionTest {

  @Test
  public void test1() {

    // 5! = 5 * 4 * 3 * 2 * 1
    assertThat(factorial(5), is(120));
    assertThat(recursiveFactorial(5), is(120));
    assertThat(recursiveFactorial2(5), is(120));

  }

  int factorial(int n) {
    int result = 1;
    for (int i = n; i >= 1; i--) {
      result *= i;
    }
    return result;
  }

  int recursiveFactorial(int n) {
    if (n == 0) {
      return 1;
    }
    return n * recursiveFactorial(n - 1);
  }

  int recursiveFactorial2(int n, int...prevElement) {
    int p = prevElement.length != 0 ? prevElement[0] : 1;
    return (n < 1) ? p : recursiveFactorial2(n - 1, n * p);
  }


}

