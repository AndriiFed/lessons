package data;

public class Bag<Item> {
  private Node<Item> firstNode;
  private int size;

  private static class Node<Item> {
    Item value;
    Node<Item> next;
  }

  public void add(Item item) {
    Node<Item> previous = firstNode;
    firstNode = new Node<Item>();
    firstNode.value = item;
    firstNode.next = previous;
    size++;
  }

  public boolean isEmpty() {
    return firstNode == null;
  }
  public int size() {
    return size;
  }

  public Iterator<Item> iterator() {
    return new Iterator<Item>(firstNode);
  }

  public class Iterator<Item> {
    Node<Item> current;
    Iterator(Node<Item> node) {
      current = node;
    }

    public boolean hasNext() {
      return current.next != null;
    }

    public Item next() {
      Item item = current.value;
      current = current.next;
      return item;
    }
  }
}
