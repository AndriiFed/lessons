import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class JAXBTest {
    @Test
    public void simpleJAXBTest() throws Exception {
        JAXBContext context = JAXBContext.newInstance(Person.class);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(new Person(), System.out);
    }

    @Test
    public void test1()throws Exception {
        Person person = new Person.Builder()
                .setId(10_000)
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

        assertThat(rPerson.getAge(), is(25));
        assertThat(rPerson.getName(), is("John Doe"));
        assertThat(rPerson.getId(), is(10_000));
    }
}
