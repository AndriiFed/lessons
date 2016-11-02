package jelementary;

public class Engineer {
  String name;

  public Engineer(String name) {
    this.name = name;
  }

  public void sayHello() {
    System.out.println("Hello. I'm an engineer - " + name);
  }
}
