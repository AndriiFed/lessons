package shape.example3;

public class Square implements Shape {
  private double width;

  public Square(double width) {
    this.width = width;
  }

  @Override
  public double calculateArea() {
    return width * width;
  }
}
