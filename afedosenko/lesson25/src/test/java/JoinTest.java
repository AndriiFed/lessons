import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JoinTest {
  private ArrayList<Pair<Integer, String>> leftTable;
  private ArrayList<Pair<Integer, String>> rightTable;

  @Before
  public void setUp() throws Exception {

    leftTable = new ArrayList<>();
    rightTable = new ArrayList<>();

    leftTable.add(new Pair<>(1, "John"));
    leftTable.add(new Pair<>(2, "Jane"));
    leftTable.add(new Pair<>(3, "Jerold"));
    leftTable.add(new Pair<>(4, "Tomas"));

    rightTable.add(new Pair<>(1, "Java"));
    rightTable.add(new Pair<>(1, "SQL"));
    rightTable.add(new Pair<>(2, "Cobol"));

  }

  @Test
  public void test1() throws Exception {
    List<Triple<Integer, String, String>> result = crossJoin(leftTable, rightTable);

    printResult(result);
  }

  private <K, V1, V2> void printResult(List<Triple<K,V1,V2>> result) {

    for (Triple<K, V1, V2> triple : result) {
      System.out.format("[%s | %s | %s]\n", triple.key, triple.value, triple.value2);
    }

  }

  private <K, V1, V2> List<Triple<K,V1,V2>> crossJoin(ArrayList<Pair<K, V1>> leftTable, ArrayList<Pair<K, V2>> rightTable) {

    List<Triple<K,V1,V2>> result = new ArrayList<>();

    for (Pair<K,V1> leftRecord : leftTable) {
      for (Pair<K,V2> rightRecord : rightTable) {
        result.add(new Triple<>(leftRecord.key, leftRecord.value, rightRecord.value));
      }
    }

    return result;
    //return Collections.emptyList();
  }

  private class Triple<K, V, V2> extends Pair<K, V> {
    private final V2 value2;

    public Triple(K key, V value, V2 value2) {
      super(key, value);
      this.value2 = value2;
    }
  }

  private class Pair<K, V> {
    final K key;
    final V value;

    public Pair(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

}
