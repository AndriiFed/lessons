import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class MainTest {
    @Test
    public void test1() throws Exception {
        DataInput in = new DataInputStream(new FileInputStream("chaos.txt"));
        System.out.println(in.readLine());
        System.out.println(in.readBoolean());
        System.out.println(in.readDouble());
        System.out.println(in.readChar());

        byte[] bytes = new byte[20];
        in.readFully(bytes);

        System.out.println(new String(bytes));
    }

    @Test
    public void test2() throws Exception {
        DataOutput out = new RandomAccessFile("chaos_out.txt", "rw");
        out.writeChar('a');
        out.writeBoolean(false);
        out.writeChar('Ы');
        out.writeBoolean(true);
        out.writeInt(10);

        DataInput in = new RandomAccessFile("chaos_out.txt", "r");

        assertThat(in.readChar(), is('a'));
        assertThat(in.readBoolean(), is(false));
        assertThat(in.readChar(), is('Ы'));
        assertThat(in.readBoolean(), is(true));
        assertThat(in.readInt(), is(10));
    }

    @Test
    public void serializationTest() throws Exception {
        Student student = new Student();
        student.age = 20;
        student.score = 100.0;
        student.name = "John Doe";

        //ObjectOutput out = new ObjectOutputStream(new FileOutputStream("student.ser"));
        //out.writeObject(student);

        //out.close();

        ObjectInput in = new ObjectInputStream(new FileInputStream("student.ser"));
        Student rStudent = (Student) in.readObject();

        assertThat(rStudent.age, is(20));
        //assertThat(rStudent.score, is(100.0));
        assertThat(rStudent.score, is(0.0)); // because Student.score is a transient field
        assertThat(rStudent.name, is("John Doe"));

        System.out.println(rStudent.fullName);

        in.close();
    }

    @Test
    public void testGroupSerialization() throws Exception {
        Group group = new Group();
        group.add(new Student());

        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("group.ser"));
        out.writeObject(group);
        out.close();

        ObjectInput in = new ObjectInputStream(new FileInputStream("group.ser"));
        Group rGroup = (Group) in.readObject();
        in.close();

        System.out.println(group);
        System.out.println(rGroup);
    }
}
