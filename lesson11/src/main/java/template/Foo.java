package template;

public class Foo extends Bar {
  int i = 10;

  public Foo() {
    super();
  }

  protected void init() {
    System.out.println("Foo.init(); i = " + i);
  }
}

abstract class Bar {
  protected Bar() {
    init();
  }

  protected abstract void init();
}
