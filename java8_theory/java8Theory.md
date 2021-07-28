**Вопрос.** Что такое лямбда-выражение?  
**Ответ.** Лямбда представляет набор инструкций, которые можно выделить в отдельную переменную и затем многократно вызвать в различных местах программы.  

**Вопрос.** Из каких элементов состоит объявление лямбда-выражения?  
**Ответ.** Основу лямбда-выражения составляет лямбда-оператор, который представляет стрелку ->. Этот оператор разделяет лямбда-выражение на две части: левая часть содержит список параметров выражения, а правая собственно представляет тело лямбда-выражения, где выполняются все действия  

**Вопрос.** При объявлении лямбда-выражения какие структуры можно опустить?  
**Ответ.** Если метод не принимает никаких параметров, то пишутся пустые скобки. Если метод принимает только один параметр, то скобки можно опустить.  

**Вопрос.** Что такое поток и конвейер в контексте лямбда-выражения?  
**Ответ.** Поток - последовательность элементов. Конвейер - это последовательность агрегатных операций.  
**Источник.** https://docs.oracle.com/javase/tutorial/collections/streams/index.html#pipelines  

**Вопрос.** Какие компоненты содержит конвейер?  
**Ответ.** Источник; 0 или более промежуточных операций, которые создают новый поток; терминальная операция.  
**Источник.** https://docs.oracle.com/javase/tutorial/collections/streams/index.html#pipelines  

**Вопрос.** Что такое агрегатные операции? Приведите примеры агрегатных операций  
**Ответ.** Агрегированные операции обрабатывают элементы из потока, а не напрямую из коллекции.
~~~java
roster
        .stream()
        .filter(
        p -> p.getGender() == Person.Sex.MALE
        && p.getAge() >= 18
        && p.getAge() <= 25)
        .map(p -> p.getEmailAddress())
        .forEach(email -> System.out.println(email));
~~~  
**Источник.** https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#approach9  

**Вопрос.** Какие различия между агрегатными операциями и итераторами?  
**Ответ.** Агрегатные операции используют внутреннюю итерацию, тк не имеют метода next. Они получают элементы из потока. Они могут быть параметрами.  
**Источник.** https://docs.oracle.com/javase/tutorial/collections/streams/index.html  

**Вопрос.** Какие имеются ограничения на локальные переменные, которые используются в лямбда-выражениях?  
**Ответ.** лямбда выражения не имеют теневое копирование.  
**Источник.** https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#accessing-local-variables.  

**Вопрос.** Что такое целевой тип лямбда-выражения и как компилятор определяет целевой тип?  
**Ответ.** Тип данных, который ожидает метод, использующий лямбда - целевой тип. Компилятор использует целевой тип, в котором ожидается лямбда.  
**Источник.** https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#target-typing  

**Вопрос.** В каких ситуациях может использоваться лямбда-выражение?  
**Ответ.** Может использоваться для выполнения кода в отдельном потоке,для выполнения в результате события.  

**Вопрос.** Могут ли лямбда-выражения ссылаться на другие существующие методы? Если да - приведите пример.  
**Ответ.** Могут.Пример: сортировка строк независимо от регистра
```java
Arrays.sort(strs, String::compareToIgnoreCase)
```  

**Вопрос.** Укажите виды ссылок на методы в контексте лямбда-выражений и приведите соответствующие пример.  
**Ответ.**
1.Ссылка на статический метод - имя_класса::имя_метода;
2.Ссылка на методы экземпляра - имя_экземпляра::имя_метода , имя_класса::имя_метода;
3.Ссылка на конструктор - имя_класса::new;  

**Вопрос.** Что такое операции сокращения в контексте лямбда-выражений?  
**Ответ.** Операции, которые позволяют вычислить результат, используя все элементы, присутствующие в потоке.  

**Вопрос.** Чем метод reduce отличается от метода collect в контексте лямбда-выражений?  
**Ответ.** Collect при модификации набора данных выдаёт коллекцию, в то время как reduce
выполняет терминальные операции сведения, возвращая некоторое значение - результат операции.  

**Вопрос.** Укажите, какие преимущества дает использование класса Optional?  
**Ответ.** Он позволяет избавиться от исключения NullPointerException и проверки на null.  

