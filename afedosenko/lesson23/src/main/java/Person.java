import com.oracle.webservices.internal.api.databinding.Databinding;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Person {

  @XmlAttribute
  private int id;
  @XmlElement
  private String name;
  @XmlElement
  private int age;

  @Override
  public String toString() {
    return "Person{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", age=" + age +
      '}';
  }

  static class Builder {
    Person person;

    public Builder() {
      person = new Person();
    }

    public Builder setId(int id) {
      person.id = id;
      return this;
    }

    public Builder setName(String name) {
      person.name = name;
      return this;
    }

    public Builder setAge(int age) {
      person.age = age;
      return this;
    }

    public Person build() {
      return person;
    }
  }
}
