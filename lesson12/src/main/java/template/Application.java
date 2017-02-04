package template;

public class Application {
  private boolean run = true;

  public void run() {
    configure();
    while (run) {
      idle();
    }
    destroy();
  }

  public void configure() {
    System.out.println("Configuration");
  }

  public void destroy() {
    System.out.println("Destroy");
  }

  private int counter = 0;

  public void idle() {
    System.out.println("idle");
    if (counter == 10) run = false;
    counter++;
  }
}
