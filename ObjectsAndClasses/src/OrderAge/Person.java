package OrderAge;

public class Person {
    private String name;
    private String ID;
    private int age;

    public Person(String name, String ID, int age) {
        this.name = name;
        this.ID = ID;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String toString(){
        return name + " with ID: " + ID + " is " + age + " years old.";
    }
}