**Вопрос.** Выполните вывод каждого элемента коллекции collect с помощью метода forEach (), применяя:
итератор
поток  
**Ответ.**
~~~java
    List<String> phones = new ArrayList<String>();
    Collections.addAll(phones, "HTC U12", "Google Nexus 6P",
            "Samsung Galaxy S9", "LG G", "ASUS Zenfone 2",
            "Sony Xperia Z5", "Meizu Pro 6");

    List<String> filteredPhones = phones.stream().collect(Collectors.toList());
~~~  
Через итератор
~~~java
    for (Iterator<String> phone = phones.iterator(); phone.hasNext();) {
        System.out.println(phone.next());
    }
~~~  
Через поток
~~~java
    filteredPhones.stream().forEach(System.out::println);
~~~  

**Вопрос.** Выполните вывод каждого элемента Map collect с помощью java 8.  
**Ответ.**
```java
public class Runner {
    public static void main(String[] args) {
        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone 8", 54000),
            new Phone("Nokia 9", 45000),
            new Phone("Samsung Galaxy S9", 40000),
            new Phone("LG G6", 32000));


        Map<String, Integer> phones = phoneStream
            .collect(Collectors.toMap(p->p.getName(), t->t.getPrice()));

        phones.forEach((k,v)->System.out.println(k + " " + v));
    }
}
class Phone{

    private String name;
    private int price;

    public Phone(String name, int price){
        this.name=name;
        this.price=price;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
}
```  

**Вопрос.** Допишите сортировку коллекции users по имени с помощью метода getName() и вывод всех элементов коллекции в консоль (класс User приводить не обязательно).
public class Main {
public static void main(String[] args) {
List<User> users = new ArrayList<>();
users.add(new User("Nick", "Boll"));
users.add(new User("Jan", "Nicky"));
users.add(new User("Bot", "Smart"));
...
}
}  
**Ответ.**
```java
users.stream().sorted(Comparator.comparing(User::getName)).forEach(System.out::println);
```  

**Вопрос.** Допишите код, чтобы вывести только четные элементы коллекции, используя метод filter().
public class Main {
public static void main(String[] args) {
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
…
}
}  
**Ответ.**
```java
numbers.stream().filter(e -> e % 2 == 0).forEach(System.out::println);
```  

**Вопрос.** Допишите код, чтобы вывести количество элементов коллекции, длина которых больше 4, используя методы filter() и count().
public class Main {
public static void main(String[] args) {
List<String> names = Arrays.asList("John", "Jan", "Tirion", "Marry", "Nikolas");
…
}
}  
**Ответ.**
```java
System.out.println(numbers.stream().filter(e -> e.lenght() > 4).count());
```  

**Вопрос.** Допишите код, чтобы вывести каждый элемент коллекции, умножив его на 2, используя метод map().
public class Main {
public static void main(String[] args) {
List<Integer> numbers = Arrays.asList(1, 3, 5, 7);
…
}
}  
**Ответ.**
```java
numbers.stream().map(e -> e * 2).forEach(System.out::println);
```  

**Вопрос.** Создайте новую коллекцию ArrayList и выведите в консоль список четных чисел из коллекции numbers с использованием методов filter() и collect().
public class Main {
public static void main(String[] args) {
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
List<Integer> evenNumbers = ...
…
}
}  
**Ответ.**
```java
List<Integer> evenNumbers = numbers.stream().filter(e -> e % 2 == 0).peek(System.out::println).collect(Collector.toList());
```  

**Вопрос.** Создайте новую коллекцию LinkedList (имплементация Queue) и выведите в консоль НЕ пустые строки из коллекции ArrayList names с использованием методов filter() и collect().
public class Main {
public static void main(String[] args) {
List<String> names = Arrays.asList("Jaime", "Daenerys", "", "Tyrion", "");
Queue<String> queue = ….
…
}
}  
**Ответ.**
```java
Queue<String> queue = names.stream().filter(e -> !e.isEmpty()).collect(Collector.toCollection(LinkedList::new));
System.out.println(queue);
```  

**Вопрос.** Выведите имена домашних животных, объединив их в новую коллекцию List<String> petNames из коллекции их хозяев humans, у которых имена домашних животных являются полями класса (в виде отдельных коллекций), используя метод flatMap().
public class Main {
public static void main(String[] args) {
List<Human> humans = asList(
new Human("Sam", asList("Buddy", "Lucy")),
new Human("Bob", asList("Frankie", "Rosie")),
new Human("Marta", asList("Simba", "Tilly")));
List<String> petNames = ...
…
}
}  
**Ответ.**
```java
List<String> petNames = humans.stream().flatMap(e -> e.getPetsNames().stream()).collect(Collectors.toList());
petNames.forEach(System.out::println);
```  

