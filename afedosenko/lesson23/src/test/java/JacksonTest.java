import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class JacksonTest {

  @Test
  public void jacksonTestToJson() throws Exception {
    User user = new User("jack", "son");

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

    String userStr = objectMapper.writeValueAsString(user);
    assertThat(userStr,
      is("{\"username\":\"jack\",\"password\":\"son\"}"));

    User rUser = objectMapper.readValue(userStr, User.class);

    assertThat(rUser.getUsername(), is("jack"));
    assertThat(rUser.getPassword(), is("son"));

  }

  @Test
  public void jacksonTestToXml() throws Exception {
    User user = new User("jack", "son");

    ObjectMapper objectMapper = new XmlMapper();
    objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

    String userStr = objectMapper.writeValueAsString(user);
    assertThat(userStr,
      is("<User><username>jack</username><password>son</password></User>"));

    User rUser = objectMapper.readValue(userStr, User.class);

    assertThat(rUser.getUsername(), is("jack"));
    assertThat(rUser.getPassword(), is("son"));

  }



}
