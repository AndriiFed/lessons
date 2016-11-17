package strategy;

public class ShoppingCart {
  private double total;
  public void addBook(String title, double bookPrice){
    total += bookPrice;
  }

  public void pay(PaymentStrategy paymentStrategy) {
    paymentStrategy.pay(total);
  }
}
