package some.program;

class FirstProgram {
    public static void main(String[] args) {
      Object obj = new Object();
      String str = "hello";

      Student student = new Student();
      student.name = "John Doe";
      student.age = 12;

      Student student2 = new Student();
      student2.name = "Johnathan Doelsky";
      student2.age = 92;


      System.out.println(student);
      System.out.println(student2);

      while (!student2.isDead()) {
        // sout
      }
      student2.growImidiately();
      System.out.println(student2);
      student2.growImidiately();
      System.out.println(student2);
    }


}

class Student {
  public String name;
  public int age;

  public String toString() {
    if (isAlreadyDead())
      return "I was a student. I'm dead now :(";
    return "I'm a student. My name is " + name + ". I'm " + age + " years old." ;
  }

  public boolean isAlreadyDead() {
    return age >= 94;
  }

  public void growImidiately() {
    age++;
  }
}
