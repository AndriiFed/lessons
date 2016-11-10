package template;

public class Foo2 extends Bar2 {
  public void createThing() {
    System.out.println("createThing");
  }
  public void configureThing() {
    System.out.println("configureThing");
  }
}

abstract class Bar2 {
  protected Bar2() {
    init();
  }
  public final void init() {
    configureThing();
    createThing();
  }

  public abstract void createThing();
  public abstract void configureThing();
}
