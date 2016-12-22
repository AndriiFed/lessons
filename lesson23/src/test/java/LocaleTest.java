import org.junit.Test;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LocaleTest {
    @Test
    public void test1() throws Exception {
        Locale locale = new Locale("en", "US");
        Locale locale2 = Locale.CANADA;
        Locale locale3 = new Locale.Builder()
                .setLanguage("en")
                .setRegion("GB")
                .build();
        Locale locale4 = Locale.forLanguageTag("en-AU");

        System.out.println(locale.getDisplayCountry());
        System.out.println(locale2.getDisplayCountry());
        System.out.println(locale3.getDisplayCountry());
        System.out.println(locale4.getDisplayCountry());
    }

    @Test
    public void resourceBundle() throws Exception {
        ResourceBundle bundle = ResourceBundle.getBundle("i18n.bundle", Locale.ENGLISH);
        ResourceBundle ruBundle = ResourceBundle.getBundle("i18n.bundle", new Locale("ru"));

        assertThat(bundle.getString("name"), is("John Doe"));
        assertThat(ruBundle.getString("name"), is("Вася Пупкин"));
    }

    @Test
    public void javaProperties() throws Exception {
        Properties properties = new Properties();
        properties.setProperty("name", "Jane Roe");
        properties.put("hello", "worm");

        properties.store(new FileOutputStream("hello.properties"), "This is fun");

        Properties rProperties = new Properties();
        rProperties.load(new FileReader("hello.properties"));

        assertThat(rProperties.getProperty("name"), is("Jane Roe"));
        assertThat(rProperties.getProperty("hello"), is("worm"));
    }
}
