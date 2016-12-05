import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class STableTest {
  @Test
  public void test1() {
    Map<Integer, String> map = new Map<>();

    map.put(1, "One");
    map.put(11, "Eleven");

    System.out.println(new Integer(100).hashCode());
    System.out.println(new Float(100.00).hashCode());
    System.out.println(new String("100").hashCode());

    assertThat(map.get(1), is("One"));
    assertThat(map.get(2), is(nullValue()));
    assertThat(map.get(100), is(nullValue()));
  }

  @Test
  public void test2() {
    Map<String, Integer> map = new Map<>();

    map.put("One", 1);
    map.put("Eleven", 11);

    assertThat(map.get("One"), is(1));
    assertThat(map.get("Eleven"), is(11));
    assertThat(map.get("100"), is(nullValue()));
  }

  private class Map<K, V> {
    private Object[] keys = new Object[10];
    private Object[] values = new Object[10];
    private int size = 0;

    void put(K key, V value) {
      //keys[size] = key;
      //values[getIndex(key)] = value;
      Node node = new Node();
      node.key = key;
      node.value = value;

      int index = getIndex(key);
      if (values[index] == null) {
        values[index] = node;
      } else {
        Node n = (Node) values[index];
        while (n.next != null) {
          if (n.key.equals(key)) {
            n.value = value;
            return;
          }
          n = n.next;
        }
        n.next = node;
      }

      size++;
    }

    V get(K key) {
      int index = getIndex(key);
      Node node = (Node) values[index];
      if (node != null) {
        do {
          if (node.key.equals(key)) {
            return node.value;
          }
          node = node.next;
        } while (node.next != null);
      }
      return null;
      //return (V)values[getIndex(key)];
      /*for (int i = 0; i < keys.length; i++) {
        if (keys[i].equals(key)) {
          return (V)values[i];
        }
      }
      return null;*/
    }

    private int getIndex(K key) {
      return key.hashCode() % values.length;
    }

    void delete(K key) {

    }

    private class Node {
      K key;
      V value;
      Node next;
    }
  }
}
