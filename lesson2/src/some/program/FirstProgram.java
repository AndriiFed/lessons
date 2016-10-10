package some.program;

class FirstProgram {
    public static void main(String[] args) {
      do {
        isEven(10);
      } while (false); // the loop condition is false, however we call the isEven methos
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
