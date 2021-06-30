**Вопрос:** На какие две группы разделяются классы, объявленные внутри другого класса?
Как они называются на инглише?  
**Ответ:** Нестатические (внутренние) и статические(вложенные). Inner and nested.  
**Источник:** И.Блинов гл 5 Стр.131-138  

**Вопрос:** Для каких целей они используются?  
**Ответ:** Вложенный (netsted) класс должен создаваться только для того, чтобы обслуживать окружающий его класс.  
**Источник:** Блох Стр.148  

**Вопрос:** Какие уровни доступа применяются к таким классам?  
**Ответ:** Статический класс-член являетсястатическим членом своего внешнего класса и подчиняется тем же правилам доступа, что и другие статические члены.  
**Источник:** Блох Стр.149  

**Вопрос:** Какие существуют варианты внутренних классов?  
**Ответ:** Существует 4 категории вложенных классов: статичечкий класс-член(static member class), нестатический класс-член(nonstatic member class), анонимный класс(anonimus class) и локальный класс(local class).  
**Источник:** Блох Стр.149  

**Вопрос:** Пусть объявлен класс Outer, а внутри него публичный вложенный класс NestedPublic и публичный внутренний класс InnerPublic. Создайте экземпляры каждого класса:
а) внутри класса Outer,
б) извне класса Outer?  
**Ответ:**
а) NestedPublic n = new NestedPublic();
InnerPublic i = new InnerPublic();  
б) Outer.NestedPublic n =new Outer.NestedPublic();
Outer.InnerPublic i = new Outer().new InnerPublic();  
**Источник:** Блинов Стр.132  

**Вопрос:** Пусть объявлен класс Outer, а внутри него приватный вложенный класс NestedPrivate и приватный внутренний класс InnerPrivate. Создайте экземпляры каждого класса:
а) внутри класса Outer,
б) извне класса Outer?  
**Ответ:**
а) NestedPrivate n = new NestedPrivate();  
б) InnerPrivate i = new InnerPrivate();
Внутренний класс может быть объявлен как private, что обеспечивает его полную  невидимость  вне  класса-владельца  инадежное  сокрытие  реализации.  
**Источник:** Блинов Стр.133  

**Вопрос:** Пусть объявлен класс Outer, а внутри него внутренний класс Inner. Как обратиться внутри класса Inner:
а) к экземпляру класса Inner,
б) к объемлющему экземпляру класса Outer?  
**Ответ:** 
а) .this  
б) Outer.this;  
**Источник** Б.Эккель Стр.248  

**Вопрос:** Пусть объявлен класс Outer, а внутри него вложенный класс Nested. Как обратиться внутри класса Nested:
а) к экземпляру класса Nested,
б) к объемлющему экземпляру класса Outer?  
**Ответ:**
а) this  
б) невозможно обратиться к существующему объекту, можно только создать новый.  

**Вопрос:** Можно ли из вложенного класса обратиться к членам внешнего класса?
Если да, то приведите пример.  
**Ответ:**
Да.
Вложенные статические классы могут обращаться к нестатическим членам включающего класса не напрямую, а только через его объект. Нестатические внутренние классы имеют доступ ко всем переменным и методам своего внешнего класса-владельца.
```java
puplic class A{
    private int outer = 6;
    public class Inner{
        public int add(){
            return outer+1;
        }
    }
}
```  
**Источник:** Блинов Стр.132  

**Вопрос:** Можно ли из внутреннего класса обратиться к экземпляру внешнего класса?
Если да, то приведите пример.  
**Ответ:**
Да.
```java
public class Ouner {
    public class Inner {
       public Ouner outerIn() {
          return Ouner.this;
       }
    }
}
```  
**Источник:** Б.Эккель Стр.248  

**Вопрос:** Можно ли определить экземпляр вложенного класса, не определяя экземпляры внешнего класса?
Если да, то приведите пример.  
**Ответ:** Можно:
~~~java
    Ship.Motor motor = new Ship.Motor();
~~~  

**Вопрос:** Есть ли ограничения на объявление локальных переменных в локальных внутренних классах?
Есть ли да, то какие?  
**Ответ:** Локальные классы могут объявляться только внутри того блока кода/метода, в котором они были созданы.  

**Вопрос:** Можно ли наследовать вложенные классы?
Если да, то приведите пример.  
**Ответ:** Можно
~~~java
    public class Motor extends Ship.Engine {
        public Motor(Ship obj) { 
            obj.super();
        }
    }
