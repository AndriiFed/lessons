import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class JoinTest {
    private ArrayList<Pair<Integer, String>> leftTable;
    private ArrayList<Pair<Integer, String>> rightTable;

    @Before
    public void setUp() throws Exception {
        leftTable = new ArrayList<>();
        rightTable = new ArrayList<>();

        leftTable.add(new Pair<>(1, "John Doe"));
        leftTable.add(new Pair<>(2, "Jane Roe"));
        leftTable.add(new Pair<>(3, "Jerold Mouse"));
        leftTable.add(new Pair<>(4, "Tomas Cat"));

        rightTable.add(new Pair<>(1, "Java"));
        rightTable.add(new Pair<>(1, "SQL"));
        rightTable.add(new Pair<>(2, "Cobol"));
    }

    @Test
    public void crossJoinTest() throws Exception {
        List<Triple<Integer, String, String>> result = crossJoin(leftTable, rightTable);

        printResult(result);

        assertThat(result.size(), is(leftTable.size() * rightTable.size()));

        // SELECT left.key, left.value, right.value
        // FROM leftTable AS left, rightTable AS right
    }

    private <K, V1, V2> void printResult(List<Triple<K, V1, V2>> result) {
        for (Triple<K, V1, V2> triple : result) {
            System.out.format("[ %s | %s | %s ]\n", triple.key, triple.value, triple.value2);
        }
        System.out.format("---\nSize: %d", result.size());
    }

    private <K, V1, V2> List<Triple<K, V1, V2>> crossJoin(List<Pair<K, V1>> leftTable, List<Pair<K, V2>> rightTable) {
        List<Triple<K, V1, V2>> result = new ArrayList<>();
        for (Pair<K, V1> leftRecord : leftTable) {
            for (Pair<K, V2> rightRecord : rightTable) {
                result.add(new Triple<>(leftRecord.key, leftRecord.value, rightRecord.value));
            }
        }
        return result;
    }

    @Test
    public void innerJoinTest() throws Exception {
        List<Triple<Integer, String, String>> result = innerJoin(leftTable, rightTable);

        printResult(result);

        assertThat(result.size(), is(3));

        // SELECT left.key, left.value, right.value
        // FROM leftTable AS left
        // [INNER] JOIN rightTable AS right
        // ON left.key = right.key
    }

    private <K, V1, V2> List<Triple<K, V1, V2>> innerJoin(List<Pair<K, V1>> leftTable, List<Pair<K, V2>> rightTable) {
        return Collections.emptyList();
    }

    @Test
    public void leftOuterJoinTest() throws Exception {
        List<Triple<Integer, String, String>> result = leftJoin(leftTable, rightTable);

        printResult(result);

        assertThat(result.size(), is(3 + 2)); // innerJoin + 2 from leftTable which are not reflected on the rightTable

        // SELECT left.key, left.value, right.value
        // FROM leftTable AS left
        // LEFT [OUTER] JOIN rightTable [AS] right
        // ON left.key = right.key
    }

    private <K, V1, V2> List<Triple<K, V1, V2>> leftJoin(List<Pair<K, V1>> leftTable, List<Pair<K, V2>> rightTable) {
        return Collections.emptyList();
    }

    @Test
    public void rightOuterJoinTest() throws Exception {
        List<Triple<Integer, String, String>> result = rightJoin(leftTable, rightTable);

        printResult(result);

        assertThat(result.size(), is(?)); // innerJoin + ?

        // SELECT left.key, left.value, right.value
        // FROM leftTable AS left
        // RIGHT [OUTER] JOIN rightTable [AS] right
        // ON left.key = right.key
    }

    // rightJoin method should be here

    @Test
    public void fullOuterJoinTest() throws Exception {
        List<Triple<Integer, String, String>> result = fullJoin(leftTable, rightTable);

        printResult(result);

        assertThat(result.size(), is(?)); // innerJoin + ?

        // SELECT left.key, left.value, right.value
        // FROM leftTable AS left
        // FULL OUTER JOIN rightTable [AS] right
        // ON left.key = right.key
    }

    // fullJoin method should be here

    private class Pair<K, V> {
        final K key;
        final V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private class Triple<K, V, V2> extends Pair<K, V> {
        final V2 value2;

        public Triple(K key, V value, V2 value2) {
            super(key, value);
            this.value2 = value2;
        }
    }
}
