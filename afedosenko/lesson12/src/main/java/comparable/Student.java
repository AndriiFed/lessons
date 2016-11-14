package comparable;

public class Student implements Comparable<Student> {
  private int score;
  private String name;

  public Student(String name, int score) {
    this.name = name;
    this.score = score;
  }

  public String toString() {
    return "Name: " + name + "; Score: " + score;
  }

  public int compareTo(Student other) {
    //Student other = (Student)o;
    return this.score - other.score;
  }

}
