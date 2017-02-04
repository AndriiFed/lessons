import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class FileTest {
    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void test1() throws Exception {
        File file = new File("helloJava.txt");
        File file2 = new File(".gitignore");

        assertThat(file.exists(), is(false));
        assertThat(file2.exists(), is(true));
    }

    @Test
    public void test2() throws Exception {
        File file = new File("helloJava.txt");
        file.createNewFile();

        assertThat(file.exists(), is(true));

        file.deleteOnExit();
    }

    @Test
    public void test3() throws Exception {
        File file = temporaryFolder.newFile();

        System.out.println(file.getAbsolutePath());
        System.out.println(file.toString());
    }

    @Test
    public void test4() throws Exception {
        File dir = new File("C:\\Users\\Butakov\\AppData\\Local\\Temp\\helloDir");
        //File dir = new File("/tmp/helloDir");

        dir.mkdir();

        assertThat(dir.exists(), is(true));

        dir.deleteOnExit();
    }

    @Test
    public void test5() throws Exception {
        File dir = new File("dir1/dir2/dir3");

        dir.mkdirs();

        assertThat(dir.exists(), is(true));

        dir.deleteOnExit();
    }

    @Test
    public void test6() throws Exception {
        File parentDir = new File("helloDirList");
        parentDir.mkdir();

        File dir1 = new File(parentDir, "dir1");
        dir1.mkdir();

        File dir2 = new File(parentDir, "dir2");
        dir2.mkdir();

        File file1 = new File(parentDir, "file1");
        file1.createNewFile();

        File file2 = new File(parentDir, "file2");
        file2.createNewFile();

        File notListedFile = new File(dir2, "non-listed");
        notListedFile.createNewFile();

        System.out.println(Arrays.toString(parentDir.list()));

        parentDir.deleteOnExit();
        dir1.deleteOnExit();
        file1.deleteOnExit();
        dir2.deleteOnExit();
        file2.deleteOnExit();
        notListedFile.deleteOnExit();

        /*parentDir.delete();
        dir1.delete();
        file1.delete();
        dir2.delete();
        file2.delete();
        notListedFile.delete();*/
    }

    @Test
    public void test7() throws Exception {
        File parentDir = new File("helloDirList");
        parentDir.mkdir();

        File dir1 = new File(parentDir, "dir1");
        dir1.mkdir();

        File dir2 = new File(parentDir, "dir2");
        dir2.mkdir();

        File file1 = new File(parentDir, "file1");
        file1.createNewFile();

        File file2 = new File(parentDir, "file2");
        file2.createNewFile();

        File notListedFile = new File(dir2, "non-listed");
        notListedFile.createNewFile();

        System.out.println(Arrays.toString(parentDir.list()));

        deleteRecursively(parentDir);

        assertThat(parentDir.exists(), is(false));
    }

    private void deleteRecursively(File dir) {
        if (dir.isDirectory()) {
            for (File child : dir.listFiles()) {
                deleteRecursively(child);
            }
        }
        dir.delete();
    }

    @Test
    public void test8() throws Exception {
        File parentDir = new File("helloDirList");
        parentDir.mkdir();

        File dir1 = new File(parentDir, "dir1");
        dir1.mkdir();

        File dir2 = new File(parentDir, "dir2");
        dir2.mkdir();

        File file1 = new File(parentDir, "file1");
        file1.createNewFile();

        File file2 = new File(parentDir, "file2");
        file2.createNewFile();

        File notListedFile = new File(dir2, "non-listed");
        notListedFile.createNewFile();

        Files.walkFileTree(Paths.get(parentDir.getAbsolutePath()), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
        });

        assertThat(parentDir.exists(), is(false));
    }

    @Test
    public void test9() throws Exception {
        File parentDir = new File("helloDirList");
        parentDir.mkdir();

        File dir1 = new File(parentDir, "dir1");
        dir1.mkdir();

        File dir2 = new File(parentDir, "dir2");
        dir2.mkdir();

        File file1 = new File(parentDir, "file1");
        file1.createNewFile();

        File file2 = new File(parentDir, "file2");
        file2.createNewFile();

        File notListedFile = new File(dir2, "non-listed");
        notListedFile.createNewFile();

        System.out.println(
                Arrays.toString(parentDir.list(new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        return name.contains("1");
                    }
                }))
        );

        System.out.println(
                Arrays.toString(parentDir.list(new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        return new File(dir, name).isDirectory();
                    }
                }))
        );

        System.out.println(
                Arrays.toString(parentDir.list())
        );

        deleteRecursively(parentDir);

        assertThat(parentDir.exists(), is(false));
    }

    @Test
    public void test10() throws Exception {
        File temp = File.createTempFile("test", ".txt");

        System.out.println(temp.getAbsolutePath());
    }
}