~~~  

**Вопрос:** Можно ли из подкласса обратиться к методу вложенного суперкласса?
Если да, то приведите пример.  
**Ответ:**
```java
public class Outer {
    public static class NestedPublic{
        static public void some() {
            System.out.println(10);
            }
        }
}
public class Main extends Outer.NestedPublic{
public static void main(String[] args) {
Outer.NestedPublic.some();
}
}
```
Для создания объекта вложенного класса объект внешнего класса со-здавать нет необходимости. Подкласс вложенного класса неспособен унасле-довать возможность доступа кчленам внешнего класса, которыми наделен его суперкласс.  
**Источник:** Блинов Стр.139

**Вопрос:** Какие существуют варианты внутренних интерфейсов?  
**Ответ:** Интерфейсы могут быть вложены в класс или в другой интерфейс. В таком случае они могут иметь следующие модификаторы доступа: public, private, protected.  

**Вопрос:** Можно ли объявить класс внутри интерфейса? Если да, то есть ли ограничения? Приведите пример.  
**Ответ:** Да. Если класс вложен в интерфейс, то он становится статическим по умолчанию.
~~~java
public interface University {
    int NUMBER_FACULTY = 20;
    void create();
    class LearningDepartment { // static по умолчанию
        publicint idChief;
        publicstaticvoid assignPlan(int idFaculty) {
            // реализация                  
        }
        publicvoid acceptProgram() {
            // реализация
        }
    }
}
~~~  
**Источник:** И.Блинов ,с.139  

**Вопрос:** Можно ли создать экземпляр анонимного класса на основе:
а) абстрактного класса?
б) интерфейса?
в) неабстрактного класса?
г) финального класса?
Если да, то приведите пример.  
**Ответ:** а) да
~~~java
public abstract class Outer {}
public class Main {
    public static void main(String[] args) {
        Outer out = new Outer() {}; 
    }
}
~~~  
б) да
~~~java
public interface Outer {}
public class Main {
    public static void main(String[] args) {
        Outer out = new Outer() {};
    }
}
~~~  
в) да
~~~java
public class Outer {}
public class Main {
    public static void main(String[] args) {
        Outer out = new Outer() {};
    }
}
~~~  
г) нет  

**Вопрос:** Дан следующий java-файл.
~~~java
class Runner {
    public static void main(String[] args){
        Something something = new Something();
        something.doSomething(...);		//1
    }
}
interface Smthable {
    void doSmth(); 
}
class Something {
    void doSomething(...) {			//2
        smth.doSmth(); 
    }
}
~~~
1. Замените многоточия в строках 1 и 2 на такой код, чтобы приложение после запуска с помощью экземпляра анонимного класса, порожденного от интерфейса Smthable, вывело на консоль текст Hello, World.
2. Получите тот же результат, переместив:
   а) интерфейс Smthable внутрь класса Something,
   б) класс Something внутрь интерфейса Smthable.  
**Ответ:** 1.
~~~java
class Runner {
    public static void main(String[] args){
        Something something = new Something();
        Smthable smth = new Smthable() {
            @Override
            public void doSmth() {
                System.out.println("Hello World");
            }
        };
        something.doSomething(smth);		//1
    }
}
interface Smthable {
    void doSmth();
}
class Something {
    void doSomething(Smthable smth) {			//2
        smth.doSmth();
    }
}
~~~  
2. а)
~~~java
class Runner {
    public static void main(String[] args){
        Something something = new Something();
        Something.Smthable smth = new Something.Smthable() {
            @Override
            public void doSmth() {
                System.out.println("Hello World");
            }
        };
        something.doSomething(smth);		//1
    }
}
class Something {
    interface Smthable {
        void doSmth();
    }
    void doSomething(Smthable smth) {			//2
        smth.doSmth();
    }

}
~~~  
б)
~~~java
 class Runner {
    public static void main(String[] args){
        Smthable.Something something = new Smthable.Something();
        Smthable smth = new Smthable() {
            @Override
            public void doSmth() {
                System.out.println("Hello World");
            }
        };
        something.doSomething(smth);		//1
    }
}

interface Smthable {
    class Something {
        void doSomething(Smthable smth) {			//2
            smth.doSmth();
        }
    }
    void doSmth();
}
~~~  

