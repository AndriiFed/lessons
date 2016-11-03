package two;

import one.B;

public class BB extends B {

  protected String str = "";
  public final String CONSTANT_STRING;

  public BB() {
    CONSTANT_STRING = "CONSTANT2";
  }

  @Override
  public void foo() {
    System.out.println("BB");
  }

  public void bar() {
    //CONSTANT_STRING = "2";
  }

}
