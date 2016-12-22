import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class JAXBTest {

  @Test
  public void JAXBTest1() throws Exception {
    JAXBContext context = JAXBContext.newInstance(Person.class);

    Marshaller marshaller = context.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    marshaller.marshal(new Person(), System.out);
  }

  @Test
  public void test1() throws Exception {
    Person person = new Person.Builder()
      .setId(1000)
      .setName("John Doe")
      .setAge(25)
      .build();

    JAXBContext context = JAXBContext.newInstance(Person.class);

    Writer writer = new StringWriter();
    Marshaller marshaller = context.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    marshaller.marshal(person, writer);

    String personXml = writer.toString();
    Reader reader = new StringReader(personXml);
    Unmarshaller unmarshaller = context.createUnmarshaller();
    Person rPerson = (Person) unmarshaller.unmarshal(reader);
    //assertThat(rPerson, 25);
    //rPerson.

  }
}
