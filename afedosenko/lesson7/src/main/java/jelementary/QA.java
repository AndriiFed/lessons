package jelementary;

public class QA extends Engineer {
  public QA(String name) {
    super(name);
  }
  @Override
  public void sayHello() {
    System.out.println("Hello. i am an QA engineer - " + name);
  }
}