**Вопрос.** Найдите и выведите первое по счету число, которое больше 10, используя методы filter() и findFirst().
public class Main {
public static void main(String[] args) {
List<Integer> numbers = Arrays.asList(1, 5, 8, 10, 12, 15);
Optional<Integer> first = ...
…
}
}  
**Ответ.**
```java
Optional<Integer> first =numbers.stream().filter(e -> e > 10).findFirst();
System.out.println(first.get());
```  


**Вопрос.** Найдите и выведите первую попавшуюся фразу (с учетом возможного многопоточного процесса), которая содержит фрагмент "Java", используя методы filter() и findAny().  
**Ответ.**
~~~java
public class Main {
public static void main(String[] args) {
	 List<String> strings = Arrays.asList("Java is the best", "Java 8", "Java 9", "Jacoco");
	 Optional<String> java = strings
	.parallelStream()
    .filter(e -> e.contains("Java"))
    .findAny();
	System.out.println(java);
}
~~~  
**Источник.** https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html  

**Вопрос.** Выведите boolean, имеется ли в коллекции хотя бы одно четное значение, используя метод anyMatch().  
**Ответ.**
~~~java
public class Main {
public static void main(String[] args) {
List<Integer> numbers = Arrays.asList(1, 4, 5, 7);
boolean match = numbers.stream().anyMatch(number -> number % 2 == 0);
		System.out.println(match);
}
}
~~~  
**Источник.** https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html  

**Вопрос:** Выведите boolean, являются ли все числа коллекции положительным, используя метод allMatch().  
~~~java
public class Main {
public static void main(String[] args) {
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
boolean match = numbers.stream().allMatch(number -> number > 0);
System.out.println(match);
}
}
~~~  
**Источник.** https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html  

**Вопрос:** Выведите boolean, НЕ являются ли все числа коллекции четными, используя метод noneMatch().  
**Ответ:** 
~~~java
public class Main {
public static void main(String[] args) {
List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 9);
boolean match = numbers.stream().noneMatch(number -> number % 2 == 0);
System.out.println(match);
}
}
~~~  
**Источник.** https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html  

**Вопрос.** Какие из ниже приведенных ламбда-выражений не скомпилируется и почему?
~~~java
(int x, int y) -> x+y 
(x, y) -> x+y 
(x, int y) -> x+y   
(x, final y) -> x+y
int x -> x;
x -> y -> x + y; 
x -> (final int y) -> y + x;
x -> x -> 5;
~~~  
**Ответ.**
~~~java
(x, int y) -> x+y
~~~     
не скомпилируется, необходимо либо указывать тип у всех переменных либо не указывать вовсе  
~~~java 
(x, final y) -> x+y 
~~~   
не скомпилируется, модификатор final может быть указан только вместе с типом переменной  
~~~java 
int x -> x
~~~ 
не скомпилируется, необходимо добавить скобки прои указании типа переменной  
~~~java 
x -> x -> 5;
~~~ 
не скомпилируется, некорректно составлено условие  
**Источник.** https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#syntax  

**Вопрос** Скомпилируется ли следующий код и почему?
for (byte b : "Java".getBytes()) {
foo(() -> b);
}  
**Ответ.** Скомпилируется. Если существует метод foo() который принимает интерфейс лямбда-выражения как параметр.  

**Вопрос.** Дана матрица 3х3 используя Java 8 преобразуйте ее в одномерный массив.  
**Ответ.**
~~~java 
int[][] matrix = {   {1, 2, 3}
, {4, 5, 6}
, {7, 8, 9}};
int[] array = Arrays.stream(matrix)
                .flatMapToInt(Arrays::stream)
                .toArray();
~~~  

**Вопрос** Даны классы:
~~~java 
class BlogPost {
String title;
String author;
BlogPostType type;
int likes;
}
enum BlogPostType {
NEWS,
REVIEW,
GUIDE
}
List<BlogPost> posts = Arrays.asList( ... );
~~~  
Определите:
Все уникальные статьи относящиеся к каждому типу статей.
Для каждого типа статьи определите статью с максимальным количеством лайков.
Все статьи относящиеся к каждому типу статей, список статей должен представлять собой строку формата: “Post titles: [title1, title2, …..] “  
**Ответ.**
~~~java
public class UserService {
    static List<BlogPost> posts;

