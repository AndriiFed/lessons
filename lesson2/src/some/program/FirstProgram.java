package some.program;

class FirstProgram {
    public static void main(String[] args) {
      short shortVar = 0; // 2 bytes
      int integerVar = 0; // 4 bytes
      long longValue = 0l; // 8 bytes

      byte byteVar = 0; // 1 byte

      float floatVar = 0.0f; // 4 bytes
      double doubleVar = 0.0d; // 8 bytes

      char charVar = '\u0000'; // 2 byte - unicode in UTF-16

      boolean booleanVar = false; // not defined by the specification. Depends on JVM implementation

      Object obj = null;

      String[] arr = {"I'm a part of array", "I'm the same egg here"};

      String str = "I'm a string";
      String str2 = new String("Hello. I'm a string as well as my sister above");
    }

    public static boolean isEven(int i) {
      return (i % 2 == 0);
    }
}
