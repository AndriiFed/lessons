import jelementary.Engineer;
import jelementary.QA;
import jelementary.Developer;

public class Library {
    public boolean someLibraryMethod() {
        return true;
    }
    public static void main(String ... args) {
      //System.out.println("===== Hello Gradle! =====");
      Engineer eng = new Engineer("Andrii");
      eng.sayHello();

      QA qaeng = new QA("qa eng");
      qaeng.sayHello();

    }
}
