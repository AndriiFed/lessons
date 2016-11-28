import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;

public class StackTest {
  @Test
  public void test1() {
    Stack<Integer> stack = new Stack<>();

    stack.push(10);

    assertThat(stack.pop(), is(10));
  }

  @Test
  public void test2() {
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < 20; i++) {
      stack.push(i);
    }

    for (int i = 19; i >= 0; i--) {
      assertThat(stack.pop(), is(i));
    }
  }

  private class Stack<T> {
    private Object[] elements = new Object[10];
    private int size = 0;

    void push(T item) {
      if(isFull()) {
        increaseCapacity();
      }
      elements[size] = item;
      size++;
    }

    private boolean isFull() {
      return elements.length == size;
    }

    private void increaseCapacity() {
      elements = Arrays.copyOf(elements, elements.length * 2);
    }

    @SuppressWarnings("unchecked")
    T pop() {
      size--;
      return (T) elements[size];
    }
  }
}