    public static void main(String[] args) {
        posts = List.of(
                new BlogPost("name1", "author1", BlogPostType.NEWS, 1),
                new BlogPost("name2", "author2", BlogPostType.GUIDE, 23),
                new BlogPost("name3", "author3", BlogPostType.REVIEW, 234),
                new BlogPost("name4", "author4", BlogPostType.NEWS, 345),
                new BlogPost("name5", "author5", BlogPostType.GUIDE, 6789),
                new BlogPost("name6", "author6", BlogPostType.REVIEW, 322),
                new BlogPost("name7", "author7", BlogPostType.NEWS, 342),
                new BlogPost("name8", "author8", BlogPostType.GUIDE, 33),
                new BlogPost("name9", "author9", BlogPostType.REVIEW, 3234),
                new BlogPost("name0", "author0", BlogPostType.NEWS, 333)
        );

        //task1
        posts.stream()
                .distinct()
                .forEach(System.out::println);

        //task2
        method(BlogPostType.NEWS);
        method(BlogPostType.REVIEW);
        method(BlogPostType.GUIDE);

        //task3
        var titles = posts.stream()
                .map(name -> name.title)
                .toArray();
        System.out.println("Post titles: " + Arrays.toString(titles));


    }

    public static void method(BlogPostType blogPostType) {

        posts.stream()
                .filter(item -> item.type.equals(blogPostType))
                .max(Comparator.comparing(BlogPost::getLikes))
                .ifPresent(System.out::println);

    }
}
~~~  

**Вопрос:** Приведите два способа получения последнего элемента в потоке, в чем особенности вычисления этого значения в потоках.  
**Ответ:** 
- Использование API-интерфейса Reduce. Этот способ будет возвращать детерминированные результаты только для последовательных потоков. Поток сокращается до уровня, на котором остается только последний элемент. Если поток пуст, он вернет нулевое значение.
- Использование функции пропуска. Это может быть достигнуто с помощью функции Skip класса Stream. В этом случае мы потребляем Stream дважды, поэтому есть явное влияние на производительность.  
**Источник:** https://ru.minecraftfullmod.com/1486-how-to-get-the-last-element-of-a-stream-in-java  

**Вопрос:** Дан код, можно ли его как-то отрефакторить? Если да, то сделайте это.
Подсказка:
Добавьте в список элемент с автором, которые уже есть в списке и проверьте приложение
books.add(new Book("Java: A Beginner's Guide", "Herbert Schildt"));
```java
class Book {
    private String name;
    private String author;

// getters and setters
…
}

    List<Book> books = new ArrayList<>();

books.add(new Book("Effective Java", "Joshua Bloch"));
        books.add(new Book("Thinking in Java", "Bruce Eckel"));
        books.add(new Book("Java: The Complete Reference", "Herbert Schildt"));

        Map<String, String> bookMap = books.stream().collect(
        Collectors.toMap(Book::getAuthor, Book::getName));
        bookMap.forEach((author, book) ->
        System.out.println("Author: " + author + " Books: " + book));
```  
**Ответ:** 
```java
class Book {
    private String name;
    private String author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    @Override
    public String toString(){
        return "name: " + name + "author: " + author;
    }
}

    List<Book> books = new ArrayList<>();

books.add(new Book("Effective Java", "Joshua Bloch"));
        books.add(new Book("Thinking in Java", "Bruce Eckel"));
        books.add(new Book("Java: The Complete Reference", "Herbert Schildt"));
        books.add(new Book("Java: A Beginner's Guide", "Herbert Schildt"));

        Map<String, String> bookMap = books.stream().collect(
        Collectors.toMap(Book::getAuthor, Book::getName));
        peek(System.out::prinlt);
```  

**Вопрос:** Дан код
```java
class Employee {
    Integer employeeId;
    String employeeName;

    // getters and setters
}

class Department {
    Integer employeeId;
    String department;

    // getters and setters
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        List<Department> departments = new ArrayList<>();

        populate(employees, departments);

        List<Employee> salesEmpoyees = ...
    }
}
```
Замените многоточие, чтобы определить сотрудников находящихся в отделе “sales”  
**Ответ:** 
```java
class Employee {
    Integer employeeId;
    String employeeName;

    // getters and setters
}

class Department {
    Integer employeeId;
    String department;

    // getters and setters
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        List<Department> departments = new ArrayList<>();

        populate(employees, departments);

        List<Employee> salesEmpoyees = salesEmpoyees.stream().filter(s -> s.getDepartments.equals(sales));
    }
}
```  

