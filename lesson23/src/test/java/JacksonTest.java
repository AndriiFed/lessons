import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class JacksonTest {
    @Test
    public void jacksonSimpleTestToJSON() throws Exception {
        User user = new User("john", "secret");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        String userStr = objectMapper.writeValueAsString(user);
        assertThat(userStr, is("{\"username\":\"john\",\"password\":\"secret\"}"));

        User rUser = objectMapper.readValue(userStr, User.class);

        assertThat(rUser.getUsername(), is("john"));
        assertThat(rUser.getPassword(), is("secret"));
    }

    @Test
    public void jacksonSimpleTestToXML() throws Exception {
        User user = new User("john", "secret");

        ObjectMapper objectMapper = new XmlMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        String userStr = objectMapper.writeValueAsString(user);
        assertThat(userStr, is("<User><username>john</username><password>secret</password></User>"));

        User rUser = objectMapper.readValue(userStr, User.class);

        assertThat(rUser.getUsername(), is("john"));
        assertThat(rUser.getPassword(), is("secret"));
    }
}
