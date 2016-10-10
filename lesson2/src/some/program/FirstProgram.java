package some.program;

class FirstProgram {
    public static void main(String[] args) {
      for (int i = 1; i <= 5; i++) {
          System.out.print(i);
          System.out.print(" is even? ");
          System.out.println(isEven(i));
      }
    }

    public static boolean isEven(int i) {
      if (i % 2 == 0) {
          return true;
      } else {
          return false;
      }
    }
}
