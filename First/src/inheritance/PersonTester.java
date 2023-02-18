package inheritance;

public class PersonTester {
    public static void main(String[] args) {
        Person sally = new Person("Sally", "Smith");
        System.out.println(sally);

        Student mike = new Student("mike", "Smith", "12345");
        System.out.println(mike);

        StudentEmployee john = new StudentEmployee("John", "Smith", "12345", "##12345", 10.00);
        System.out.println(john);
    }
}
