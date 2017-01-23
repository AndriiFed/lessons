public class SingleTone {
  private static SingleTone instance;

  private SingleTone() {}

  public static synchronized SingleTone getSingleTone() {
    if (instance == null) {
      instance = new SingleTone();
    }

    SingleTone2.INSTANCE.foo();

    return instance;

  }
}

enum SingleTone2 {
  INSTANCE;

  void foo() {
    System.out.println("add");
  }

}

class SingleTone3 {
  private static SingleTone3 instance = new SingleTone3();

  public static SingleTone3 getInstance() {
    return instance;
    }
  }


// Double checked locking
// Right multi-thread SingleTone

class DCLSingleTone {
  private static volatile DCLSingleTone instance; // VOLATILE

  private DCLSingleTone() {}

  public static DCLSingleTone getSingleTone() {
    if (instance == null) {
      synchronized (DCLSingleTone.class) {
        if (instance == null) {
          instance = new DCLSingleTone();
        }
      }
    }

    return instance;

  }

}



