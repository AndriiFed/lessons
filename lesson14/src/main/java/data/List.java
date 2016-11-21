package data;

import java.util.Iterator;

public interface List<T> extends Iterable<T> {
  void add(T item);
  T get(int index);
  int size();
  Iterator<T> iterator();
}
