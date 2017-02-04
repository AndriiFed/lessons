package template;

public class  Application2 extends FwkApplication {
  public boolean run = true;

  public void configure() {
    System.out.println("Configure()");
  }

  public void destroy() {
    System.out.println("Destroy()");
  }

  public void idle() {
    System.out.println("Idle()");
  }

}
