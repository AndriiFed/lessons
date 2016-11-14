package shape.example2;

public class Shape {
  public double calculateArea(Object obj) {
    double area = 0.0;

    if (obj instanceof Circle) {
      Circle circle = (Circle) obj;
      area = circle.getRadius() * circle.getRadius() * Math.PI;
    } else if (obj instanceof Square) {
      area = 0.0;
    } else if (obj instanceof Rectangle) {
      area = 0.0;
    }

    return area;
  }
}
