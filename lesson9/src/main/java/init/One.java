package init;

public class One {
  private Printer p0 = new Printer("One - field 0");
  private Printer p1 = new Printer("One - field");
  private static Printer p2 = new Printer("One - static field");

  private static String str = createString();
  private String str2 = createString2();

  {
    new Printer("One - initializer");
    System.out.println(str2);
  }

  static {
      new Printer("One - static initializer");
      System.out.println("One str - " + str);
  }

  public One() {
    new Printer("One constructor");
  }

  private static String createString() {
    return "Hello";
  }

  private final String createString2() {
    return "Hello2";
  }
}
