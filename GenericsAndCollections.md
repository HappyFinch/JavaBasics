# Generics and Collections

- **泛型**是一种将类类型参数化为类、方法和变量的方法，这样我们就无需强制转换，在编译时进行更强的类型检查，并开发泛型算法。
- **集合**是为提供改进的互操作性和性能而创建的数据结构。集合为存储、检索和处理数据提供了更有效的框架和体系结构。

## 泛型generics
> 泛型允许我们编写处理一组不同数据类型的方法——换句话说，编写泛型的方法。

使用泛型的好处是：

- 编译时更强的类型检查。
- 他们消除了投射物体的需要。
- 它们允许开发人员实现通用算法。
- 换句话说，泛型是一种将类类型参数化为类、方法和变量的方法。

**语法示例**
```java
List strings = new List();
```
我们怎么知道这个列表中有什么？该列表名为```strings```，但这只是我们选择的名称。我们需要强制转换项目才能将它们用作 String 类型。

使用泛型，我们可以识别列表中存储的类型。泛型的语法非常简单——它只是用括号括起来里面的类型，```<type>```。所以在这个例子中，我们可以添加<String>来标识列表中存储的类型：
```java
List<String> strings = new <String>ArrayList();
```
**因为我们已经使用泛型将列表中的项目标识为字符串，所以我们现在可以直接对它们调用方法，而不必先强制转换它们。**



## 集合Collections

> 集合是 Java 5.0 中引入的一组数据结构，用于解决数据结构之间的一致性问题以及解决性能问题。它们的开发考虑了以下目标：
- 高性能/高效率。
- 高度的互操作性。新的数据结构都需要彼此具有相似的行为。实际上，这意味着 Collections 数据结构实现相似的接口并扩展相似的抽象类。
- 与现有 API 无缝集成。Java 框架必须能够轻松地扩展和适应新的数据结构。他们需要无缝集成新的数据结构，同时尽量减少对现有 API 的干扰。
- **Collection 继承自 *Iterable 接口*。**
- **Map、List、Set 和 Queue 都实现了 Collection 接口。**
- **集合是一个接口。**

### 语法示例
Collections 框架由几个不同的数据结构类组成，例如```List,Maps和Queues```。此外，还有诸如Collections和 之类的实用程序类```Arrays```提供用于排序和创建空列表的方法。下面是一个示例，其中我们创建了一个List类型String，然后添加和删除数据。

**注意：**

我们正在**创建一个实例List**,但我们使用一个**ArrayList**来满足它。这是**因为它List是一个接口，我们必须使用一个具体的类来实例化该对象**。
```java
List<String> myList = new ArrayList<String>();

myList.add("one");
myList.add("two");
myList.add("three");

//We could also remove the element "one" by using the index 0 instead of the value "one".
myList.remove("one");
```
```java
    List<String> names = new LinkedList<String>();
    names.add("Mike");
    names.add("Bob");
    names.add("Alice");

    Iterator<String> iterator = names.iterator();

    while(iterator.hasNext()){
      System.out.println(iterator.next());
    }
```

```java
public class CollectionsExercise {

    public static void main(String[] args) {

        List<String> listOfItems = new LinkedList<String>();
        listOfItems.add("Mike");
        listOfItems.add("Bob");
        listOfItems.add("Alice");

        for (String name : listOfItems) {
            System.out.println(name);
        }
    }
}
```
## 集合的排序

> 为了对集合进行排序，我们需要使用 Collections 类的 sort() 方法。该方法需要一个 List 类型的参数，因此我们需要将集合转换为 List 类型。我们可以使用 Arrays.asList() 方法来实现这一点。

**语法示例**
```java
List<String> names = new ArrayList<String>();
names.add("Mike");
names.add("Bob");
names.add("Alice");

Collections.sort(names);
```
**Strings**
A list of Strings can be sorted by simply passing the list to the Collections.sort() method. In the example bellow, the names will be sorted in ascending order.
```java
    List<String> names = new LinkedList<String>();

    names.add("Mike");
    names.add("Bob");
    names.add("Alice");

    Collections.sort(names);
```
**Wrapper Objects**

Wrapper objects were introduced in Java to **wrap primitive variable types into objects**. In the example below, the primitive int values are being converted to Integer objects and then sorted.

```java
    List<Integer> numbers = new LinkedList<Integer>();

    numbers.add(201);
    numbers.add(100);
    numbers.add(101);

    Collections.sort(numbers);
```
**User-Defined Classes**
User-defined classes will need to implement the Comparable Interface in order to use the Collections.sort() method. The Comparable Interface provides a method, ```compareTo```, which is used to compare two objects of the same type. In the example below we are using the Person object's name field to compare Person objects. This line of code, name.compareTo(person.name), handles all of the hard work.
```java
import java.util.*;  

class Person implements Comparable<Person> {  
  public String name;  
  public Person(String name) {  
    this.name = name;  
  }  
  public int compareTo(Person person) {  
    return name.compareTo(person.name);  

  }   
}  
public class PersonSort {
  public static void main(String[] args) {
    ArrayList<Person> people = new ArrayList<Person>();
    people.add(new Person("Same"));
    people.add(new Person("Mike"));
    people.add(new Person("Apple"));

    Collections.sort(people);
    for (Person person : people) {
      System.out.println(person.name);
    }
  }
}
```
## 集合的遍历

> 为了遍历集合，我们需要使用迭代器。迭代器是一种用于遍历集合的对象。它提供了一种方法来访问集合中的元素，而不需要知道集合的底层表示。

