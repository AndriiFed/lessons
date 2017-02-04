package shape.example3;

public class Square implements Shape {
  private double width;

  public Square(double width) {
    this.width = width;
  }

  public double getWidth() {
    return width;
  }

  public double calculateArea() {
    return width * width;
  }

}
