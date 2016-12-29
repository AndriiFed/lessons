import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.StringJoiner;

import javax.xml.transform.Result;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class MainTest {
    @Test
    public void name() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/engineers", "root", "root");

        Statement statement = connection.createStatement();

        statement.execute("SELECT * FROM engineer");

        //ResultSet result = statement.getResultSet();
        ResultSet result = statement.executeQuery("SELECT * FROM engineer");

        while(result.next()) {
            String res = String.format("[id=%d; name='%s']", result.getInt(1), result.getString(2));
            System.out.println(res);
        }

        result.close();
        statement.close();
        connection.close();
    }

    @Test
    public void stringJoinerTest() throws Exception {
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        for (int i = 1; i <= 5; i++) {
            joiner.add(Integer.toBinaryString(i));
        }

        System.out.println(joiner.toString());
    }

    @Test
    public void h2Test() throws Exception {
        Class.forName("org.h2.Driver");

        Connection conn = DriverManager.getConnection("jdbc:h2:mem:test", "sa", "sa");
        conn.close();
    }
}
