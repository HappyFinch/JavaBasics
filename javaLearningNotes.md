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

## 多态
> 多态性是对象具有多种形式的能力
```java
public class Vehicle {
    protected String start;
    protected String stop;
    protected String speed;
    protected String direction;

    public Vehicle(String start, String stop, String speed, String direction) {
        this.start = start;
        this.stop = stop;
        this.speed = speed;
        this.direction = direction;
    }

    public void start() {
        System.out.println(start);
    }

    public void stop() {
        System.out.println(stop);
    }

    public void speed() {
        System.out.println(speed);
    }

    public void direction() {
        System.out.println(direction);
    }

}
```
```java
public class Car extends Vehicle {

    public Car() {
        // Notice we are passing our arguments into our superclass (Vehicle) constructor
        super("Car start", "Car stop", "Car speed", "Car direction");
    }

}
public class Boat extends Vehicle {

    public Boat() {
        // Notice we are passing our arguments into our superclass (Vehicle) constructor
        super("Boat start", "Boat stop", "Boat speed", "Boat direction");
    }
}
```
```java
public class Plane extends Vehicle {

    public Plane() {
        // Notice we are passing our arguments into our superclass (Vehicle) constructor
        super("Plane start", "Plane stop", "Plane speed", "Plane direction");
    }

}
```
```java
public class VehicleTester {

    public static void main(String[] args) {
        // We can create an array of vehicles
        Vehicle[] vehicles = new Vehicle[3];

        // Add a Car, Plane and Boat objects to the array
        // Instantiate three new objects and add them to the array.
// It looks like these are all different types (Car, Plane, and Boat),
// but they all inherit from the Vehicle class, so in addition to the types
// they get from their subclasses, they are also all Vehicle objects.
        vehicles[0] = new Car();
        vehicles[1] = new Plane();
        vehicles[2] = new Boat();

        for (int i = 0; i < vehicles.length; i++) {
            Vehicle vehicle = vehicles[i];
            vehicle.speed();
        }
    }
}
```

## 抽象类
> 它定义了每个子类的行为，但我们不能直接实例化抽象类本身。它允许我们创建抽象方法。抽象方法是不包含实现主体的方法。相反，它只是为该方法提供一个标头。扩展抽象类的子类需要覆盖所有抽象方法并提供特定的实现。
```java
public abstract class Vehicle {
    protected String start;
    protected String stop;
    protected String direction;

    public Vehicle(String start, String stop,
                                  String direction) {
        this.start = start;
        this.stop = stop;
        this.direction = direction;
    }

    public abstract void speed();   
}
```
```java
public class Car extends Vehicle {

    public Car() {
    super("Car start", "Car stop", "Car direction");
    }
    @Override
    public void speed() {
        System.out.println("55");
    }
}
```

## 接口
### **抽象类**
* 可以有类变量。
* 可以具有与子类共享的抽象方法和具体方法。
* 可以有实例变量，即特定于各个子类的变量。
* 子类只能扩展一个类。
### **接口**
- 可以有类变量。
- 接口中的每个方法都是抽象的。
- 不能有实例变量。对于实现该接口的每个类，接口中的变量必须相同。
- 类可以实现多个接口并具有多重继承。

### **何时使用接口:**
- 我们期望不相关的类将实现我们的接口。
- 我们要支持多重继承。
- 我们想要指定数据类型的行为，但我们不关心实现。
```java
public interface Vehicle {

    public String getType();

    public String getSpeed();

    public String getColor();
}
```
```java
public class Car implements Vehicle, Production {
    private String type;
    private String speed;
    private String color;

    public Car(String type, String speed, String color) {
        super();
        this.type = type;
        this.speed = speed;
        this.color = color;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getSpeed() {
        return speed;
    }

    @Override
    public String getColor() {
        return color;
    }

     @Override
    public void getProduction() {
        System.out.println("Production: " + "China");
    }
}
```
