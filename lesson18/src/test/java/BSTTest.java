import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class BSTTest {
  @Test
  public void test1() {
    Map<String, Integer> map = new Map<>();

    map.put("One", 1);
    map.put("Eleven", 11);

    assertThat(map.get("One"), is(1));
    assertThat(map.get("Eleven"), is(11));
    assertThat(map.get("100"), is(nullValue()));
  }

  class Map<K extends Comparable, V> {
    private Node root;

    private class Node {
      K key;
      V value;
      Node left;
      Node right;
    }

    void put(K key, V value) {
      root = put(root, key, value);
    }

    V get(K key) {
      return get(root, key);
    }

    V get(Node node, K key) {
      if (node == null) {
        return null;
      } else {
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
          return get(node.left, key);
        } else if (cmp > 0) {
          return get(node.right, key);
        } else {
          return node.value;
        }
      }
    }

    Node put(Node node, K key, V value) {
      if (node == null) {
        Node n = new Node();
        n.key = key;
        n.value = value;
        return n;
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
      return node;
    }
  }
}
