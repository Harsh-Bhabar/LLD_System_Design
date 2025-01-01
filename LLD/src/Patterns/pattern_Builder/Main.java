package Patterns.pattern_Builder;

public class Main {
    public static void main(String[] args) {
        Admin directorObj1 = new Admin(new EngineerStudentBuilder());
        Admin directorObj2 = new Admin(new MBAStudentBuilder());

        Student engineerStudent = directorObj1.createStudent();
        Student mbaStudent =directorObj2.createStudent();

        System.out.println(engineerStudent.toString());
        System.out.println(mbaStudent.toString());

    }
}
