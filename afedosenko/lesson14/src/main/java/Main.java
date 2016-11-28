import java.util.Objects;

class Main {

  public static void main(String ... args) {
    List rawList = new List(); // Raw Type
    //rawList.add(10);

    List<Integer> list2 = new List<>();
    //rawList = list2;  //unsafe
    //list2 = rawList; // unsafe

    List<Number> listNum = new List<>();
    listNum.add(10L);
    listNum.add(16f);

    //listNum.add("sdsd"); // fails
    //List<String> listStr = new List<>(); // fails

    List2<Foo> list3 = new List2<>();
//    List2<Foo> list3 = new List2<>();


    listNum.add(new List<Number>());
    //listNum.add(new List<Integer>());
    listNum.add(new List3<Number>());

// -------------------
    Tuple<Integer, String> t1 = new Tuple<>(10, "hello");
    int a = t1.first;
    String b = t1.second;

    Tuple<Long, String> t2 = Tuple.<Long, String>create(1L, "John Doe");
    Tuple<Long, String> t3 = Tuple.create(2L, "Jane Roe");

    Tuple<String, String> t5 = Tuple.create("Hello ", "Jane Roe");
    t5.bridgeDemo("");

    Tuple<String, String> t6 = new StringTuple("Hello", "World");
    t6.bridgeDemo("");



    GenericList<String> strList = new GenericList<>();
    strList.addList(new GenericList<Integer>());
    strList.addList(new GenericList<Float>());
    strList.addList(new GenericList<Number>());
    //strList.addList(new GenericList<String>()); // fails

    strList.addList2(new GenericList<Number>());
    //strList.addList2(new GenericList<Integer>()); // fails
    strList.addList2(new GenericList<Object>());

    StringTuple t4 = new StringTuple("Hello", "Worls");

    printlnArray(new Integer[] {1, 2, 3});

  }

  public static <E> void printlnArray(E[] elements) {
    for (E elem : elements) {
      System.out.println(elem);
    }
  }

  @SuppressWarnings("unchecked")
  public static <E> void printVarargs(E ... elements) {
    for (E elem : elements) {
      System.out.println(elem);
    }
  }

}


class GenericList<T> {
  void add(T Item) {}
  void addList(GenericList<? extends Number> list) {
    list.toString();
    //list.add(1); //fails
    int i = list.size();
  }

  int size() {
    return 0;
  }

  void addList2(GenericList<? super Number> list) {

  }


}

class List<T extends Number> {
  void add(T Item) {}
  void add(List<T> list) {}
}

class List2<T extends Foo & Bar> {
  void add(T Item) {}
}


class List3<T extends Number> extends List<T>{
  void add(T Item) {}
  void add(List<T> list) {}
}


interface Foo extends Bar {}
interface Bar {}

class FooBar implements Foo, Bar {}


class Tuple<T, S extends String> {
  public final T first;
  public final S second;

  public Tuple(T first, S second) {
    this.first = first;
    this.second = second;
  }

  public void bridgeDemo(T item) {}

  public static <A, B extends String> Tuple<A, B> create(A first, B second) {
    return new Tuple<>(first, second);
  }

}

class StringTuple extends Tuple<String, String> {
  public StringTuple(String first, String second) {
    super(first, second);
  }

  public void bridgeDemo(String item) {}

}














