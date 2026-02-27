# Примеры решений задач 🎯

> **Совет:** В каждой задаче есть комментарий с подсказкой какие операции использовать!
> Также смотрите файл **HINTS.md** для подробных объяснений.

## TrainingB3 - Посчитать вегетарианцев

### Задача
Посчитать количество вегетарианцев в списке пользователей.

### Подсказка в коде
```java
//TODO: Посчитать количество вегетарианцев (используйте filter + count)
```

## Оригинальное решение (V1) с циклом for
```java
public long getCountOfVegetarianUsersV1(List<User> userList) {
    long count = 0;
    for(User user:userList) {
        if(user.isVegetarian()) {
            count++;
        }
    }
    return count;
}
```

## Решение через Streams (V2)

### Вариант 1: С использованием count()
```java
public long getCountOfVegetarianUsersV2(List<User> userList) {
    return userList.stream()
        .filter(User::isVegetarian)
        .count();
}
```

### Вариант 2: С использованием Collectors.counting()
```java
public long getCountOfVegetarianUsersV2(List<User> userList) {
    return userList.stream()
        .filter(User::isVegetarian)
        .collect(Collectors.counting());
}
```

## Пошаговое объяснение

### Шаг 1: Создаём стрим
```java
userList.stream()
```
Преобразуем список в поток данных (stream).

### Шаг 2: Фильтруем
```java
.filter(User::isVegetarian)
```
Оставляем только тех пользователей, у которых `isVegetarian()` возвращает `true`.

**Примечание**: `User::isVegetarian` - это **method reference** (ссылка на метод), эквивалентно:
```java
.filter(user -> user.isVegetarian())
```

### Шаг 3: Считаем
```java
.count()
```
Подсчитываем количество элементов в стриме.

## Проверка решения
```bash
cd streamtest
./run.sh TrainingB3
```

Ожидаемый результат:
```
✓ Test passed!
Result: 5
```

## Другие примеры решений

### TrainingB2 - Найти самого старшего пользователя
```java
public User getOldestUserV2(List<User> userList) {
    return userList.stream()
        .max(Comparator.comparingInt(User::getAge))
        .orElse(null);
}
```

### TrainingB4 - Получить имена всех software engineers
```java
public List<String> getSoftwareEngineersNameV2(List<User> userList) {
    return userList.stream()
        .filter(user -> user.getTitle().equals(Title.SOFTWARE_ENGINEER))
        .map(User::getName)
        .collect(Collectors.toList());
}
```

### TrainingB5 - Получить первых двух вегетарианцев
```java
public List<User> getTwoVegeterianUserV2(List<User> userList) {
    return userList.stream()
        .filter(User::isVegetarian)
        .limit(2)
        .collect(Collectors.toList());
}
```

### TrainingB6 - Найти любого с зарплатой > X
```java
public User getUsersWhoEarnsMoreV2(List<User> userList, double salary) {
    return userList.stream()
        .filter(user -> user.getSalary() > salary)
        .findFirst()
        .orElse(null);
}
```

### TrainingC1 - Посчитать сотрудников каждой должности
```java
public Map<Title,Long> countEmployeesOfTitlesV2(List<User> userList) {
    return userList.stream()
        .collect(Collectors.groupingBy(
            User::getTitle,
            Collectors.counting()
        ));
}
```

## 💡 Общие принципы

1. **Начинайте со stream()** - преобразуйте коллекцию в поток
2. **Используйте промежуточные операции** - filter, map, sorted, limit, skip
3. **Завершайте терминальной операцией** - collect, count, findFirst, max, min
4. **Method references** - используйте `User::getName` вместо `user -> user.getName()`

## 🎯 Попробуйте сами!

Теперь попробуйте решить остальные задачи самостоятельно. Если застряли - посмотрите на примеры выше!

Удачи! 💪
