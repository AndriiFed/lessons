package template;

public class Application2 extends FwkApplication {


  public void configure() {
    System.out.println("Configuration");
  }

  public void destroy() {
    System.out.println("Destroy");
  }

  public void idle() {
    System.out.println("idle");
  }
}
