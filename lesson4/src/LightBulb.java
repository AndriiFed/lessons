class LightBulb {
  private boolean state;

    public void on() {
      heatTheBulb();
      state = true;
    }
    public void off() {
      state = false;
    }

    public void switchBulb() {
      state = !state;
    }

    public boolean equalTo(LightBulb bulb) {
      return state == bulb.state;
    }

      private void heatTheBulb() {
          // do smth.
      }


}
