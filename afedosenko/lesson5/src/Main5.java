import  jelementary.School;
import  jelementary.Group;
import  jelementary.people.Student;

class Main5 {
    public static void main(String ... args) {
        Student st1 = new Student("Vasil Pupkin", 35, 1);
        System.out.println(st1.toString());

        Group gr1 = new Group("Jelementary", 13);
        gr1.addStudent(st1);
        System.out.println(gr1.toString());

        Group gr2 = new Group("Q&A", 13);
        //gr1.addStudent(st1);
        System.out.println(gr2.toString());

        School sch1 = new School("Hillel", "Kanatnaya str.");
        System.out.println(sch1.toString());
        sch1.addGroup(gr1);
        sch1.addGroup(gr2);
        System.out.println(sch1.toString());

    }
}
