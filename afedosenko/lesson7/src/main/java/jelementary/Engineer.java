package jelementary;

public class Engineer {
  String name;
  String lastname;
  public Engineer(String name) {
    this.name = name;
  }
  public static void main(String[] args) {
    System.out.println("Hello Engineer!");
  }

  public void sayHello() {
    System.out.println("Hello. i am an engineer - " + name);
  }
}
