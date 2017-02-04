package inner;

public class Enclosing<T> {
  int first;
  T tmp;

  public interface MyInterface {
    public class Hello {}
  }
  public static interface MyInterface2 {
      void doNothing();
  }

  public class Inner {
    /*public Inner(T t) {

    }*/
    int first;

    static final int staticInt = 0;

    //public static void staticMethod() {} // won't compile

    public void foo() {
      this.first = 10;
      Enclosing.this.first = 20;

      //Enclosing.this;

    }
  }

  private static int sInt = 0;
  //static T var; // won't compile
  public static void esFoo() {
    System.out.println("esFoo");
    System.out.println(InnerStatic.isInt);
  }

  public static class InnerStatic {
    public static class Hello2 {}

    //int isInt = 100; // won't compile
    private static int isInt = 100;

    int nonStaticInt = 200;
    public void nonStaticFoo() {
      System.out.println("nonStaticFoo" + nonStaticInt);
    }

    public static void foo() {
        System.out.println("sInt: " + sInt);
        sInt = 10;
        System.out.println("sInt: " + sInt);
        esFoo();
    }
  }
}
