## 继承
> 每个类都继承自超类Object。

### 所有对象都有的一些方法：
- clone()，我们就可以克隆或复制任何对象。
- equals()，我们可以用它来确定两个对象是否相同。
- hashCode()，它为每个对象提供唯一的哈希码。在特定数据集中存储和检索对象时使用。
- toString()，获取对象当前状态的描述。

### 举例
- Person.java
``` java
public class Person {

    private String firstName;
    private String lasName;

    public Person(String firstName, String lasName) {
        super();
        this.firstName = firstName;
        this.lasName = lasName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLasName() {
        return lasName;
    }

    public void setLasName(String lasName) {
        this.lasName = lasName;
    }

    @Override
    public String toString() {
        return "Name:" + firstName + " " + lasName;
    }
}
```
- Student.java
```java
public class Student extends Person {

    private String studentId;

    public Student(String firstName, String lasName, String studentId) {
        super(firstName, lasName);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return super.toString() + " student ID " + studentId;
    }
}
```
- StudentEmployee.java
```java
public class StudentEmployee extends Student {
    private String employeeId;
    private double rateOfPayPerHour;

    public StudentEmployee(String firstName, String lasName, String studentId, String employeeId,
            double rateOfPayPerHour) {
        super(firstName, lasName, studentId);
        this.employeeId = employeeId;
        this.rateOfPayPerHour = rateOfPayPerHour;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public double getRateOfPayPerHour() {
        return rateOfPayPerHour;
    }

    public void setRateOfPayPerHour(double rateOfPayPerHour) {
        this.rateOfPayPerHour = rateOfPayPerHour;
    }

    @Override
    public String toString() {
        return super.toString() + " employee ID " + employeeId + " pay " + rateOfPayPerHour;
    }
}
```
- PersonTester.java
```java
public class PersonTester {
    public static void main(String[] args) {
        Person sally = new Person("Sally", "Phillips");
        System.out.println(sally);

        Student mike = new Student("Mike", "Thompson", "12345");
        System.out.println(mike);

        StudentEmployee jeff = new StudentEmployee("Jeff", "Sam", "4567", "#12345", 20.5);
        System.out.println(jeff);
    }
}
```

