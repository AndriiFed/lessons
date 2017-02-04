package comparable;

public class Student implements Comparable<Student> {
  private int score;
  private String name;

  public Student(String name, int score) {
    this.name = name;
    this.score = score;
  }

  public int compareTo(Student other) {
    //Student other = (Student)o;
    return 0; // not-implemented actually. See http://grepcode.com/file/repository.grepcode.com/java/root/jdk/openjdk/8u40-b25/java/lang/Comparable.java
  }

  public String toString() {
    return "Name: " + name + "; Score: " + score;
  }
}
