package some.program;

class FirstProgram {
    public static void main(String[] args) {
      int i = 1;

      while (i <= 5) {
        isEven(i);
        i++;
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
