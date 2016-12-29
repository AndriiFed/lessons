import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class jdbcTest {
    @Test
    public void name() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");

        DatabaseMetaData metaData = connection.getMetaData();
        System.out.println(metaData.getDatabaseProductName());

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM city LIMIT 10");

/*        int rowsAffected = statement.executeUpdate(
        "INSERT INTO city('Name', 'CountryCode', 'District', 'Population') " +
                " VALUES('MyCity', 'UKR', 'no', 100)");
        System.out.println(rowsAffected);*/


       /* statement.execute("SELECT * FROM engineer;SELECT * FROM engineer");
        ResultSet resultSet1 = statement.getResultSet();
        ResultSet resultSet2 = statement.getResultSet();*/

        // navigation
        resultSet.first();
        resultSet.beforeFirst();
        resultSet.last();
        resultSet.next();
        resultSet.absolute(2); // go directly to 2nd row
        resultSet.relative(1); // go forward on 1 row
        resultSet.relative(-1); // go back on 1 row

        // table metadata
        ResultSetMetaData tableMetaData = resultSet.getMetaData();
        System.out.println(tableMetaData.getColumnName(1));
        System.out.println(tableMetaData.getColumnTypeName(1));

        int currentRow = resultSet.getRow();
        System.out.println(currentRow);


        // retrieve information
        System.out.println(resultSet.getInt(1));
        System.out.println(resultSet.wasNull());
        System.out.println(resultSet.getString("name"));

        //
        //resultSet.updateString("name", "Worm");
        //resultSet.updateRow();

        //resultSet.absolute(3);
       // resultSet.deleteRow();

        resultSet.cancelRowUpdates();

        resultSet.moveToInsertRow();
//        resultSet.updateInt(1, 20);
        resultSet.updateString(2, "Fred");
        resultSet.updateString(3, "UKR");
        resultSet.insertRow();

        //resultSet.moveToCurrentRow();

        //resultSet.refreshRow();

        resultSet.close();
        statement.close();
        connection.close();
    }

    @Test
    public void preparedStatement() throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");

//        String sql = "SELECT * FROM city WHERE CountryCode = 'UKR'";
        String sql = "SELECT * FROM city WHERE CountryCode = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "UKR");

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.format("%d: %s - %d\n", resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(5));
        }
    }
}
