package some.program;

class FirstProgram {
    public static void main(String[] args) {
      for (int i = 1; i <= 5; i++) {
          System.out.print(i);
          System.out.print(" is even? ");
          System.out.println(isEven(i));
      }

      // You can find the operator precedence table there https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html
      System.out.println(2 + 2 * 2);
      System.out.println((2 + 2) * 2);

    }

    public static boolean isEven(int i) {
      return (i % 2 == 0);
    }
}
