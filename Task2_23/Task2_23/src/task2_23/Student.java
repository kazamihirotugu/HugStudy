package task2_23;

public class Student extends Person {

    public Student(String name, String language) {
        super(name, language);
    }

    @Override
    public void studyLanguage() {
        System.out.println(getName() + "は" + getLanguage() + "を学んでいます。");
    }
}
