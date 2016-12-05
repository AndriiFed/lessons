import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import java.util.Map;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;


public class STableTest {

  @Test
  public void test1() {

    //System.out.println("Test out");

    Map<Integer, String> map = new Map<>();

    map.put(1, "One");
    map.put(11, "Eleven");

    System.out.println(new Integer(1).hashCode());
    System.out.println(new Integer(11).hashCode());
    System.out.println(new Float(100.0).hashCode());
    System.out.println(new String("aasas").hashCode());

    assertThat(map.get(1), is("One"));
    assertThat(map.get(2), is(nullValue()));
    assertThat(map.get(100), is(nullValue()));

  }



  private class Map<K, V> {
    private Object[] values = new Object[10];
    private int size = 0;


    @SuppressWarnings("unchecked")
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

    @SuppressWarnings("unchecked")
    V get(K key) {

      //       return  (V)values[getIndex(key)];
      int index = getIndex(key);
      Node node = (Node) values[index];
      if (node != null) {
        do {
          if (node.key.equals(key)) {
            return (V)node.value;
          }
          node = node.next;

        } while (node.next != null);

      }
      return null;

      /*
      for (int i = 0; i < keys.length; i++) {
        if (keys[i].equals(key)) {
          return (V)values[i];
        }
      }
      return null;
      */

    }

    private int getIndex(K key) {
      return key.hashCode() % values.length;
    }

    void delete(K key) {

    }

  }

  private class Node<K, V> {
    K key;
    V value;
    Node next;
  }

}

