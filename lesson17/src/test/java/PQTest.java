import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.Comparator;

public class PQTest {
  @Test
  public void test1() {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    pq.insert(10);
    pq.insert(30);
    pq.insert(20);
    pq.insert(40);

    assertThat(pq.max(), is(40));
    assertThat(pq.max(), is(30));
    assertThat(pq.max(), is(20));
    assertThat(pq.max(), is(10));
  }

  @Test
  public void test2() {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    pq.insert(10);
    pq.insert(30);
    pq.insert(20);
    pq.insert(50);
    pq.insert(40);

    assertThat(pq.max(), is(50));
    assertThat(pq.max(), is(40));
    assertThat(pq.max(), is(30));
    assertThat(pq.max(), is(20));
    assertThat(pq.max(), is(10));
  }

  @Test
  public void test3() {
    PriorityQueue<Integer> pq =
      new PriorityQueue<>(new WeirdIntegerComparator());

    pq.insert(10);
    pq.insert(30);
    pq.insert(20);
    pq.insert(40);

    assertThat(pq.max(), is(10));
    assertThat(pq.max(), is(20));
    assertThat(pq.max(), is(30));
    assertThat(pq.max(), is(40));
  }

  @Test
  public void test4() {
    PriorityQueue<String> pq = new PriorityQueue<>();

    pq.insert("Knife in a back");
    pq.insert("Axe in a head");
    pq.insert("Sneezing");
    pq.insert("Vomiting on the floor");
    pq.insert("Coughing hard");
    pq.insert("Says he is a Java dev");

    for (int i = 0; i <= 5; i++) {
      System.out.println(pq.max());
    }
  }

  class WeirdIntegerComparator<T extends Integer> implements Comparator<T> {
    public int compare(T left, T right) {
      return Integer.compare(left, right) * -1;
    }
  }

  class PriorityQueue<T extends Comparable> {
    private Object[] elements = new Object[16];
    private int size = 0;
    private Comparator<T> comparator;

    PriorityQueue() {}

    PriorityQueue(Comparator<T> comparator) {
      this.comparator = comparator;
    }

    void insert(T item) {
      if (elements.length == size) {
        elements = Arrays.copyOf(elements, elements.length * 2);
      }

      elements[++size] = item;

      swim(size);
    }

    T max() {
      T max = (T)elements[1];
      //elements[1] = elements[size];
      exchange(1, size);

      elements[size] = null;
      size--;

      sink(1);

      return max;
    }

    private boolean lessOrEqual(int n, int m) {
      if (comparator == null) {
        return ((Comparable)elements[n]).compareTo(elements[m]) < 1;
      } else {
        return comparator.compare((T)elements[n], (T)elements[m]) < 1;
      }
    }

    private void swim(int k) {
      // to move up to parent = k / 2
      while (!isRoot(k) && lessOrEqual(getParentIndex(k), k)) {
        exchange(k, getParentIndex(k));
        k = getParentIndex(k);
      }
    }

    private void sink(int k) {
      // k * 2 = left
      // k * 2 + 1 = right
      while (getLeftChildIndex(k) <= size) {
        int child = getChildIndex(k);
        if (lessOrEqual(k, child)) {
          exchange(k, child);
          k = child;
        } else {

          break;
        }
      }
    }

    private int getChildIndex(int k) {
      int leftChild = getLeftChildIndex(k);
      if (leftChild != size && lessOrEqual(getLeftChildIndex(k), getRightChildIndex(k))) {
        return getRightChildIndex(k);
      }
      return leftChild;
    }
    private int getLeftChildIndex(int k) {
      return k * 2;
    }

    private int getRightChildIndex(int k) {
      return k * 2 + 1;
    }


    private boolean isRoot(int k) {
      return k == 1;
    }
    private int getParentIndex(int k) {
      return k / 2;
    }

    private void exchange(int n, int m) {
      T tmp = (T)elements[n];
      elements[n] = elements[m];
      elements[m] = tmp;
    }
  }
}
