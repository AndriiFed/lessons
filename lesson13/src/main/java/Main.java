import data.Bag;

class Main {
  public static void main(String ...args) {
    Bag<String> bag = new Bag<>();
    Bag<Integer> bag2 = new Bag<>();
    bag2.add(new Integer(10));
    bag2.add(20);
    bag2.add(30);
    //bag2.add("2111"); fails

    //Bag.Node<Integer> bnode = new Bag.Node();
    //bag.new Node<>(); // works
    //bag.new Node<String>(); // works
    //bag.new Node<Integer>(); // fails
    //new Bag().new Node();
    System.out.println("bag2 size: " + bag2.size());

    Bag.Iterator bagIterator = bag2.iterator();
    while(bagIterator.hasNext()) {
      System.out.println("bag2 contains: " + bagIterator.next());
    }
  }
}
