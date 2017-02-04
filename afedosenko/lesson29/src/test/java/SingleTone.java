public class SingleTone {
  private static SingleTone instance;

  private SingleTone() {}

  public static synchronized SingleTone getSingleTone() {
    if (instance == null) {
      instance = new SingleTone();
    }
    return instance;

  }

}
