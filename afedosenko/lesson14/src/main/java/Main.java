import inner.*;
import data.*;


class Main {

  public static void main(String... args) {
    //System.out.println("HELLO");

    Enclosing<Integer> enclosing = new Enclosing<>();
    //enclosing.new Inner().hasNext();

    Enclosing.InnerStatic.foo();
    Enclosing.InnerStatic is = new Enclosing.InnerStatic();
//
    //Enclosing.Inner inner = enclosing.new Inner();
    //inner.foo();

    Enclosing.MyInterface2 myInt = new Enclosing.MyInterface2() {
      public void doNothing() {

      }
    };

    class LocalClass {

    }

    LocalClass local = new LocalClass();

    // ------
    List<Integer> list = new ArrayList<>();
    //list.add(10);
    //System.out.println(list.get(0));

    //for ()


  }
}





