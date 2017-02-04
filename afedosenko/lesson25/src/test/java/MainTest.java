import com.sun.org.apache.xml.internal.dtm.ref.DTMAxisIteratorBase;
import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import java.sql.*;
import java.util.StringJoiner;

import javax.xml.transform.Result;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class MainTest {
  @Test
  public void name() throws Exception {
    Class.forName("com.mysql.jdbc.Driver");

    Connection connection =
      DriverManager.getConnection("jdbc:mysql://localhost:3336/engineers", "root", "root");

    DatabaseMetaData metaData =  connection.getMetaData();
    System.out.println(metaData.getDatabaseProductName());

    Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
      ResultSet.CONCUR_UPDATABLE);

    //statement.execute("SELECT * FROM engineer");
    //ResultSet result = statement.getResultSet();
    ResultSet resultSet = statement.executeQuery("SELECT * FROM engineer;");

/*    statement.executeQuery("SELECT * FROM engineer; SELECT * FROM engineer;");
    ResultSet resultSet1 = statement.getResultSet();
    ResultSet resultSet2 = statement.getResultSet();*/

    //int rowAffected = statement.executeUpdate("INSERT INTO engineer VALUES(11, 'Name');");
    //System.out.println(rowAffected);

    // navigation
    resultSet.beforeFirst();
    resultSet.first();
    resultSet.last();
    resultSet.next();
    resultSet.absolute(2);
    resultSet.relative(1);
    resultSet.relative(-1);

    ResultSetMetaData tableMetaData = resultSet.getMetaData();
    System.out.println(tableMetaData.getColumnTypeName(1));
    System.out.println(tableMetaData.getColumnName(1));
    int currentRow = resultSet.getRow();

    System.out.println(resultSet.getInt(3));
    System.out.println(resultSet.wasNull()); // check for NULL
    System.out.println(resultSet.getString("Name"));

    // update

    /*resultSet.updateString("name", "HUMAN");
    resultSet.updateRow();
    System.out.println(resultSet.getString("Name"));
    */

/*
    resultSet.absolute(3);
    resultSet.deleteRow();
    resultSet.refreshRow();
*/

    resultSet.cancelRowUpdates();
    resultSet.moveToInsertRow();
    //resultSet.updateInt(1, 20);
    resultSet.updateString(2, "Fred");
    resultSet.insertRow();
    resultSet.moveToCurrentRow();

/*
    while(resultSet.next()) {
      String res = String.format("[id=%d; name='%s']", resultSet.getInt(1), resultSet.getString(2));
      System.out.println(res);
    }*/

    resultSet.close();
    statement.close();
    connection.close();

  }

  @Test
  public void test2() throws Exception {

    Connection connection =
      DriverManager.getConnection("jdbc:mysql://localhost:3336/engineers", "root", "root");

    //String sql = "SELECT * FROM engineer WHERE name = 'Fred'"; // instead of
    String sql = "SELECT * FROM engineer WHERE name = ?";
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, "Fred");

    ResultSet resultSet = statement.executeQuery();

    while (resultSet.next()) {
      System.out.format("%s: %s \n", resultSet.getInt(1), resultSet.getString(2));
    }

    resultSet.close();
    statement.close();
    connection.close();
  }




}
