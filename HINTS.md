# Подсказки для решения задач 💡

## Серия B - Базовые операции

### TrainingB2 - Найти самого старшего пользователя
**Подсказка:** Используйте `max` с `Comparator.comparingInt`
```java
// Найти элемент с максимальным значением поля age
.max(Comparator.comparingInt(User::getAge))
.orElse(null)
```

### TrainingB3 - Посчитать вегетарианцев
**Подсказка:** Используйте `filter + count`
```java
// Отфильтровать и посчитать
.filter(User::isVegetarian)
.count()
```

### TrainingB4 - Получить имена software engineers
**Подсказка:** Используйте `filter` по Title + `map` для getName + `collect(toList)`
```java
// Фильтр -> Преобразование -> Сбор
.filter(user -> user.getTitle().equals(Title.SOFTWARE_ENGINEER))
.map(User::getName)
.collect(Collectors.toList())
```

### TrainingB5 - Первые два вегетарианца
**Подсказка:** Используйте `filter + limit(2) + collect(toList)`
```java
// Фильтр -> Ограничить количество -> Собрать
.filter(User::isVegetarian)
.limit(2)
.collect(Collectors.toList())
```

### TrainingB6 - Найти пользователя с зарплатой > X
**Подсказка:** Используйте `filter + findFirst + orElse`
```java
// Фильтр -> Найти первый -> Дефолтное значение
.filter(user -> user.getSalary() > salary)
.findFirst()
.orElse(null)
```

### TrainingB7 - Уникальные имена с зарплатой > X
**Подсказка:** Используйте `filter + map + collect(toSet)`
```java
// Фильтр -> Преобразование -> Собрать в Set (автоматически уникальные)
.filter(user -> user.getSalary() > salary)
.map(User::getName)
.collect(Collectors.toSet())
```

### TrainingB8 - Фильтр по году + сортировка по зарплате
**Подсказка:** Используйте `filter + sorted + collect(toList)`
```java
// Фильтр -> Сортировка -> Сбор
.filter(user -> user.getStartYear() == year)
.sorted(Comparator.comparingDouble(User::getSalary))
.collect(Collectors.toList())
```

### TrainingB9 - Группировка engineers по вегетарианству
**Подсказка:** Используйте `filter` по Title + `collect(Collectors.groupingBy` по isVegetarian)
```java
// Фильтр -> Группировка
.filter(user -> user.getTitle().equals(Title.SOFTWARE_ENGINEER))
.collect(Collectors.groupingBy(User::isVegetarian))
```

---

## Серия C - Продвинутые операции

### TrainingC1 - Посчитать сотрудников каждой должности
**Подсказка:** Используйте `collect(Collectors.groupingBy` по Title + `Collectors.counting)`
```java
// Группировка по должности с подсчетом
.collect(Collectors.groupingBy(
    User::getTitle,
    Collectors.counting()
))
```

### TrainingC2 - Максимальная зарплата для каждой должности
**Подсказка:** Используйте `collect(Collectors.groupingBy` по Title + `Collectors.mapping + Collectors.maxBy)`

Это сложная задача! Есть несколько способов решения:

**Способ 1 - С collectingAndThen:**
```java
.collect(Collectors.groupingBy(
    User::getTitle,
    Collectors.collectingAndThen(
        Collectors.maxBy(Comparator.comparingDouble(User::getSalary)),
        opt -> opt.map(User::getSalary).orElse(0.0)
    )
))
```

**Способ 2 - С mapping:**
```java
.collect(Collectors.groupingBy(
    User::getTitle,
    Collectors.mapping(
        User::getSalary,
        Collectors.reducing(Double::max)
    )
))
// Но потребуется дополнительная обработка Optional
```

**Способ 3 - Простой (рекомендуется для начала):**
```java
.collect(Collectors.toMap(
    User::getTitle,
    User::getSalary,
    Double::max  // Функция слияния - берет максимум
))
```

### TrainingC3 - Уникальные языки всех пользователей
**Подсказка:** Используйте `flatMap` для развертывания списков языков + `distinct + collect(toList)`
```java
// Развернуть вложенные списки -> Уникальные -> Собрать
.flatMap(user -> user.getLanguages().stream())
.distinct()
.collect(Collectors.toList())
```

**Объяснение flatMap:**
- У каждого User есть List<Language>
- `map` даст нам Stream<List<Language>>
- `flatMap` "расплющивает" и даёт Stream<Language>

