import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import strategy.*;

public class MainTest {
  private ShoppingCart cart;

  @Before
  public void setUp() {
    cart = new ShoppingCart();
    cart.addBook("HEAD First DP", 30.0);
    cart.addBook("HEAD First JAVA", 30.0);
    cart.addBook("HEAD First dummies", 20.0);
  }

  @Test
  public void test_api() {
    ShoppingCart cart = new ShoppingCart();
    cart.addBook("HEAD First DP", 30.0);
    cart.addBook("HEAD First JAVA", 30.0);
    cart.addBook("HEAD First dummies", 20.0);

    cart.pay(new PaymentStrategy() {
      public void pay(double total) {
      //
      }
    });
  }

  @Test
  public void paymentStrategy_payMethod_shouldBeCalled_whenCart() {
    boolean[] callAttempt = {false};
    cart.pay(new PaymentStrategy() {
      public void pay(double total) {
        callAttempt[0] = true;
      }

    });

    assertThat(callAttempt[0], is(true));
  }

  @Test
  public void paymentStrategy_payMethod_shouldBeCalled_whenCartTotal() {
    double[] totalValue = {0.0};
    cart.pay(new PaymentStrategy() {
      public void pay(double total) {
        totalValue[0] = total;
      }
    });

    assertThat(totalValue[0], is(30.0 + 30.0 + 20.0));
  }

  @Test
  public void payPal_test() {
    cart.pay(new PaypalPaymentStrategy("qw@qw.qw", "Books", 100.00));
  }

}
