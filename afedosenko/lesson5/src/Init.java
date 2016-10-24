
public class Init {
    public static String staticString = "staticString";
    public String nonStaticString = "nonStaticString";

    public Init() {
      this("hh");
    }

    public Init(String str) {
      System.out.println("string");
    }

    public Init(long longInt) {

    }

    public void foo(long i) {
              System.out.println(i);
    }

}
