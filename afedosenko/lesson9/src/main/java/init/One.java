package init;

public class One {
  private Printer p0 = new Printer("One Printer p0");
  private Printer p1 = new Printer("One Printer p1");
  private static Printer p2 = new Printer("One Static Printer p2");

  private static String str = createString();
  private String str2 = createString2();

  // initializer
  {
    new Printer("One - initializer");
    //System.out.println("init hello");
  }

  // static initializer
  static {
    new Printer("One static{} initializer");
    System.out.println(str);
  }

  // Constructor
  public One() {
    new Printer("One Conctructor");
        System.out.println(str2);
  }

  private static String createString() {
    return "str Hello init";
  }

  private final String createString2() {
    return "str Hello2 init";
  }
}
