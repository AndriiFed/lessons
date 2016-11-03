import one.A;
import one.B;
import two.BB;
import two.D;

public class Main {
  public static void main(String...args) {
    //System.out.println("Hello lesson");
    new A();
    new B();
    new C();
    new BB();
    new D();

    BB bb = new BB();
    bb.foo();
    //bb.str = "test";
    System.out.println(BB.CONSTANT_STRING);
    //print(BB.CONSTANT_STRING);
    B b = new B();
    //b.foo();
  }
}
