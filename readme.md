# I'm a readme file and will tell about this project .
___

This project uses static classes, methods, fields and includes getters and setters.

## Acknowledgments
___
[**Dmitrii Tuchs**](https://github.com/dtuchs)


## About home tasks
___

- Добавить конструкторы, геттеры, сеттеры.

- Добавить статические данные к классам.

- Попробовать поработать со статическими вложенными классами.

## Steps
___
1. Create files readme.md, build.gradle, .gitignore.
2. Set a structure in the file readme.
3. Create a structure directories of the project and set used dependencies in build.gradle.
4. Create packages in the project and main file of project 'Building'.
5. Create `class Car` with getters and setters, static fields and class.
6. Add more comments into class Car.
7. Extra steps to the lesson 9 "Git".
   1. Change 1. Added the procedure `soundOfEngine` is which imitating a sound of an engine.
   2. Change 2. Added the function `calculateDistance` which calculates a maximal distance of a vehicle run.
   3. Change 3. Added the procedure `soundOnHorn` which to sound a horn.

## What's new?

### Java
1. Java: Is `null` unseriously? 
Ok, you take `java.lang.NullPointerException` right now!

### Gradle
### Selenide
### Git
1. Просмотр истории версий `git log`
2. Просмотр истории всех веток `git log --oneline --all --graph`
3. Просмотр индексированных и неиндексированных изменений `git diff`
4. Создание ветки от заданного коммита `git checkout -b gitnowtest ebd5b6b3b3aeeae72dc7fbd5ac66ac901a60c84e`


### Allure
### Resources
1. [About null](https://javarush.ru/groups/posts/1080-9-vejshey-o-null-v-java)  

### Miscellaneous
1. Types of a body: Седан(sedan), Универсал(station wagon), Хэтчбек(hatchback), Лифтбек(liftback), Crossover, Минивэн(Minivan) 


## Notes by the reviewer
Большое спасибо за обратную связь! 
Ниже приведены мои комментарии.
Если вопросы остались большая просьба сообщить, 
для исправления ошибок.

Заранее благодарен!

>У Вас свой подход - это круто! Но я бы сделал немного иначе:
Писать многострочные комментарии перед каждым методом и свойством - это избыточная информация.
Идеальный вариант, когда смотришь на код и читаешь его, как книгу. Без каких-либо комментариев.
Например,
public int getPower() {
return power;
}
Мы должны прочитать метод getPower() и сразу понять, что нам должна вернуться мощность двигателя. И комментарии здесь излишне. Только я бы переименовал метод на getEnginePower().

Не ставил задачу что-то сделать избыточным) Только тестил javadoc.  
 

>Относительно самого задания:
> 
>1. /*** Константа максимальная мощность двигателя */
>private static int MAXPOWER = 2500;
>Если Вы пишете, что это константа (причем static, то есть для всех экземпляров 
>класса она едина, тк не принадлежит им, а принадлежит классу), то стоит написать final.

По плану задания `MAXPOWER` и `MAXENGINEVOLUME` должны иметь возможность изменяться при использовании методов класса `static class Drawing`.
Поэтому здесь final не финал)

>2. Car() {
>   engineVolume = 0L;
>   power = 0;
>   body = null;
>   }
>   Вы устанавливаете значения переменным, которые по умолчанию и так их имеют. Например, для примитива int по умолчанию задано значение 0. Для класса, например, String - значение null.

При решении домашнего задания использовал 2 конструктора: Car(a, b, c), Car(Car car).
Если правильно понял, то дефолтный конструктор в таком случае не предоставляется java.

>3. Методы set() должны присваивать что-то куда-то. Например, setAge(int age) должен получать параметр извне и присваивать его нашей переменной в классе.
>   public boolean setEngineVolume(float engineVolume) {
>   if (engineVolume < 0f || engineVolume >= Car.MAXENGINEVOLUME) {
>   System.out.println(format("Значение объема двигателя %3.1f вне диапазона [%3.1f, %3.1f)",
>   engineVolume, 0f, Car.MAXENGINEVOLUME));
>   return false;
>   } else {
>this.engineVolume = ((int)(engineVolume*10))/10.0f;
>return true;
>}
>}
>У Вас же сеттер возвращает boolean...
> 
В ответе постарался наполнить сеттеры ограничитительной логикой.
Для сообщения о проблемах сделал возврат статуса операции.
Если все норм, то входное значение присваивается полю 
`this.engineVolume = ((int)(engineVolume*10))/10.0f;`
и
`this.power = power;`


>4. Car(float engineVolume, int power, Boby body) {
>   if (!setEngineVolume(engineVolume))
>   setEngineVolume(0f);
>   if (!setPower(power))
>   setPower(0);
>   setBody(body);
>   }
>   Здесь странная реализация у Вас. 
>Мы получаем ряд параметров, а потом просто их присваиваем.
>Приведите сеттеры к нормальному виду. 
>Тогда все будет просто: setPower(power).

В моей реализации есть логика, которая ограничивает 
возможные значения полей объекта, 
в частности [0, MAX] для полей объем и мощность, 
поэтому приходится при инициализации полей объектов использовать 
проверку, так как есть сеттеры, которые реализуют проверку, вызываю их.

>5. Car(Car car) {
>   if (car != null){
>   setEngineVolume(car.engineVolume);
>   setPower(car.power);
>   setBody(car.body);
>   }
>   }
>Мы в конструктор класса Car передаем экземпляр класса Car. 
>Что и зачем? Вы просто хотите создать дубликат экземпляра класса?
> 

Да, "глубокое" копирование. 



