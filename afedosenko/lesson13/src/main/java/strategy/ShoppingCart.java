package strategy;

public class ShoppingCart {

  private String name;
  private double price;
  private double total;

  public void addBook(String name, double bookPrice) {
    total += bookPrice;
  }

  public void pay(PaymentStrategy paymentStrategy) {
    paymentStrategy.pay(total);
  }

}
