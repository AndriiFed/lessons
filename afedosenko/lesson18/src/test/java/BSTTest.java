import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import java.util.Map;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;


public class BSTTest {

  @Test
  public void test1() {

    Map<Integer, String> map = new Map<>();

    map.put(1, "One");
    map.put(11, "Eleven");

    assertThat(map.get(1), is("One"));
    assertThat(map.get(2), is(nullValue()));
    assertThat(map.get(100), is(nullValue()));

  }



  private class Map<K extends Comparable, V> {
    private Node root;

   void put(K key, V value) {
    root = put(root, key, value);
   }

    @SuppressWarnings("unchecked")
    Node put(Node node, K key, V value) {
      if (node == null) {
        Node n = new Node();
        n.key = key;
        n.value = value;
      } else {
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
          node.left = put(node.left, key, value);
        } else if (cmp > 0) {
          node.right = put(node.right, key, value);
        } else {
          node.value = value;
        }
      }
    }


    V get(Node node, K key) {
      if (node == null) {
        return null;
      } else {
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
          return (V)get(node.left, key);
        } else if (cmp > 0) {
          return (V)get(node.right, key);
        } else {
          return (V) node.value;
        }
      }
    }

   }

  private class Node<K, V> {
    K key;
    V value;
    Node left;
    Node right;
  }

}

