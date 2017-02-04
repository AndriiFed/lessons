import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.rules.TemporaryFolder;


import java.io.*;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;


public class MainTest {


  @Test
  public void testName() throws Exception {

    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("user.ser"));

    User user = new User("john doe", "secret");

    out.writeObject(user);
    out.close();


    ObjectInputStream in = new ObjectInputStream(new FileInputStream("user.ser"));
    User rUser = (User) in.readObject();

    assertThat(rUser.getUsername(), is("john doe"));
    assertThat(rUser.getPassword(), is("secret"));
  }






}