**Вопрос:** Дан код
```java
class Tuple<T1, T2> {
    private T1 item1;
    private T2 item2;
// getters and setters
}
    List<String> names = new ArrayList<>(Arrays.asList("John", "Jane", "Jack", "Dennis"));
    List<Integer> ages = new ArrayList<>(Arrays.asList(24, 25, 27));
    List<Tuple<String, Integer>> namesAndAges = …
```
Выполните операцию ‘zip’ для коллекций ages и names.
Zip: операция «zip» немного отличается от стандартной «concat» или «merge». В то время как операции «concat» или «merge» просто добавят новую коллекцию в конец существующей коллекции, операция «zip» возьмет элемент из каждой коллекции и объединит их.
Например, в результате выполнения этого задания должна получиться коллекция:
[John;24, Jane;25, Jack;27]  
**Ответ:**

**Вопрос:** Дан код, замените  {code} и {type} так, чтобы получить нужные результаты
```java
Collection<String> strings = Arrays.asList("a1", "b2", "c3", "a1");
// Удалить все дубликаты
        List<String> unique= strings.stream().{code}
// напечатает unique= [a1, b2, c3]
        System.out.println("unique = " + unique);
// Объединить все элементы в одну строку через разделитель : и обернуть тегами <b> ... </b>
        String join = strings.stream().collect({code});
// напечатает <b> a1 : b2 : c3 : a1 </b>
        System.out.println("join = " + join);
// Преобразовать в map, сгруппировав по первому символу строки
        Map<String, List<String>> groups = strings.stream().collect({code});
// напечатает groups = {a=[a1, a1], b=[b2], c=[c3]}
        System.out.println("groups = " + groups);
// Преобразовать в map, сгруппировав по первому символу строки и в качестве значения взять второй символ, если ключ повторяется, то значения объединить через “:”
        Map<String, String> groupJoin = strings.stream()
        .collect(Collectors.groupingBy({code}));
// напечатает groupJoin = groupJoin = {a=1:1, b=2, c=3}
        System.out.println("groupJoin = " + groupJoin);

        Collection<Integer> numbers = Arrays.asList(1, 2, 3, 4);
// Получить сумму нечетных чисел
        {type} sumOdd = numbers.stream().collect({code});
// напечатает sumEven = 4
        System.out.println("sumOdd = " + sumOdd);
// Вычесть из каждого элемента 1 и получить среднее
        double average = numbers.stream().collect({code});
// напечатает average = 1.5
        System.out.println("average = " + average);
// Прибавить к числам 3 и получить статистику: количество элементов, их сумму, макс и мин. значения, а также их среднее.
        {type} statistics = numbers.stream().collect({code});
// напечатает statistics = … {count=4, sum=22, min=4, average=5.500000, max=7}
        System.out.println("statistics = " + statistics);
// Разделить числа на четные и нечетные
        Map<Boolean, List<Integer>> parts = numbers.stream().collect({code});
// напечатает parts = {false=[1, 3], true=[2, 4]}
        System.out.println("parts = " + parts);
```  
**Ответ:** 

**Вопрос:** Дан поток, определите количество вхождений каждого из символов, составляющих поток.
Stream<String> words = Stream.of("Java", "Magazine", "is", "the", "best");  
**Ответ:** 
- J -> 1
- a -> 4
- v -> 1
- M -> 1
- g -> 1
- z -> 1
- i -> 2
- n -> 1
- e -> 3
- s -> 2
- t -> 2
- h -> 1
- b -> 1  

**Вопрос:** Дан код, как он будет выглядеть если modem обернуть в Optional?
```java
boolean isInRange = false;
        if (modem != null && modem.getPrice() != null
        && (modem.getPrice() >= 10
        && modem.getPrice() <= 15)) {
        isInRange = true;
        }
        return isInRange;
```  
**Ответ:**  

**Вопрос:** Дан код, замените {code}, чтобы получить первый объект, которые не null, если такого нет вернуть “default’
```java
private Optional<String> getEmpty() {
        return Optional.empty();
        }

private Optional<String> getHello() {
        return Optional.of("hello");
        }

private Optional<String> getBye() {
        return Optional.of("bye");
        }
        String firstNonNull = Stream.of(getEmpty(), getHello(), getBye()).{code};
```  
**Ответ:**  