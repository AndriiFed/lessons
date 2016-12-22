import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class SerializationTest {
    @Test
    public void testUserSerialization() throws Exception {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("user.ser"));

        User user = new User("john_doe", "secret");

        out.writeObject(user);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("user.ser"));
        User rUser = (User) in.readObject();

        assertThat(rUser.getUsername(), is("john_doe"));
        assertThat(rUser.getPassword(), is("secret"));
    }
}
