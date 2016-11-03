package two;

import one.B;

public class BB extends B {
  protected String str = "";

  public static final String CONSTANT_STRING = "1";
  public final String CONSTANT_STRING2;

  public BB() {
    CONSTANT_STRING2 = buzz();
  }

  @Override
  public void foo() {
    System.out.println("BB");
    //CONSTANT_STRING = "2";
  }

  private String buzz() {
    return "2";
  }

  public void bar() {

  }
}
