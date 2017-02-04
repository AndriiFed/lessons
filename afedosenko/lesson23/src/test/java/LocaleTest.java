import org.junit.Test;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;


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
  public void testName() throws Exception {
    ResourceBundle bundle = ResourceBundle.getBundle("i18n.bundle", Locale.ENGLISH);
    ResourceBundle ruBundle = ResourceBundle.getBundle("i18n.bundle", new Locale("ru"));


    System.out.println(bundle.getString("name"));
    System.out.println(ruBundle.getString("name"));
  }

  @Test
  public void test22() throws Exception {
    Properties properties = new Properties();
    properties.setProperty("name", "Jane");

    properties.put("hello", "worm");
    properties.store(new FileOutputStream("hello.properties"), "This is COMMENT");

    Properties prout = new Properties();
    prout.load(new FileReader("hello.properties"));

    System.out.println(prout.getProperty("name"));

  }
}
