package some.program;

class FirstProgram {
    public static void main(String[] args) {
      int i = 0;
      while (true) { // infinite loop
          if (i != 5) break; // "continue" keyword would the current iteration and goes back to the condition check. In Java, if we replace "break" to "continue", it will coause compilation error 
          i++;
      }
      System.out.println("Elvis has left the building");
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
