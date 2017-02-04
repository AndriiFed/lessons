import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;

public class QueueTest {
  @Test
  public void test1() {
    Queue<Integer> queue = new Queue<>();
    queue.enqueue(10);

    assertThat(queue.dequeue(), is(10));
  }

  @Test
  public void test2() {
    Queue<Integer> queue = new Queue<>();
    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);

    assertThat(queue.dequeue(), is(10));
    assertThat(queue.dequeue(), is(20));
    assertThat(queue.dequeue(), is(30));
  }

  @Test
  public void test3() {
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
  public void test4() {
    Queue<Integer> queue = new Queue<>();
    for (int i = 0; i < 20; i++) {
      queue.enqueue(i);
    }

    for (int i = 0; i < 20; i++) {
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
        //elements[size++] = item; // works fine as well
        //elements[++size] = item; // wrong
    }

    private boolean isFull() {
      return elements.length == size;
    }

    private void increaseCapacity() {
      elements = Arrays.copyOf(elements, size * 2);
    }

    @SuppressWarnings("unchecked")
    T dequeue() {
      T elem = (T) elements[0];
      //  arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
      System.arraycopy(elements, 1, elements, 0, elements.length - 1);
      elements[--size] = null;
      //size--;

      return elem;
    }
  }
}
