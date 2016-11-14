package template;

abstract public class  FwkApplication {
  public boolean run = true;
  int counter = 0;

  public  void run() {
    configure();
    while (run) {
      idle();
      if (counter == 10)
        run = false;
        counter++;
    }
    destroy();
  }

  abstract public void configure();
  abstract public void destroy();
  abstract public void idle();

}
