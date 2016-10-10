package some.program;

class FirstProgram {
    public static void main(String[] args) {
      int i = 0;
      while (true) { // infinite loop
          if (i != 5) return;
      }
      // In case of "return" above the method invokation below would cause compilation error: unreachable statement
      //System.out.println("Elvis has left the building");
    }

    public static void isEven(int i) {
      System.out.print(i);

      if (i % 2 == 0) {
          System.out.println(" is even");
      } else {
          System.out.println(" is odd");
      }
    }
}
