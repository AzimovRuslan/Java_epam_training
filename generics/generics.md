**Вопрос.** В какой версии Java появились параметризованные типы?  
**Ответ.** Java Generics доступны с Java 5  
**Источник.** habr.com/ru/company/sberbank/blog/416413/  

**Вопрос.** Приведите 2 примера кода: первый без параметризованного типа; второй - этот же код 
с параметризованным типом, иллюстрирующий преимущество данного варианта.  
**Ответ.** 
```Java
// Без параметризированного типа
public class Program{
      
    public static void main(String[] args) {
          
        Account acc1 = new Account(2334);
    }
}
class Account{
     
    private int id;
     
    Account(int id){
        this.id = id;
    }
     
    public int getId() { return id; }
}
```  
```Java
// С параметризированным типом
public class Program{
      
    public static void main(String[] args) { 

        Account<String> acc1 = new Account<String>("2345");
        Account<Integer> acc2 = new Account<Integer>(2345);
    }
}
class Account<T>{
     
    private T id;
    
    Account(T id){
        this.id = id;
    }
     
    public T getId() { return id; }
}
```  

**Вопрос.** Какие типы данных запрещены в качестве параметров классов?  
**Ответ.** В качестве параметров классов запрещено применять базовые типы.  
**Источник.** И. Блинов. стр 68.  

**Вопрос.** Дан код:
~~~java
class Gen <T1, T2 extends Number, T3 extends Object> { … }
~~~
Какие типы можно использовать в качестве аргументов T1, T2, T3?  
**Ответ.** Для Т1 можно использовать любой тип. Для Т2 можно использовать подклассы класса Number, для Т3 - наследники класса Object.  
**Источник.** И. Блинов. стр 68.  

**Вопрос.** Дан код:
```java
class SubInfo extends Info { … }
class Gen1 <T> { … }
class Gen2 <T extends Info> { … }
```
1. Является ли декларация Gen1<Info> подклассом Gen2<Info>?
2. Является ли декларация Gen1<SubInfo> подклассом Gen1<Info>?
3. Является ли декларация Gen2<SubInfo> подклассом Gen2<Info>?  
**Ответ.** 
1. Нет.
2. Нет.
3. Нет.  
**Источник.** https://docs.oracle.com/javase/tutorial/java/generics/inheritance.html  

**Вопрос.** Почему нельзя вызвать конструктор generic-типа?  
**Ответ.** Невозможно выполнить явный вызов конструктора generic-типа,так как компилятор не знает, какой конструктор может быть вызван и какой
объем памяти должен быть выделен при создании объекта.  
**Источник.** Блинов Стр.72  

**Вопрос.** Почему нельзя вызвать конструктор generic-типа?  
**Ответ.** Невозможно выполнить явный вызов конструктора generic-типа:
```java
class FailedOne <T> {
    private T value = new T();
}
```
так как компилятор не знает, какой конструктор может быть вызван и какой
объем памяти должен быть выделен при создании объекта.  
**Источник.** И.Блинов Стр.72  

**Вопрос.** Почему нельзя создать generic-поле?  
**Ответ.** По аналогичным причинам описаным вопросом выше, generic-поля нельзя создать  
**Источник.** И.Блинов Стр.72  

**Вопрос.** Предложите более эффективную запись данного кода:
~~~java
<T> void make1(Gen <T extends Object> gen) { … }
<S extends T> void make2(Info<T> info1, Info<S> info2) { … }
~~~  
**Ответ.**
~~~java
<T> void make1(Gen <T> gen) { … }
<S extends T> void make2(Info<T> info1, Info<S> info2) { … }
~~~  

**Вопрос.** Дан код:
~~~java
class Info { 
	public <T1> Info() { … }
	public <T2> Info(T2 t2) { … }
	public <T1> void make1(T1 t1) { … }
	public <T3> void make2() { … }
}
~~~
Создайте какой-либо экземпляр класса Info
1. конструктором без аргументов,
2. конструктором с аргументом. Синтаксически правильно вызовите методы make1() и make2().  
**Ответ.**
~~~java
Info test1 = new <Integer>Info();
Info test2 = new Info(new Integer(5));
test2.make1(new Integer(3));
test1.<Integer>make2();
~~~  

**Вопрос.** Поясните данный код:
~~~java
static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll)
~~~  
**Ответ.** Тип, представленный переменной типа T, ограничен сверху классом Object и интерфейсом Comparable.  
**Источник.** https://habr.com/ru/company/sberbank/blog/416413/  
