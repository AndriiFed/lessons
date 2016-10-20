package some.program;

class AnotherProgram {
    public static void main(String[] args) {
      Object obj = new Object();
      String str = "hello";

      System.out.println("hello".length());
      System.out.println(str.substring(1));

      System.out.println("Size is " + args.length);

      for (int i = 0; i < args.length; i++) {
        System.out.println(args[i]);
      }
  }
}
