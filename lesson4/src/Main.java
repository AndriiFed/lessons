class Main {
  public static void main(String ... args) {
    LightBulb bulb = new LightBulb();
    bulb.on();

    LightBulb bulb2 = new LightBulb();
    bulb.switchBulb();

    //boolean b = bulb.state;

    if (bulb.equalTo(bulb2)) {
      System.out.println("The bulbs are equal");
    } else {
      System.out.println("The bulbs are not equal");
    }
  }
}
