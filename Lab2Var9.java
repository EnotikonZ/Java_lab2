package org.example;

import java.util.Arrays;

/**
 * В этом классе собраны все необходимые сущности:
 *  - Point   (Точка на плоскости)
 *  - Line    (Линия/отрезок между двумя точками)
 *  - Student (Студент с массивом оценок)
 */
public class Lab2Var9 {

    /**
     * Класс представляет точку на двумерной плоскости.
     * Точка описывается двумя координатами: X и Y.
     */
    public static class Point {
        // Координата X
        private double x;
        // Координата Y
        private double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        // Методы чтения
        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        // Методы изменения
        public void setX(double x) {
            this.x = x;
        }

        public void setY(double y) {
            this.y = y;
        }

        /**
         * Возвращает строковое представление точки
         * в формате {X;Y}, как требуют условия.
         */
        public String toString() {
            return "{" + x + ";" + y + "}";
        }
    }

    /**
     * Класс описывает линию (отрезок) на плоскости.
     * Линия задаётся начальной и конечной точками.
     */
    public static class Line {
        // Точка начала линии
        private Point start;
        // Точка конца линии
        private Point end;


        public Line(Point start, Point end) {
            this.start = start;
            this.end = end;
        }

        // Геттеры
        public Point getStart() {
            return start;
        }

        public Point getEnd() {
            return end;
        }

        // Сеттеры — позволяют заменить точки линии целиком
        public void setStart(Point start) {
            this.start = start;
        }

        public void setEnd(Point end) {
            this.end = end;
        }

        /**
         * Строковое представление линии
         * в формате "Линия от {X1;Y1} до {X2;Y2}".
         */
        public String toString() {
            return "Линия от " + start + " до " + end;
        }
    }

    /**
     * Класс представляет студента.
     * Студент имеет имя и массив целочисленных оценок.
     */
    public static class Student {
        // Имя студента
        private String name;
        // Массив оценок студента
        private int[] grades;

        public Student(String name, int... grades) {
            this.name = name;
            if (grades == null) {
                // Если передали null, создаём пустой массив
                this.grades = new int[0];
            } else {
                // Делаем копию массива оценок,
                // чтобы исходный массив нельзя было изменить извне
                this.grades = Arrays.copyOf(grades, grades.length);
            }
        }

        // Геттеры
        public String getName() {
            return name;
        }

        public int[] getGrades() {
            return grades;
        }

        public void setGrades(int[] newGrades) {
            this.grades = newGrades;
        }

        /**
         * Строковое представление студента:
         * "Имя: [оценка1, оценка2, ...]".
         */
        public String toString() {
            return name + ": " + Arrays.toString(grades);
        }

        /**
         * Возвращает среднюю оценку студента (double).
         * Если оценок нет, возвращает 0.
         */
        public double getAverage() {
            if (grades == null || grades.length == 0) {
                return 0.0;
            }
            double sum = 0;
            // Суммируем все оценки
            for (int g : grades) {
                sum += g;
            }
            // Делим сумму на количество оценок
            return sum / grades.length;
        }

        /**
         * Проверяет, является ли студент отличником.
         * Отличник — если:
         *  - у него есть хотя бы одна оценка;
         *  - все оценки равны 5.
         */
        public boolean isExcellent() {
            if (grades == null || grades.length == 0) {
                // Нет оценок — не отличник
                return false;
            }
            // Проверяем каждую оценку
            for (int g : grades) {
                if (g != 5) {
                    return false;
                }
            }
            // Все оценки = 5
            return true;
        }
    }
}
