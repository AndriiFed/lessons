class Main {
  public static void main(String ... args) {
    LightBulb bulb = new LightBulb();
    bulb.on();

    LightBulb bulb2 = new LightBulb();
    bulb.switchBulb();

    LightBulb bulb3 = bulb;
    //boolean b = bulb.state;

    equalsWrongExample(bulb, bulb2);
    equalsWrongExample(bulb, bulb3);

    equalsAlmostCorrectExample(bulb, bulb2);

    equalsCorrectExample(bulb, bulb2);
    equalsCorrectExample(bulb, bulb);

    // ----
    String str1 = new String("test");
    String str2 = "test";
    String str3 = new String("test");
    String str4 = "test";

    if (str2 == str4)
      System.out.println("The strings are equal");
    if (str1.equals(str4))
      System.out.println("The strings are equal - 2");
  }

  public static void equalsWrongExample(LightBulb bulb1, LightBulb bulb2) {
    if (bulb1 == bulb2) {
      System.out.println("The bulbs are equal");
    } else {
      System.out.println("The bulbs are not equal");
    }
  }

  public static void equalsAlmostCorrectExample(LightBulb bulb1, LightBulb bulb2) {
    if (bulb1.equalTo(bulb2)) {
      System.out.println("The bulbs are equal");
    } else {
      System.out.println("The bulbs are not equal");
    }
  }

  public static void equalsCorrectExample(LightBulb bulb1, LightBulb bulb2) {
    if (bulb1.equals(bulb2)) {
      System.out.println("The bulbs are equal");
    } else {
      System.out.println("The bulbs are not equal");
    }
  }
}
