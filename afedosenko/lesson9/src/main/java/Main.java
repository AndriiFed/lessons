import one.A;
import one.B;
import two.BB;
import two.D;
import init.One;

public class Main {
  public static void main(final String ... args) {
    //System.out.println("Hello lesson");
    //args[0] = "qqq";

    new A();
    new B();
    new C();
    new BB();
    new D();

    BB bb = new BB();
    bb.foo();
    //bb.str = "test";
    //System.out.println(BB.CONSTANT_STRING);

    B b = new B();
    //b.foo();
    String odd = "ODD";
    if (odd.equals(Types.ODD))
    System.out.println(Types.ODD);

    One one = new One();
    One one2 = new One();

  }
}
