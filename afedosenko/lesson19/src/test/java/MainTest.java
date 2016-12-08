import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;


public class MainTest {

  @Test
  public void name() throws Exception {
   Queue<Integer> queue = new LinkedList<>();
   //queue.element();

   Queue<Integer> queue2 = new PriorityQueue<Integer>();
   //queue2.element();

    Queue<Integer> queue3 = new ArrayDeque<Integer>();
    //queue2.element();

    Queue<Integer> queue4 = new ArrayDeque<Integer>();
    //queue2.element();

    NavigableSet<String> set = new TreeSet<>();
    set.add("10");
    set.add("20");
    set.add("30");
    set.add("40");
    set.add("50");

    System.out.println(set.floor("35"));
    System.out.println(set.ceiling("30"));

  }


}

