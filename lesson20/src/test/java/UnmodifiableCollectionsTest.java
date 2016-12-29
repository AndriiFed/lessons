import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class UnmodifiableCollectionsTest {
    @Test
    public void name() throws Exception {
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);

        assertThat(list.get(0), is(10));
        assertThat(list.get(1), is(20));
        assertThat(list.get(2), is(30));
        assertThat(list.get(3), is(40));
        assertThat(list.get(4), is(50));

        list.set(0, 60);

        assertThat(list.get(0), is(60));
    }

    @Test
    public void test2() throws Exception {
        List<Integer> list = new ArrayList<>();

        list.add(10);

        assertThat(list.get(0), is(10));

        list.add(20);
    }

    @Test
    public void test3() throws Exception {
        List<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        for (int i = 0; i < list.size(); i++) {
            // ignore it
        }

        for (int item : new ArrayList<>(list)) {
            if (item == 20) {
                list.add(100);
            }
        }

        assertThat(list.get(3), is(100));
    }

    @Test
    public void test4() throws Exception {
        assertThat(Collections.emptyList().size(), is(0));
        //Collections.emptyList().add(0); // throws exception
    }

    @Test
    public void test5() throws Exception {
        Optional<Integer> opt = Optional.of(100);

        if (opt.isPresent()) {
            System.out.println(opt.get());
        }
        assertThat(opt.get(), is(100));
    }
}
