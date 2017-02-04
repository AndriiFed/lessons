package template;

public class Foo2 extends Bar2 {
  public void createThing() {
    System.out.println("Create thing");
  }
  public void configureThing() {
    System.out.println("Configure thing");
  }
}
abstract class Bar2 {
  public final void init() {
    createThing();
    configureThing();
  }
  public abstract void createThing();
  public void configureThing() {
    System.out.println("Configure thing in base class");
  }
}
