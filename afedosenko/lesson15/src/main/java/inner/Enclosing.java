package inner;

public class Enclosing<T> {
    int first;
    T tmp;

    interface  MyInterface {
        class Hello {}
    }

    public interface  MyInterface2 {
        void doNothing();
    }

    public class Inner<T> {
        /* Inner (T t) {

        }
*/
        public void hasNext() {
        //first = 10;
          //tmp = new T();
      }

      int first;
      static final int staticInt = 0;

      private void foo() {

          this.first = 10;
          Enclosing.this.first = 20;
      }
    }

    private static int sInt = 0;
    //static T var; //not work

    public static void esFoo() {
        System.out.println("esFoo");
        System.out.println(InnerStatic.isInt);
    }

    public static class InnerStatic {
        static int isInt = 100;
        int nonStatic = 1;

        public static void foo() {
          System.out.println("sInt: " + sInt);
          sInt = 10;
          System.out.println("sInt: " + sInt);
        }

    }
}

