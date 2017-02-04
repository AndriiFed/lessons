package  data;

import java.util.Iterator;

public class ArrayList<T> implements List<T> {
  //private int size;
  T[] current;

  @Override
  public void add(T item) {
    Object[] temp = new Object[current.length + 1];

    for (int i = 0; i < current.length; i++) {
      temp[i] = current[i];
    }
    temp[current.length + 1] = item;
    current = (T[]) temp;
  }

  @Override
  public T get(int index) {
    return current[index];
  }

  public int size() {
    return current.length;
  }

  public Iterator<T>  iterator() {
    return null;
  }


}