**语法示例**
```java
List<String> names = new ArrayList<String>();
names.add("Mike");
names.add("Bob");
names.add("Alice");

Iterator<String> iterator = names.iterator();

while(iterator.hasNext()){
  System.out.println(iterator.next());
}
```
## 集合的查找

> 为了在集合中查找元素，我们需要使用 Collections 类的 binarySearch() 方法。该方法需要一个 List 类型的参数，因此我们需要将集合转换为 List 类型。我们可以使用 Arrays.asList() 方法来实现这一点。

**语法示例**
```java
List<String> names = new ArrayList<String>();
names.add("Mike");
names.add("Bob");
names.add("Alice");

Collections.sort(names);

int index = Collections.binarySearch(names, "Bob"); // 1
```
## 集合的复制

> 为了复制集合，我们需要使用 Collections 类的 copy() 方法。该方法需要两个 List 类型的参数，因此我们需要将集合转换为 List 类型。我们可以使用 Arrays.asList() 方法来实现这一点。

**语法示例**
```java
List<String> names = new ArrayList<String>();
names.add("Mike");
names.add("Bob");
names.add("Alice");

List<String> namesCopy = new ArrayList<String>();
namesCopy.add("John");
namesCopy.add("Joe");
namesCopy.add("Jack");

Collections.copy(namesCopy, names); // namesCopy = ["Mike", "Bob", "Alice"]
```

## 集合的反转

> 为了反转集合，我们需要使用 Collections 类的 reverse() 方法。该方法需要一个 List 类型的参数，因此我们需要将集合转换为 List 类型。我们可以使用 Arrays.asList() 方法来实现这一点。

**语法示例**
```java
List<String> names = new ArrayList<String>();
names.add("Mike");
names.add("Bob");
names.add("Alice");

Collections.reverse(names);
```

* ArrayList

> ArrayList 类是一个可以动态修改的数组，与普通数组的区别就是它是没有固定大小的限制，我们可以添加或删除元素。

ArrayList 继承了 AbstractList ，并实现了 List 接口。

* LinkedList

> LinkedList 类是一个双向链表，它实现了 List 接口，可以被当作堆栈、队列或双端队列进行操作。

```java
    LinkedList<String>list = new LinkedList<String>();
    list.add("abc");
    list.add("Bcd");
    list.add("aAb");

    list.sort( new Comparator<String>(){
    @Override
        public int compare(String o1,String o2){
            return Collator.getInstance().compare(o1,o2);
        }
    });
```

## 高级的集合
### Maps 
```java
public class MapExcercise {

    public static void main(String[] args) {

        Map<String, Person> mapOfPeople = new HashMap<String, Person>();
        Person mike = new Person("Mike", "mike@email.com");
        Person shaun = new Person("Shaun", "shaun@email.com");
        Person sally = new Person("Sally", "sally@email.com");
        Person cesar = new Person("Cesar", "cesar@email.com");

        ArrayList<Person> people = new ArrayList<Person>();
        people.add(mike);
        people.add(shaun);
        people.add(sally);
        people.add(cesar);

        for (Person person : people) {
            MapExcercise.addToMap(mapOfPeople, person);
        }

        for (String email : mapOfPeople.keySet()) {
            System.out.println(email);
        }

        for (Person person : mapOfPeople.values()) {
            System.out.println(person);
        }

        System.out.println("Get Mike: " + mapOfPeople.get("mike@email.com"));
        System.out.println("Get Jeff: " + mapOfPeople.get("jeff@email.com"));
        System.out.println("Contains Mike: " + mapOfPeople.containsKey("mike@email.com"));
        System.out.println("Contains Jeff: " + mapOfPeople.containsKey("jeff@email.com"));

    }

    private static void addToMap(Map<String, Person> map, Person person) {
        map.put(person.getEmail(), person);
    }

}
```

### Sets
Concrete Implementations
There are three concrete implementations for the Set interface:
- HashSet
- TreeSet
- LinkedHashSet

Notice, we are using the concrete class HashSet to instantiate our Set object.
```java
Set<String> mySet = new HashSet<String>();
mySet.add("Hello");
mySet.add("Hello");
mySet.add("Hellos");

String foundObject;

for (String text : mySet) {
   if(text.equals("Hello"){
      foundObject  = text;
   }
}
```

```java
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetExcercise {

    public static void main(String[] args) {
        List<String> numbers = new ArrayList<String>();

        // We have a list of numbers and some are duplicates
        numbers.add("123-222-3333");
        numbers.add("223-222-3333");
        numbers.add("123-332-3333");
        numbers.add("123-222-4433");
        numbers.add("123-222-1133");
        numbers.add("123-222-3333");
        numbers.add("123-222-3333");
        numbers.add("123-232-4533");
        numbers.add("123-562-3333");
        numbers.add("123-000-3333");
        numbers.add("555-222-3333");
        numbers.add("444-222-3333");

        // Add them to a Set to get a unique list
        Set<String> uniqueNumbers = new HashSet<String>(numbers);

        for (String number : uniqueNumbers) {
            System.out.println(number);
        }
    }
}
```
### Queues

Notice that we are using the concrete class ```LinkedList``` to instantiate our Queue.
```java
Queue<String> myQueue = new LinkedList<String>();
myQueue.add("Hi");
myQueue.add("There");
//We retrieve objects from our queue by using the **poll** method. This method both retrieves the first element from the Queue and removes it from the Queue.
myQueue.poll()
// Iterating Over a Queue
while (!myQueue.isEmpty()) {
    System.out.println(myQueue.poll());
} // Hi There

// We can also use the **peek** method to retrieve the first element from the Queue without removing it.
myQueue.peek() // Hi
```







