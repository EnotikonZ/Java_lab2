package org.example;

import java.util.Arrays;

/**
 * Main2Var9 — решения лабораторной работы №2 (вариант 9).
 *
 * Здесь пошагово выполняются все задания:
 *  1) Работа с точками.
 *  2) Работа с прямыми и связями между ними.
 *  3) Студенты и копирование массивов оценок.
 *  4) Создание точек только по координатам.
 *  5) Создание студентов одним конструктором.
 *  6) Средний балл и проверка "отличник".
 */
public class Main2Var9 {
    public static void main(String[] args) {

        // ========================================================
        // ЗАДАНИЕ 1. Точки
        // ========================================================
        System.out.println("=== Задание 1. Точки ===");

        // Создаём три точки с разными координатами
        Lab2Var9.Point point1 = new Lab2Var9.Point(1, 3);
        Lab2Var9.Point point2 = new Lab2Var9.Point(23, 8);
        Lab2Var9.Point point3 = new Lab2Var9.Point(5, 10);

        // Выводим их текстовое представление
        System.out.println("Точка 1: " + point1);
        System.out.println("Точка 2: " + point2);
        System.out.println("Точка 3: " + point3);

        // ========================================================
        // ЗАДАНИЕ 2. Линии
        // ========================================================
        System.out.println("\n=== Задание 2. Линии ===");

        // 1) Линия 1: начало {1;3}, конец {23;8}
        Lab2Var9.Point l1Start = new Lab2Var9.Point(1, 3);
        Lab2Var9.Point l1End   = new Lab2Var9.Point(23, 8);
        Lab2Var9.Line line1    = new Lab2Var9.Line(l1Start, l1End);

        // 2) Линия 2: горизонтальная, на высоте 10, от x=5 до x=25
        Lab2Var9.Point l2Start = new Lab2Var9.Point(5, 10);
        Lab2Var9.Point l2End   = new Lab2Var9.Point(25, 10);
        Lab2Var9.Line line2    = new Lab2Var9.Line(l2Start, l2End);

        // 3) Линия 3: начало там же, где line1, конец там же, где line2
        //    ВАЖНО: используем те же объекты точек (общие ссылки)
        Lab2Var9.Line line3    = new Lab2Var9.Line(l1Start, l2End);

        // Выводим все три линии
        System.out.println("Линия 1: " + line1);
        System.out.println("Линия 2: " + line2);
        System.out.println("Линия 3: " + line3);

        // 4) Меняем координаты линий 1 и 2, чтобы линия 3 автоматически изменилась
        System.out.println("\n-- Меняем координаты line1 и line2 так, чтобы line3 следовала за ними --");

        // Меняем координаты существующей точки начала line1
        l1Start.setX(0);
        l1Start.setY(0);
        // Меняем координаты существующей точки конца line1
        l1End.setX(10);
        l1End.setY(10);

        // Меняем координаты точки начала line2
        l2Start.setX(4);
        l2Start.setY(15);
        // Меняем координаты точки конца line2
        l2End.setX(30);
        l2End.setY(15);

        // Так как line3 использует l1Start и l2End, она "сама" меняет координаты
        System.out.println("Линия 1: " + line1);
        System.out.println("Линия 2: " + line2);
        System.out.println("Линия 3 (автоматически изменилась): " + line3);

        // 5) Меняем только line1 так, чтобы line3 не изменялась
        System.out.println("\n-- Меняем только line1 так, чтобы line3 не изменилась --");

        // Подменяем точки у line1 на НОВЫЕ объекты Point
        Lab2Var9.Point newStart = new Lab2Var9.Point(-5, -5);
        Lab2Var9.Point newEnd   = new Lab2Var9.Point(-10, -10);
        line1.setStart(newStart);
        line1.setEnd(newEnd);

        // Теперь line1 использует новые точки, а line3 осталась с l1Start и l2End
        System.out.println("Линия 1 (новые точки): " + line1);
        System.out.println("Линия 3 (осталась прежней): " + line3);

        // ========================================================
        // ЗАДАНИЕ 3. Студент и копирование оценок
        // ========================================================
        System.out.println("\n=== Задание 3. Студент и копирование оценок ===");

        // 1) Создаём студента Васю с оценками 3,4,5
        Lab2Var9.Student vasya = new Lab2Var9.Student("Вася", 3, 4, 5);

        // 2) Создаём Петю без оценок
        Lab2Var9.Student petya = new Lab2Var9.Student("Петя");
        // Копируем оценки Васи ПОВЕРХНОСТНО: присваиваем тот же массив
        petya.setGrades(vasya.getGrades());

        // 3) Меняем первую оценку у Пети
        petya.getGrades()[0] = 5;

        // Так как массив один и тот же, изменения видны и у Васи
        System.out.println("После изменения первой оценки у Пети:");
        System.out.println("Вася: " + vasya);
        System.out.println("Петя: " + petya);
        System.out.println("// Объяснение: у Васи и Пети один и тот же массив оценок в памяти.");

        // 4) Создаём Андрея и копируем оценки Васи ГЛУБОКО (новый массив)
        Lab2Var9.Student andrey = new Lab2Var9.Student("Андрей");
        // Arrays.copyOf создаёт новый массив с теми же значениями
        andrey.setGrades(Arrays.copyOf(vasya.getGrades(), vasya.getGrades().length));

        // Меняем одну из оценок у Васи, чтобы показать,
        // что оценки Андрея не изменятся
        vasya.getGrades()[1] = 2;

        System.out.println("\nПосле изменения оценок Васи:");
        System.out.println("Вася: " + vasya);
        System.out.println("Андрей: " + andrey);
        System.out.println("// Объяснение: у Андрея своя копия массива, он независим.");

        // ========================================================
        // ЗАДАНИЕ 4. Создаём Точки только по координатам
        // ========================================================
        System.out.println("\n=== Задание 4. Новые точки ===");

        // Точки создаются только через конструктор с X и Y
        Lab2Var9.Point tp1 = new Lab2Var9.Point(3, 5);
        Lab2Var9.Point tp2 = new Lab2Var9.Point(25, 6);
        Lab2Var9.Point tp3 = new Lab2Var9.Point(7, 8);

        // Выводим
        System.out.println("Точка 3;5  -> " + tp1);
        System.out.println("Точка 25;6 -> " + tp2);
        System.out.println("Точка 7;8  -> " + tp3);

        // ========================================================
        // ЗАДАНИЕ 5. Создание студентов одним конструктором
        // ========================================================
        System.out.println("\n=== Задание 5. Конструктор Student ===");

        // Студент с оценками
        Lab2Var9.Student sVasya = new Lab2Var9.Student("Вася", 3, 4, 5);
        // Студент без оценок
        Lab2Var9.Student sMaxim = new Lab2Var9.Student("Максим");

        System.out.println("Студент с оценками: " + sVasya);
        System.out.println("Студент без оценок: " + sMaxim);

        // ========================================================
        // ЗАДАНИЕ 6. Студент-отличник и средний балл
        // ========================================================
        System.out.println("\n=== Задание 6. Студент-отличник ===");

        // Вася с неидеальными оценками
        Lab2Var9.Student v = new Lab2Var9.Student("Вася", 3, 4, 5, 4);
        // Петя — все оценки 5
        Lab2Var9.Student p = new Lab2Var9.Student("Петя", 5, 5, 5, 5);

        // Выводим информацию о среднем балле и статусе "отличник"
        System.out.printf("%s | Средний балл: %.2f | Отличник: %b%n",
                v, v.getAverage(), v.isExcellent());
        System.out.printf("%s | Средний балл: %.2f | Отличник: %b%n",
                p, p.getAverage(), p.isExcellent());

    }
}
