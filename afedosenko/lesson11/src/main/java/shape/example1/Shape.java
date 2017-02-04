package shape.example1;

public class Shape {
  private double width;
  private double height;
  private double radius;

  public static enum ShapeType {
    SQUARE, RECTANGLE, CIRCLE
  }

  //public static int SQUARE = 1;
  public Shape(double width, double height, double radius) {
    this.width = width;
    this.height = height;
    this.radius = radius;
  }
  public double calculateArea(ShapeType shape) {
    double area = 0.0;
    switch (shape) {
      case SQUARE: area = width * width;
        break;
      case RECTANGLE: area = width * height;
        break;
      case CIRCLE: area = Math.PI * radius * radius;
        break;
      default: area = 0.0;
    }
    return area;
  }

}
