package shape.example1;

public class Shape {
  private double width = 10.0;
  private double height = 5.0;
  private double radius = 10.0;

  public static final int SQUARE = 1;
  public static final int RECTANGLE = 2;
  public static final int CIRCLE = 3;

  public double calculateArea(int shape) {
      double area = 0.0;
      switch (shape) {
        case SQUARE: area = width * width; break;
        case RECTANGLE: area = width * height; break;
        case CIRCLE: area = Math.PI * radius * radius; break;

        default: area = 0.0;
      }

      return area;
  }
}
