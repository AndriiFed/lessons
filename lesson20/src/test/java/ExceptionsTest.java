import org.junit.Test;

import java.io.IOException;

public class ExceptionsTest {
    @Test
    public void test1() throws Exception {
        try {
            System.out.println("Yo");
            foo();
            System.out.println("Yo");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//        foo(); // fails the app
    }

    private void foo() throws Exception {
        throw new Exception("Hello");
    }

    @Test
    public void test2() throws Exception {
        try {
            bar();
            try {
                foo();
            } finally {
                close();
            }
        } catch (MyException2 e) {
            System.out.println(e.getClass().getCanonicalName());
            throw new RuntimeException("Ooops", e);
//            e.printStackTrace();
        } catch (MyException e) {
            System.out.println(e.getClass().getCanonicalName());
            return;
        } /*catch (RuntimeException e) {
            System.out.println(e.getClass().getCanonicalName());
        }*/ finally {
            close();
        }
    }



    private void close() {
        // nothing to see here
    }

    private void bar() {
        throw new MyException();
    }

    private static class MyException extends RuntimeException {
    }

    private static class MyException2 extends MyException {
    }

    @Test
    public void test3() throws Exception {
        System.out.println(weird());
    }

    private int weird() {
        try {
            return 0;
        } finally {
            return -1;
        }
    }
}
