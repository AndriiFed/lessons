import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Group implements Serializable {
    private List<Student> students = new ArrayList<>();

    public void add(Student student) {
        students.add(student);
    }

    @Override
    public String toString() {
        return "Group{" +
                "students=" + students.size() +
                '}';
    }
}