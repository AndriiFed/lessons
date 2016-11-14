package template;

public class  Application {
  public boolean run = true;

  public  void run() {
    configure();
    while (run) {
      idle();
    }
    destroy();
  }

  public void configure() {
    System.out.println("Configure()");
  }

  public void destroy() {
    System.out.println("Destroy()");
  }

  int counter = 0;
  public void idle() {
    System.out.println("Idle()");
    if (counter == 10)
      run = false;
      counter++;
  }

}
