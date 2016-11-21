import inner.*;
import data.*;

class Main {
  public static void main(String ...args) {
    Enclosing<Integer> enclosing = new Enclosing<>();
    Enclosing<String> enclosing2 = new Enclosing<>();
    //enclosing.new Inner().hasNext();

    Enclosing.InnerStatic.foo();
    Enclosing.InnerStatic is = new Enclosing.InnerStatic();
    is.nonStaticFoo();

    Enclosing.Inner inner = enclosing.new Inner();
    inner.foo();

    Enclosing.MyInterface.Hello hello = new Enclosing.MyInterface.Hello();
    Enclosing.InnerStatic.Hello2 hello2 = new Enclosing.InnerStatic.Hello2();

    Enclosing.MyInterface2 myInterface2 = new Enclosing.MyInterface2() {
      public void doNothing() {
        // doing nothing
      }
    };
    Enclosing.MyInterface2 myInterface3 = new Enclosing.MyInterface2() {
      public void doNothing() {
        // doing nothing
      }
    };


    class LocalClass {
      void foo() {
        System.out.println("LocalClass.foo");
      }
    }

    class LocalClass2 extends LocalClass {
      void foo() {
        System.out.println("LocalClass2.foo");
      }
    }
    LocalClass local = new LocalClass();
    local.foo();

    LocalClass local2 = new LocalClass2();
    local2.foo();

    // -------
    List<Integer> list = new ArrayList<>();
    list.add(10);
    //list.add();

    for (Integer item : list) {
      System.out.println(item);
    }

    Iterator<Integer> iter = list.iterator();
    while(iter.hasNext()) {
      System.out.println(iter.next());
    }
  }
}
