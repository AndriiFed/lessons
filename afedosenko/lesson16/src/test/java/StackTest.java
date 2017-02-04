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
    stack.push(20);
    stack.push(30);

    assertThat(stack.pop(), is(30));
    assertThat(stack.pop(), is(20));
    assertThat(stack.pop(), is(10));
    //assertThat(stack.pop(), is(nullValue()));

  }

  @Test
  public void test_LIFO() {
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < 20; i++) {
      stack.push(i);
    }

    for (int i = 0; i < 20; i++) {
      assertThat(stack.pop(), is(19 - i));
    }

  }


  private class Stack<T> {
    private Object[] elements = new Object[20];
    private int size = 0;

    void push(T item) {
      if (isFull()) {
        increaseCapacity();
      }
      elements[size] = item;
      size++;
      // or elements[size++] = item;
    }

    @SuppressWarnings("unchecked")
    T pop() {
      size--;
      return (T) elements[size];
    }

    private boolean isFull() {
      return elements.length == size;
    }

    private void increaseCapacity() {
      elements = Arrays.copyOf(elements, size * 2);
    }

  }



}
