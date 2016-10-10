package some.program;

class FirstProgram {
    public static void main(String[] args) {
      isEven(1);
      isEven(2);
      isEven(3);
      // ....
      isEven(10);
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