### TrainingC4 - Пользователь знающий английский с максимальной зарплатой
**Подсказка:** Используйте `filter` по языкам + `max` по зарплате + `orElse`
```java
// Фильтр по языку -> Найти максимум по зарплате
.filter(user -> user.getLanguages().contains(Language.ENGILISH))
.max(Comparator.comparingDouble(User::getSalary))
.orElse(null)
```

---

## 🎯 Общие паттерны

### Фильтрация
```java
.filter(user -> условие)
.filter(User::isVegetarian)  // method reference
```

### Преобразование
```java
.map(User::getName)  // преобразовать User в String
.map(user -> user.getSalary() * 1.1)  // увеличить зарплату на 10%
```

### Развертывание вложенных коллекций
```java
.flatMap(user -> user.getLanguages().stream())
```

### Ограничение количества
```java
.limit(5)  // первые 5 элементов
.skip(3)   // пропустить первые 3
```

### Сортировка
```java
.sorted(Comparator.comparing(User::getAge))  // по возрастанию
.sorted(Comparator.comparing(User::getAge).reversed())  // по убыванию
.sorted(Comparator.comparingInt(User::getAge))  // для int
.sorted(Comparator.comparingDouble(User::getSalary))  // для double
```

### Поиск
```java
.findFirst()   // первый элемент
.findAny()     // любой элемент
.max(comparator)  // максимальный
.min(comparator)  // минимальный
```

### Терминальные операции
```java
.count()  // количество
.collect(Collectors.toList())  // в список
.collect(Collectors.toSet())   // в множество (автоматически уникальные)
.collect(Collectors.toMap(...))  // в карту
.forEach(System.out::println)  // для каждого элемента
```

### Группировка
```java
// Простая группировка
.collect(Collectors.groupingBy(User::getTitle))

// Группировка с подсчетом
.collect(Collectors.groupingBy(User::getTitle, Collectors.counting()))

// Группировка со сбором в список
.collect(Collectors.groupingBy(User::getTitle, Collectors.toList()))
```

### Optional
```java
.orElse(null)  // вернуть null если Optional пустой
.orElse(defaultValue)  // вернуть значение по умолчанию
.orElseGet(() -> новыйОбъект)  // создать новый объект если пустой
.orElseThrow()  // бросить исключение если пустой
```

---

## ⚠️ Частые ошибки

### 1. Забыли терминальную операцию
```java
// ❌ Неправильно - ничего не произойдет
userList.stream().filter(User::isVegetarian);

// ✅ Правильно
userList.stream().filter(User::isVegetarian).collect(Collectors.toList());
```

### 2. Не обработали Optional
```java
// ❌ Неправильно - вернет Optional<User>
return userList.stream().max(Comparator.comparing(User::getAge));

// ✅ Правильно - вернет User или null
return userList.stream().max(Comparator.comparing(User::getAge)).orElse(null);
```

### 3. Перепутали map и flatMap
```java
// ❌ Неправильно - получим Stream<List<Language>>
userList.stream().map(User::getLanguages)

// ✅ Правильно - получим Stream<Language>
userList.stream().flatMap(user -> user.getLanguages().stream())
```

### 4. Забыли про Collectors при группировке
```java
// ❌ Неправильно
.collect(groupingBy(User::getTitle))

// ✅ Правильно
.collect(Collectors.groupingBy(User::getTitle))
```

---

## 🚀 Порядок решения (от простого к сложному)

1. **B3** - самая простая (filter + count)
2. **B2** - простая (max)
3. **B4** - простая (filter + map + collect)
4. **B6** - простая (filter + findFirst)
5. **B5** - средняя (filter + limit)
6. **B7** - средняя (filter + map + toSet)
7. **B8** - средняя (filter + sorted + collect)
8. **B9** - сложная (filter + groupingBy)
9. **C1** - сложная (groupingBy + counting)
10. **C3** - сложная (flatMap + distinct)
11. **C4** - сложная (filter + max)
12. **C2** - очень сложная (groupingBy + collectingAndThen)

---

## 💡 Если застряли

1. Посмотрите на метод V1 - что он делает шаг за шагом?
2. Каждая операция в цикле = одна операция в stream
3. Проверьте примеры в этом файле
4. Запустите тест чтобы увидеть что ожидается
5. Попробуйте разные подходы - в streams часто есть несколько способов решения!

**Удачи! 🎯**
