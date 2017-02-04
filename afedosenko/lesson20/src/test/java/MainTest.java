import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;


public class MainTest {

  @Test
  public void name() throws Exception {
    List<Integer> list = Arrays.asList(10, 20, 30, 40);


    assertThat(list.get(0), is(10));
    assertThat(list.get(1), is(20));
    assertThat(list.get(2), is(30));
    assertThat(list.get(3), is(40));

    //list.add(60); // fails
    list.set(0, 60);
    
  }

  @Test
  public void name2() throws Exception {
    List<Integer> list = new ArrayList<>();
    list.add(50);

    assertThat(list.get(0), is(50));
    list.add(60);
  }

  @Test
  public void test3() throws Exception {
    List<Integer> list = new ArrayList<>();
    list.add(10);
    list.add(20);
    list.add(30);

    for (int item : new ArrayList<>(list)) {
      if (item == 20) {
        list.add(100);  // exeption!
      }
    }

    assertThat(list.get(3), is(100));

  }

  @Test
  public void testName() throws Exception {
    Optional<Integer> opt = Optional.of(100);

    assertThat(opt.get(), is(100));
  }
}
