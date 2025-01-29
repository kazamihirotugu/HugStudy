package task2_23;

public class Person {

    private String name;
    private String language;

    public Person(String name, String language) {
        this.name = name;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public void introduce() {
        System.out.println("僕の名前は" + name + "です。");
    }
    
    public void studyLanguage() {
        if (language != null && !language.isEmpty()) {
            System.out.println(name + "は" + language + "を学んでいます。");
        } else {
            System.out.println("不正な値です。");
        }
    }
}
