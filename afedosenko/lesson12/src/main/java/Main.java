import template.Application;
import template.Application2;

import comparable.Student;

import java.util.Arrays;

class Main {

  public static void main(String[] args) {
    Application app = new Application();
    //app.run();

    Application2 app2 = new Application2();
    //app2.run();

    Student st1 = new Student("john1", 12);
    Student st2 = new Student("john2", 13);
    Student st3 = new Student("john3", 14);

    Student[] students = {st1, st2, st3};
    int idx = Arrays.binarySearch(students, st2);
    System.out.println(students[idx]);
  }

}
