package some.program;

class FirstProgram {
    public static void main(String[] args) {
      for (int i = 5; i > 0; i--) {
          isEven(i);
      }
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
