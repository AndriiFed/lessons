import org.junit.Test;
<<<<<<< HEAD

import static org.junit.Assert.*;

public class MainTest {
  @Test
  public void test_nothing() {

    assertEquals(true, true);
  }



=======
import org.junit.Before;
import org.junit.Ignore;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import strategy.*;

public class MainTest {
  private ShoppingCart cart;

  @Before
  public void setUp() {
    cart = new ShoppingCart();
    cart.addBook("Head First Design Patterns", 30.0);
    cart.addBook("Head First Java", 30.0);
    cart.addBook("Java for dummies", 20.0);
  }

  @Test
  public void test_api() {
    ShoppingCart cart = new ShoppingCart();
    cart.addBook("Head First Design Patterns", 30.0);
    cart.addBook("Head First Java", 30.0);
    cart.addBook("Java for dummies", 20.0);

    cart.pay(new PaymentStrategy() {
      public void pay(double total) {
        // nothing is here
      }
    });
  }

  @Test
  public void payPalPaymentStrategy_api() {
    cart.pay(new PayPalPaymentStrategy("email@example.com", "Books", 100.00));
  }

  @Test
  public void paymentStrategy_payMethod_shouldBeCalled_whenCartPayMethodIsCalled() {
    boolean[] callAttempt = {false};
    cart.pay(new PaymentStrategy() {
      public void pay(double total) {
        callAttempt[0] = true;
      }
    });

    assertThat(callAttempt[0], is(true));
  }

  @Test
  public void paymentStrategy_shouldRecieveCorrectTotalValue() {
    double[] totalValue = {0.0};
    cart.pay(new PaymentStrategy() {
      public void pay(double total) {
        totalValue[0] = total;
      }
    });

    assertThat(totalValue[0], is(30.0 + 30.0 + 20.0));
  }
>>>>>>> aa1cc001ef647073b8d3f0f17c68f853f8a3cb72
}
