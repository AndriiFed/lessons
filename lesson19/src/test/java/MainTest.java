import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.NavigableSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class MainTest {
    @Test
    public void name() throws Exception {
       /* Queue<Integer> queue = new LinkedList<>();
        queue.element();

        Queue<Integer> queue2 = new PriorityQueue<>();
        queue2.element();

        Queue<Integer> queue3 = new ArrayDeque<>();
        queue3.element();
*/
        // push > addFirst
        // pop > removeFirst
        NavigableSet<String> set = new TreeSet<>();
        set.add("10");
        set.add("20");
        set.add("30");
        set.add("40");
        set.add("50");

        System.out.println(set.lower("30"));
        System.out.println(set.ceiling("30"));


    }
}

class Student {
    String name;
    Integer id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        return id != null ? id.equals(student.id) : student.id == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
