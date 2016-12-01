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

    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

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

  class WeirdIntegerComparator<T extends Integer> implements Comparator<T> {
    public int compare(T left, T right) {
      return Integer.compare(right, left) * -1;
    }

  }


  public class PriorityQueue<T extends Comparable> {
    private Object[] elements = new Object[16];
    private int size = 0;
    private Comparator<T> comparator;

    PriorityQueue() {}

    PriorityQueue(Comparator<T> comparator) {
      this.comparator = comparator;
    }


    @SuppressWarnings("unchecked")
    private  void exchange(int n, int m) {
        T buf = (T) elements[n];
        elements[n] = elements[m];
        elements[m] = buf;
    }

    public void  insert(T item) {
      if (elements.length == size) {
        elements = Arrays.copyOf(elements, elements.length * 2);
      }

      elements[++size] = item;
      sweem(size);

    }

    @SuppressWarnings("unchecked")
    public T max() {
      T max = (T) elements[1];
      elements[1] = elements[size];
      //exchange(1, size);
      elements[size] = null;
      size--;
      sink(1);

      return max;
    }

    @SuppressWarnings("unchecked")
    private boolean lessOrEqual(int n, int m) {
      if (comparator == null) {
        return ((Comparable)elements[n]).compareTo(elements[m]) < 1;
      } else {
        return ((Comparable)elements[n]).compareTo(elements[m]) < 1;
      }

    }

    private void sweem(int k) {
      // to move up to parrent = k / 2
      while (!isRoot(k) && lessOrEqual(getParentIndex(k), k)) {
        exchange(k, getParentIndex(k));
        k = getParentIndex(k);
      }
    }

    private void sink(int k) {
      // k * 2 = left
      // k * 2 + 1 = right

      while (getLeftChildIndex(k) <= size) {

        int childOfK = getLeftChildIndex(k);
        if (childOfK != size && lessOrEqual(getLeftChildIndex(k), getRightChildIndex(k)) ) {
          childOfK = getRightChildIndex(k);
        }

        if (lessOrEqual(k, childOfK)) {
          exchange(k, childOfK);
          k = childOfK;
        } else {
          break;
        }
      }
    }

    private boolean isRoot(int k) {
      return k == 1;
    }

    private int getParentIndex(int k) {
      return k / 2;
    }

    private int getLeftChildIndex(int k) {
      return k * 2;
    }

    private int getRightChildIndex(int k) {
      return k * 2 + 1;
    }


  }

}

