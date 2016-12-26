import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.StringJoiner;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;


public class MainTest {


  @Test
  public void test1() throws Exception {
    Class.forName("com.mysql.jdbc.Driver");
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3336/engineers", "root", "root");

    Statement statement = connection.createStatement();

    //statement.execute("SELECT * FROM engineer");
    //ResultSet result2 = statement.getResultSet();
    ResultSet result = statement.executeQuery("SELECT * FROM engineer");

    while (result.next()) {
      System.out.format("[id = %d; name = %s]\n", result.getInt(1), result.getString("name"));
    }

    //result2.close();
    result.close();
    statement.close();
    connection.close();

  }

  @Test
  public void stringJoinerTest() throws Exception {
    StringJoiner joiner = new StringJoiner(",", "[", "]");
    for (int i = 1; i < 5; i++) {
      joiner.add(Integer.toBinaryString(i));
    }

    System.out.println(joiner.toString());

  }
}



