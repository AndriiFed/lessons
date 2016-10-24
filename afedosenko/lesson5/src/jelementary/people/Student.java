package jelementary.people;

public class Student {
  String name;
  int age;
  int rating;

public Student(String name, int age, int rating) {
    this.name = name;
    this.age = age;
    this.rating = rating;
  }

  public String toString() {
    return name + ", " + age + " years old," + " rating: " + rating;
  }

  public static void main(String args) {
    Student st1 = new Student("Vasil Pupkin", 35, 1);
    System.out.println(st1.toString());

  }


}
