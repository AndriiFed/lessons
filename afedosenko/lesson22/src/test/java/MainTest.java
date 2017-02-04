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

    DataInput in = new DataInputStream(new FileInputStream("chaos.txt"));
    in.readLine();

    System.out.println(in.readLine());
    System.out.println(in.readBoolean());
    System.out.println(in.readDouble());
    System.out.println(in.readChar());

    byte[] b = new byte[20];
    in.readFully(b);
    System.out.println(new String(b));

    }

  @Test
  public void test2() throws Exception {

    DataOutput out = new RandomAccessFile("chaos_out.txt", "rw");
    out.writeChar('a');
    out.writeChar('Ё');
    out.writeBoolean(false);
    out.writeBoolean(true);
    out.writeInt(10);

    DataInput in = new RandomAccessFile("chaos_out.txt", "r");

    assertThat(in.readChar(), is('a'));
    assertThat(in.readChar(), is('Ё'));
    assertThat(in.readBoolean(), is(false));
    assertThat(in.readBoolean(), is(true));
    assertThat(in.readInt(), is(10));

  }

  @Test
  public void test3() throws Exception {

    Student student = new Student();
    student.age = 35;
    student.score = 13;
    student.name = "John";

    ObjectOutput out = new ObjectOutputStream(new FileOutputStream("student.ser"));
    out.writeObject(student);
    out.close();

  }

  @Test
  public void test4() throws Exception {

    ObjectInput in = new ObjectInputStream(new FileInputStream("student.ser"));

    Student student1 = (Student) in.readObject();

    assertThat(student1.age, is(35));
    assertThat(student1.score, is(13));
    assertThat(student1.name, is("John"));

  }

  @Test
  public void test5() throws Exception {

    Group group = new Group();
    Student st1 = new Student();
    st1.age = 18;
    st1.score = 13;
    st1.name = "John";

    Student st2 = new Student();
    st2.age = 28;
    st2.score = 23;
    st2.name = "Doe";

    group.add(st1);
    group.add(st2);

    ObjectOutput out = new ObjectOutputStream(new FileOutputStream("group.ser"));
    out.writeObject(group);
    out.close();

    ObjectInputStream in = new ObjectInputStream(new FileInputStream("group.ser"));
    Group group2 = (Group) in.readObject();

    out.close();

    System.out.println("Student1:" + group2.students[0].name);
    System.out.println("Student1:" + group2.students[0].age);
    System.out.println("Student1:" + group2.students[0].score);
    System.out.println("Student2:" + group2.students[1].name);
    System.out.println("Student2:" + group2.students[1].age);
    System.out.println("Student2:" + group2.students[1].score);

    System.out.println(group);
    System.out.println(group2);

  }
}


class Group implements Serializable{
  Student[] students = new Student[10];
  int size = 0;
  void add(Student st) {
    students[size] = st;
    size++;
  }
}


class Student implements Serializable{
  int age;
  int score;
  String name;
}


