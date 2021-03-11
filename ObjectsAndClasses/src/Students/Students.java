package Students;

public class Students {
    private String firstName;
    private String lastName;
    private double grade;

    public Students(String firstName,String lastName,double grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public String toString(){
        return String.format("%s %s: %.2f", this.firstName, this.lastName, this.grade);
    }
}
