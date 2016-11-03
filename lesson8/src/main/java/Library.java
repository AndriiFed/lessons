import jelementary.*;

public class Library {
    public boolean someLibraryMethod() {
        return true;
    }

    public static void main(String ...args) {
        Engineer eng = new Engineer("John");
        eng.sayHello();

        QA qa = new QA("Jane");
        qa.sayHello();

        //QA qa2 = new QA();


    }
}
