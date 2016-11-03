package two;

import one.B;

public class BB extends B {

  protected String str = "";
  public static final String CONSTANT_STRING = "CONSTANT";

  @Override
  public void foo() {
    System.out.println("BB");
  }

  public void bar() {
    //CONSTANT_STRING = "2";
  }

}
