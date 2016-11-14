package comparable;

public class Student implements Comparable {
  private int score;
  private String name;

  public Student(String name, int score) {
    this.name = name;
    this.score = score;
  }

  @Override
  public String toString() {
    return "Name: " + name + "; Score: " + score;
  }

  public int compareTo(Object o) {
    Student other = (Student)o;
    return this.score - other.score;
  }

}
