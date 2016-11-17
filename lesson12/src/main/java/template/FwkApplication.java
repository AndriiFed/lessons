package template;

abstract public class FwkApplication {
  private boolean run = true;

  final public void run() {
    configure();
    while (run) {
      idle();
      //---
      if (counter == 10) run = false;
      counter++;
      // ----
    }
    destroy();
  }

  public abstract void configure();
  public abstract void destroy();

  private int counter = 0;

  public abstract void idle();
}
