import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;


public class MainTest {

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

    File file = temporaryFolder.newFile("test.txt");

    System.out.println(file.getAbsolutePath());
    System.out.println(file.toString());


    assertThat(file.exists(), is(true));
  }

  @Test
  public void test4() throws Exception {
    File dir = new File("c:\\helloDir");
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

    File file3 = new File(dir2, "file3");
    file3.createNewFile();

    System.out.println(Arrays.toString(parentDir.list()));

    parentDir.deleteOnExit();
    dir1.deleteOnExit();
    dir2.deleteOnExit();
    file1.deleteOnExit();
    file2.deleteOnExit();
    file3.deleteOnExit();
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
    File file3 = new File(dir2, "file3");
    file3.createNewFile();

    deleteRecursively(parentDir);
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
    File file3 = new File(dir2, "file3");
    file3.createNewFile();

    //Files.walkFileTree(Paths.get(parentDir.getAbsolutePath(), SimpleFileVisitor<Path>()));


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
    File file3 = new File(dir2, "file3");
    file3.createNewFile();

    System.out.println(
      Arrays.toString(parentDir.list(new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
          return new File(dir, name).isDirectory();
        }
      }))
    );

    System.out.println(
      Arrays.toString(parentDir.list(new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
          return name.contains("1");
        }
      }))
    );

    deleteRecursively(parentDir);
  }

  @Test
  public void test10() throws Exception {
    File temp = File.createTempFile("andriifed_", ".txt");

    System.out.println(temp.getAbsolutePath());

  }

  public void deleteRecursively(File dir) {
    if (dir.isDirectory()) {
      for (File child : dir.listFiles()) {
        deleteRecursively(child);
      }
      dir.delete();
    }
  }







}
