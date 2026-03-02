package com.orcun.streamtraining.training;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 🎯 ФИНАЛЬНЫЙ ТЕСТ НАВЫКОВ JAVA STREAMS
 * 
 * 10 задач для проверки ваших знаний после основного тренинга.
 * Все задачи должны быть решены для прохождения теста!
 * 
 * Запуск: java -cp bin com.orcun.streamtraining.training.OHTest
 */
public class OHTest {

    // ============================================================
    // ЗАДАЧА 1: Сумма квадратов четных чисел
    // ============================================================
    //TODO: Найти сумму квадратов всех четных чисел в списке (используйте filter + mapToInt + sum)
    public int sumOfSquaresOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0,(past, newi) -> past + newi*newi);
    }

    // Эталонное решение
    private int sumOfSquaresOfEvenNumbersReference(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n * n)
                .sum();
    }

    // ============================================================
    // ЗАДАЧА 2: Самое длинное слово
    // ============================================================
    //TODO: Найти самое длинное слово в списке (используйте max + Comparator.comparingInt + orElse)
    public String findLongestWord(List<String> words) {
        return null; // Ваше решение здесь
    }

    // Эталонное решение
    private String findLongestWordReference(List<String> words) {
        return words.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("");
    }

    // ============================================================
    // ЗАДАЧА 3: Группировка по длине строки
    // ============================================================
    //TODO: Сгруппировать слова по их длине (используйте collect + Collectors.groupingBy)
    public Map<Integer, List<String>> groupWordsByLength(List<String> words) {
        return new HashMap<>(); // Ваше решение здесь
    }

    // Эталонное решение
    private Map<Integer, List<String>> groupWordsByLengthReference(List<String> words) {
        return words.stream()
                .collect(Collectors.groupingBy(String::length));
    }

    // ============================================================
    // ЗАДАЧА 4: Все уникальные символы из списка строк
    // ============================================================
    //TODO: Получить множество всех уникальных символов из всех строк (используйте flatMapToInt + distinct + collect)
    public Set<Character> getAllUniqueCharacters(List<String> words) {
        return new HashSet<>(); // Ваше решение здесь
    }

    // Эталонное решение
    private Set<Character> getAllUniqueCharactersReference(List<String> words) {
        return words.stream()
                .flatMapToInt(String::chars)
                .distinct()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
    }

    // ============================================================
    // ЗАДАЧА 5: Среднее значение положительных чисел
    // ============================================================
    //TODO: Найти среднее значение только положительных чисел (используйте filter + mapToInt + average + orElse)
    public double averageOfPositiveNumbers(List<Integer> numbers) {
        return 0.0; // Ваше решение здесь
    }

    // Эталонное решение
    private double averageOfPositiveNumbersReference(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n > 0)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    // ============================================================
    // ЗАДАЧА 6: Первые N чисел Фибоначчи
    // ============================================================
    //TODO: Сгенерировать первые N чисел Фибоначчи (используйте Stream.iterate + limit + collect)
    public List<Long> generateFibonacci(int n) {
        return new ArrayList<>(); // Ваше решение здесь
    }

    // Эталонное решение
    private List<Long> generateFibonacciReference(int n) {
        return Stream.iterate(new long[]{0, 1}, f -> new long[]{f[1], f[0] + f[1]})
                .limit(n)
                .map(f -> f[0])
                .collect(Collectors.toList());
    }

    // ============================================================
    // ЗАДАЧА 7: Разделить числа на четные и нечетные
    // ============================================================
    //TODO: Разделить список на две группы: четные (true) и нечетные (false) (используйте Collectors.partitioningBy)
    public Map<Boolean, List<Integer>> partitionEvenOdd(List<Integer> numbers) {
        return new HashMap<>(); // Ваше решение здесь
    }

    // Эталонное решение
    private Map<Boolean, List<Integer>> partitionEvenOddReference(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
    }

    // ============================================================
    // ЗАДАЧА 8: Конкатенация строк с разделителем
    // ============================================================
    //TODO: Объединить все строки из списка через запятую в верхнем регистре (используйте map + Collectors.joining)
    public String joinUppercase(List<String> words) {
        return ""; // Ваше решение здесь
    }

    // Эталонное решение
    private String joinUppercaseReference(List<String> words) {
        return words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(", "));
    }

    // ============================================================
    // ЗАДАЧА 9: Найти второе максимальное число
    // ============================================================
    //TODO: Найти второе по величине уникальное число (используйте distinct + sorted + skip + findFirst)
    public Optional<Integer> findSecondMax(List<Integer> numbers) {
        return Optional.empty(); // Ваше решение здесь
    }

    // Эталонное решение
    private Optional<Integer> findSecondMaxReference(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
    }

    // ============================================================
    // ЗАДАЧА 10: Частота появления каждого числа
    // ============================================================
    //TODO: Подсчитать сколько раз каждое число встречается в списке (используйте Collectors.groupingBy + Collectors.counting)
    public Map<Integer, Long> countFrequency(List<Integer> numbers) {
        return new HashMap<>(); // Ваше решение здесь
    }

    // Эталонное решение
    private Map<Integer, Long> countFrequencyReference(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));
    }

    // ============================================================
    // MAIN - ТЕСТИРОВАНИЕ ВСЕХ ЗАДАЧ
    // ============================================================
    public static void main(String[] args) {
        OHTest test = new OHTest();
        int passed = 0;
        int total = 10;

        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║      🎯 ФИНАЛЬНЫЙ ТЕСТ НАВЫКОВ JAVA STREAMS 🎯            ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.println();

        // Тест 1: Сумма квадратов четных чисел
        try {
            List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
            int expected1 = test.sumOfSquaresOfEvenNumbersReference(numbers1);
            int actual1 = test.sumOfSquaresOfEvenNumbers(numbers1);
            if (expected1 == actual1) {
                System.out.println("✓ Задача 1: Сумма квадратов четных чисел - PASSED");
                passed++;
            } else {
                System.out.println("✗ Задача 1: FAILED (Expected: " + expected1 + ", Got: " + actual1 + ")");
            }
        } catch (Exception e) {
            System.out.println("✗ Задача 1: FAILED (Exception: " + e.getMessage() + ")");
        }

        // Тест 2: Самое длинное слово
        try {
            List<String> words2 = Arrays.asList("cat", "elephant", "dog", "butterfly");
            String expected2 = test.findLongestWordReference(words2);
            String actual2 = test.findLongestWord(words2);
            if (expected2.equals(actual2)) {
                System.out.println("✓ Задача 2: Самое длинное слово - PASSED");
                passed++;
            } else {
                System.out.println("✗ Задача 2: FAILED (Expected: " + expected2 + ", Got: " + actual2 + ")");
            }
        } catch (Exception e) {
            System.out.println("✗ Задача 2: FAILED (Exception: " + e.getMessage() + ")");
        }

        // Тест 3: Группировка по длине строки
        try {
            List<String> words3 = Arrays.asList("hi", "cat", "dog", "bird", "fish");
            Map<Integer, List<String>> expected3 = test.groupWordsByLengthReference(words3);
            Map<Integer, List<String>> actual3 = test.groupWordsByLength(words3);
            if (expected3.equals(actual3)) {
                System.out.println("✓ Задача 3: Группировка по длине строки - PASSED");
                passed++;
            } else {
                System.out.println("✗ Задача 3: FAILED");
            }
        } catch (Exception e) {
            System.out.println("✗ Задача 3: FAILED (Exception: " + e.getMessage() + ")");
        }

        // Тест 4: Все уникальные символы
        try {
            List<String> words4 = Arrays.asList("hello", "world");
            Set<Character> expected4 = test.getAllUniqueCharactersReference(words4);
            Set<Character> actual4 = test.getAllUniqueCharacters(words4);
            if (expected4.equals(actual4)) {
                System.out.println("✓ Задача 4: Все уникальные символы - PASSED");
                passed++;
            } else {
                System.out.println("✗ Задача 4: FAILED");
            }
        } catch (Exception e) {
            System.out.println("✗ Задача 4: FAILED (Exception: " + e.getMessage() + ")");
        }

        // Тест 5: Среднее положительных чисел
        try {
            List<Integer> numbers5 = Arrays.asList(-5, 2, -3, 4, 6, -1, 8);
            double expected5 = test.averageOfPositiveNumbersReference(numbers5);
            double actual5 = test.averageOfPositiveNumbers(numbers5);
            if (Math.abs(expected5 - actual5) < 0.001) {
                System.out.println("✓ Задача 5: Среднее положительных чисел - PASSED");
                passed++;
            } else {
                System.out.println("✗ Задача 5: FAILED (Expected: " + expected5 + ", Got: " + actual5 + ")");
            }
        } catch (Exception e) {
            System.out.println("✗ Задача 5: FAILED (Exception: " + e.getMessage() + ")");
        }

        // Тест 6: Числа Фибоначчи
        try {
            List<Long> expected6 = test.generateFibonacciReference(8);
            List<Long> actual6 = test.generateFibonacci(8);
            if (expected6.equals(actual6)) {
                System.out.println("✓ Задача 6: Числа Фибоначчи - PASSED");
                passed++;
            } else {
                System.out.println("✗ Задача 6: FAILED (Expected: " + expected6 + ", Got: " + actual6 + ")");
            }
        } catch (Exception e) {
            System.out.println("✗ Задача 6: FAILED (Exception: " + e.getMessage() + ")");
        }

        // Тест 7: Разделение на четные/нечетные
        try {
            List<Integer> numbers7 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
            Map<Boolean, List<Integer>> expected7 = test.partitionEvenOddReference(numbers7);
            Map<Boolean, List<Integer>> actual7 = test.partitionEvenOdd(numbers7);
            if (expected7.equals(actual7)) {
                System.out.println("✓ Задача 7: Разделение на четные/нечетные - PASSED");
                passed++;
            } else {
                System.out.println("✗ Задача 7: FAILED");
            }
        } catch (Exception e) {
            System.out.println("✗ Задача 7: FAILED (Exception: " + e.getMessage() + ")");
        }

        // Тест 8: Конкатенация в верхнем регистре
        try {
            List<String> words8 = Arrays.asList("java", "streams", "api");
            String expected8 = test.joinUppercaseReference(words8);
            String actual8 = test.joinUppercase(words8);
            if (expected8.equals(actual8)) {
                System.out.println("✓ Задача 8: Конкатенация в верхнем регистре - PASSED");
                passed++;
            } else {
                System.out.println("✗ Задача 8: FAILED (Expected: \"" + expected8 + "\", Got: \"" + actual8 + "\")");
            }
        } catch (Exception e) {
            System.out.println("✗ Задача 8: FAILED (Exception: " + e.getMessage() + ")");
        }

        // Тест 9: Второе максимальное число
        try {
            List<Integer> numbers9 = Arrays.asList(5, 1, 8, 3, 8, 2, 7);
            Optional<Integer> expected9 = test.findSecondMaxReference(numbers9);
            Optional<Integer> actual9 = test.findSecondMax(numbers9);
            if (expected9.equals(actual9)) {
                System.out.println("✓ Задача 9: Второе максимальное число - PASSED");
                passed++;
            } else {
                System.out.println("✗ Задача 9: FAILED (Expected: " + expected9 + ", Got: " + actual9 + ")");
            }
        } catch (Exception e) {
            System.out.println("✗ Задача 9: FAILED (Exception: " + e.getMessage() + ")");
        }

        // Тест 10: Частота появления чисел
        try {
            List<Integer> numbers10 = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
            Map<Integer, Long> expected10 = test.countFrequencyReference(numbers10);
            Map<Integer, Long> actual10 = test.countFrequency(numbers10);
            if (expected10.equals(actual10)) {
                System.out.println("✓ Задача 10: Частота появления чисел - PASSED");
                passed++;
            } else {
                System.out.println("✗ Задача 10: FAILED");
            }
        } catch (Exception e) {
            System.out.println("✗ Задача 10: FAILED (Exception: " + e.getMessage() + ")");
        }

        // Итоговый результат
        System.out.println();
        System.out.println("════════════════════════════════════════════════════════════");
        System.out.println("  📊 РЕЗУЛЬТАТ: " + passed + " / " + total);
        System.out.println("════════════════════════════════════════════════════════════");
        
        if (passed == total) {
            System.out.println();
            System.out.println("  🎉🎉🎉 ПОЗДРАВЛЯЕМ! ВЫ МАСТЕР JAVA STREAMS! 🎉🎉🎉");
            System.out.println();
            System.out.println("  Вы успешно решили все задачи!");
            System.out.println("  Теперь вы готовы использовать Stream API в реальных проектах!");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("  💪 Почти получилось! Осталось решить: " + (total - passed) + " задач(и)");
            System.out.println("  Подсказка: проверьте HINTS.md для помощи");
            System.out.println();
        }
    }
}
