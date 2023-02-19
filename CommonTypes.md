## 异常
![error和exception](捕获.PNG)
#### Error和Exception两个类都是Throwable的子类，Error和Exception都包含：
- type of problem
- problem message
- stack trace
### 抛出异常
> 当方法中发生错误时，该方法会：①创建一个Exception对象。②接下来，该方法将异常传递给 JVM 运行时系统。

### 在 Java 中有两种不同类型的异常：
> catch已检查的异常将在编译时被捕获，并且在它们处于块中或被抛出之前不允许构建代码 。编译器不检查未检查（或运行时）异常。
1. 未经检查的异常
- 未经检查的异常是编译器未知的异常。
- 因为这些异常只有在运行时才知道，所以也称为运行时异常。
- 它们是编程错误的结果，通常是算术错误（例如被 0 除）。
- 当我们预计方法的调用者无法从异常中恢复时，使用未经检查的异常。
2. 检查异常
- 编译器知道已检查的异常。
- 如果我们正在调用一个可能会抛出已检查异常的方法，则必须对其进行处理（否则我们会从编译器中得到一个错误）。
- 当我们期望方法的调用者可以从异常中恢复时，使用已检查的异常。
```java
try {
    read();
}
catch (FileNotFoundException ex){
    ex.getLocalizedMessage();
}
finally {
}
```
![异常处理过程](捕获2.PNG)
## 枚举
> 枚举是一种特殊的常量数据类型，允许从枚举列表中设置变量。

- 枚举是一个类
- 在 Java 中，枚举的声明定义了一个类。此类可以存在于另一个类中或作为独立类存在。

```java
// 创建枚举
enum Stoplight {
  RED,
  YELLOW,
  GREEN
}
// 分配变量myStopLight
// 接下来，我们将使用枚举分配一个变量RED。

Stoplight myStoplight = Stoplight.RED;

// 在类中定义枚举
// 我们还可以从类内部创建一个枚举：
public class Main {
  enum StopLight {
    RED,
    YELLOW,
    GREEN
  }

  public static void main(String[] args) {
    StopLight myStoplight = Stoplight.RED; 
    System.out.println(myStoplight);
  }
}
```
## Scanner
### 示例 1
我们可以使用该类Scanner从命令行获取输入。为此，我们实例化一个扫描仪对象，传入System.in：

```
Scanner scanner = new Scanner(System.in);
```
示例 2
在此示例中，我们使用该nextLine方法返回输入的整行：
```
Scanner scanner = new Scanner("This is a line");
System.out.println(scanner.nextLine());
```
输出：
```
This is a line
```
示例 3
在下一个示例中，我们将使用该next方法来读取第一个标记。该next方法查找并返回下一个完整的标记。
```
Scanner scanner = new Scanner("This is a line");
System.out.println(scanner.next());
```
输出：
```
This
```
例 4
在最后一个示例中，我们在循环中使用该hasNext()方法while来确定调用下一个方法是否安全。我们只想在知道有可用令牌时调用下一个方法。

注意：默认情况下，扫描器通过空格标记输入。假设我们有一个包含以下文本的字符串"One Two Three"。文本将被标记为三个单独的标记"One"，"Two"和"Three"。
```
Scanner scanner = new Scanner("This is a line");

while(scanner.hasNext()) {
    System.out.println(scanner.next());
}
```
输出：
```
This
is
a
line
```
![Alt text](%E6%8D%95%E8%8E%B73.PNG)
**其他资源**

Java 还有两个其他类:BufferedReader和Console，可用于从命令行读取用户输入。如果您想了解更多信息，可以查看这篇关于从控制台读取用户输入的三种方法的文章。https://www.codejava.net/java-se/file-io/3-ways-for-reading-input-from-the-user-in-the-console

## Dates 和 Calendar
The Date Class
> The Date class represents a specific instance in time. We can instantiate a new Date object like so:
```
Date date = new Date();
```

The Calendar Class
> The Calendar class is an **abstract** class that provides methods for manipulating date and time. The basic syntax for instantiating a new Calendar object looks like this:
```
Calendar calendar = Calendar.getInstance();
```

**Additional Resources**
Java has some other classes— ```LocalDate, LocalTime, and LocalDateTime```—that can be used to manipulate dates. [you can read about them in the official documentation here](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html).

- You can use the **Calendar** class to get the current date, and to set the date.
- Typically, dates are stored in the **Date** class.
- The **calendar.setTime(date)**; and **calendar.getTime()** can be used - to go back and forth between the Date and Calendar classes.
- Note: You can use ```SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");``` to change the format of dates

```java
public class DatesAndCalendar {

    public static void main(String[] args) {
        DatesAndCalendar.displayCurrentDate();
        DatesAndCalendar.displaySetDate();
    }

    private static void displayCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        Date date = new java.util.Date();
        calendar.setTime(date);
        System.out.println(calendar.getTime());
    }

    private static void displaySetDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2031, 02, 02);
        Date date = calendar.getTime();

        System.out.println(date);
    }
}

```

## 正则表达式 (RegEx)

**Syntax Example（email）**
First, we start by defining a **String** for a valid email address using a regular expression:
```java
String emailRegex = "^(.+)@(.+).(.+)$"
```
Next we use **Pattern**, which provides a compiled instance of a String regular expression:
```java
Pattern pattern = Pattern.compile(emailRegex)
```

Finally, we use ***Matcher***, which contains all of the state data for matching a character sequence against the Pattern:
```java
Matcher matcher = pattern.matcher("jeff@example.com")
```
```java
public class RegExTester {

  public static void main(String[] args){
      String emailRegex = "^(.+)@(.+).(.+)$";
      Pattern pattern = Pattern.compile(emailRegex);
      String email = "jeff@gmail.com";

      System.out.println(pattern.matcher(email).matches());
  }
}
```

## 高级String
### String Method
Java 通过使用字符串池为字符串对象提供高级内存管理。字符串池是一种只存储一个字符串副本的方法。

要理解这一点，我们必须查看在创建字符串并将它们分配给变量时内存中发生了什么。Java 中的字符串是不可变的，这意味着它们在创建后无法更改。当我们“更改”变量中的 String 时，实际发生的是，在幕后，Java 在 String 池中创建了一个新的 String——并更改变量的引用值以指向这个新的 String。旧的 String 对象可能会保留在原地，没有变化。

另请注意，多个变量可能使用相同的 String 引用。这意味着如果我们有两个变量具有完全相同的字符串（例如，"Hello"），它们都将引用相同的字符串对象。

**一些方法：**

**charAt()
subString(start,end)
replace()
split()**


