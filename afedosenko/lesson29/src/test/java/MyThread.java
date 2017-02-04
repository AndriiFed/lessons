public class MyThread extends Thread{
  private int th;

  public MyThread(int th) {
    this.th = th;
  }
  @Override
  public void run() {
    System.out.println("Hello Thread: " + th);

    try {
      Thread.sleep(1000 * th);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }
}