**Вопрос:** Дан следующий java-файл.
~~~java
abstract class AbstractRunner {
   abstract int getYear();
   abstract class AbstarctInner {
      abstract int getYear();
   }
   public static void main(String[] args) {
   ... //1
   ... //2
   ... //3
   }
}
~~~
Создайте в строке 1 ссылку runner на экземпляр подкласса класса AbstractRunner.
Создайте в строке 2 ссылку inner на экземпляр подкласса класса AbstractInner.
Выведите на консоль в строке 3 текст 2010;2015, используя данные ссылки.  
**Ответ:**
~~~java
abstract class AbstractRunner {
    abstract int getYear();
    abstract class AbstarctInner {
        abstract int getYear();
    }
    public static void main(String[] args) {
        AbstractRunner runner = new AbstractRunner() {
            @Override
            int getYear() {
                return 2010;
            }
        };
        AbstractRunner.AbstarctInner inner = runner.new AbstarctInner(){
    
            @Override
            int getYear() {
                return 2015;
            }
        };
	    System.out.println(runner.getYear() + ";" + inner.getYear());
	}
}
~~~  

**Вопрос:** Дан следующий java-файл.
~~~Java
class Runner {
   public static void main(String[] args) {
      ... 	//1
   }
}
class Outer { 
    class Inner { 
        void go() { 
            System.out.println("Gone!"); 
        }
    }
}
~~~
1. С помощью функционала классов Outer и Inner выведите на консоль в строке 1 текст Gone!.
2. Переместив класс Outer внутрь класса Runner, получите тот же результат:
   а) не изменяя строку 1.
   б) изменяя строку 1,  
**Ответ:**
1.
~~~java
class Runner {
    public static void main(String[] args) {
        new Outer().new Inner().go();
    }
}
class Outer {
    class Inner {
        void go() {
            System.out.println("Gone!");
        }
    }
}
~~~  
2. a.
~~~java
class Runner {
    public static void main(String[] args) {
        class Outer {
            class Inner {
                void go() {
                    System.out.println("Gone!");
                }
            }
        };
        new Outer().new Inner().go();
    }
}
~~~
б.  
~~~java
package by.gsu.epamlab;

class Runner {
   class Outer {
      class Inner {
         void go() {
            System.out.println("Gone!");
         }
      }
   }

   public static void main(String[] args) {
      new Runner().new Outer().new Inner().go();
   }
}
~~~  

**Вопрос:** Что представляют собой элементы перечисления?  
**Ответ:** Перечисления представляют набор логически связанных констант. Объявление перечисления происходит с помощью оператора enum, после которого идет название перечисления. Затем идет список элементов перечисления через запятую.  
**Источник:** https://metanit.com/java/tutorial/3.8.php  

**Вопрос:** Как образуются имена вложенных и внутренних .class-файлов после компиляции?  
**Ответ:**
```java
publicclass Ship {
    publicclass Engine {
        public void launch() {
            System.out.println("Запускдвигателя");}   
}}
```
При компиляции создается объектный модуль, соответствующий внутреннему классу, который получит имя Ship$Engine.class.  
**Источник** И.Блинов Стр.133  

**Вопрос:** Может ли вложенный класс быть раннер-классом?  
**Ответ:** Да, может, вложенный класс логически связан с классом-владельцем, но может быть использован независимо от него. При объявлении такого внутреннего класса присутствует служебное слово static, и такой класс называется вложенным (nested). Статический метод вложенного класса вызывается при указании полного относительного пути к нему.
```java
package by.bsu.nested;
public interface University {
    int NUMBER_FACULTY = 20;
    void create();
    class LearningDepartment { // static по умолчанию
        public int idChief;
        public static void assignPlan(int idFaculty) {
            // реализация
        }
        public void acceptProgram() {
            // реализация
        }
    }
}
```  
**Источник:** И.Блинов Стр.139-140  

**Вопрос:** Может ли внутренний класс быть раннер-классом?  
**Ответ:** Нет, не может, внутренние классы не могут содержать статические атрибуты и методы, кроме констант (final static).  
**Источник:** И.Блинов Стр.133  

**Вопрос:** Может ли интерфейс иметь раннер-класс?  
**Ответ:** Нет, нельзя, потому что метод main в Runner классе должен быть статичным, чтобы использоваться как точка входа, а интерфейсы не позволяют использовать статические.  
**Источник:** https://progi.pro/mozhem-li-mi-imet-main-v-interfeyse-i-raznie-realizacii-dlya-main-v-klassah-realizuyushih-etot-interfeys-1113632