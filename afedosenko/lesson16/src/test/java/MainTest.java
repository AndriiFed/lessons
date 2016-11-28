import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;

public class MainTest {
  // FIFO
  @Test
  public void test1() {
    Queue<Integer> queue = new Queue<>();
    queue.enqueue(10);
    //queue.dequeue*();

    assertThat(queue.dequeue(), is(10));
  }

  @Test
  public void testFIFO() {
    Queue<Integer> queue = new Queue<>();
    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);

    queue.dequeue();
    queue.dequeue();

    queue.enqueue(40);

    assertThat(queue.dequeue(), is(30));
    assertThat(queue.dequeue(), is(40));
  }

  @Test
  public void test4_FIFO() {
    Queue<Integer> queue = new Queue<>();

    for (int i = 0; i < 10; i++) {
      queue.enqueue(i);
    }

    for (int i = 0; i < 10; i++) {
      assertThat(queue.dequeue(), is(i));
    }

  }

  private class Queue<T> {
    private Object[] elements = new Object[10];
    private int size = 0;

    void enqueue(T item) {
      if (isFull()) {
        increaseCapacity();
      }
      elements[size] = item;
      size++;
      // or elements[size++] = item;
    }

    @SuppressWarnings("unchecked")
    T dequeue() {
      T elem = (T) elements[0];
      System.arraycopy(elements, 1, elements, 0, elements.length - 1);
      elements[size - 1] = null;
      size--;
      return elem;

    }

    private boolean isFull() {
      return elements.length == size;
    }

    private void increaseCapacity() {
      elements = Arrays.copyOf(elements, size * 2);
    }


  }

}
