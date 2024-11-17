package lab_work_3;

import lab_work_3.functions.*;

import java.io.*;

public class Main_lab_work_3 {

    public static void test_class_ArrayTabulatedFunction_lab3() {
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        System.out.println("Создадим функцию func1, используя конструктор с параметрами в виде области определения и количества точек из этой области определения.");
        ArrayTabulatedFunction func1 = new ArrayTabulatedFunction(0, 1, 12);
        func1.printFunction(func1);
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        System.out.println("Создадим функцию func2, используя конструктор с параметрами в виде области определения и значений функции.");
        double[] arr = {1., 2., 3., 4., 5., 6., 7., 8., 9., 10.};
        ArrayTabulatedFunction func2 = new ArrayTabulatedFunction(1, 10, arr);
        System.out.println("Посмотрим границы функцию func2:");
        System.out.println("Левая граница: " + func2.getLeftDomainBorder());
        System.out.println("Правая граница: " + func2.getRightDomainBorder());
        func2.printFunction(func2);
        System.out.println("-------------------");
        System.out.println("Количество точек функции (метод getPointsCount): " + func2.getPointsCount());
        System.out.println("Значение функции в точке (x=5): " + func2.getFunctionValue(5));
        System.out.println("Значение функции в точке (x=5.5): " + func2.getFunctionValue(5.5));
        System.out.println("-------------------");
        System.out.println("Получим точку по ее индексу:");
        try {
            System.out.println("Получение точки по индексу: " + func2.getPoint(1));
            System.out.println("Получение точки по индексу: " + func2.getPoint(15));
        }
        catch (Exception e) {
            System.out.println("что-то пошло не так... " + e.getMessage());
            func2.printFunction(func2);
        }
        System.out.println("-------------------");
        System.out.println("Изменим точку по индексу:");
        try{
            func2.setPoint(0, new FunctionPoint(-2, 5));
            func2.printFunction(func2);
            func2.setPoint(1, new FunctionPoint(-3, 5));
            func2.printFunction(func2);
        }
        catch (Exception e)
        {
            System.out.println("что-то пошло не так... " + e.getMessage());
            func2.printFunction(func2);
        }
        func2.printFunction(func2);
        System.out.println("-------------------");
        System.out.println("Получим координаты точки по индексу:");
        try
        {
            System.out.println("Получим координату X по индексу = 1: " + func2.getPointX(1));
            System.out.println("Получим координату Y по индексу = 0: " + func2.getPointY(0));
            System.out.println("Получим координату X по индексу = -1: " + func2.getPointX(-1));
            System.out.println("Получим координату Y по индексу = 15: " + func2.getPointY(15));
        }
        catch (Exception e)
        {
            System.out.println("что-то пошло не так... " + e.getMessage());
            func2.printFunction(func2);
        }
        System.out.println("-------------------");
        System.out.println("Попробуем изменить координаты точки по индексу:");
        try
        {
            func2.setPointX(5, 1);
            func2.printFunction(func2);
            func2.setPointX(6, 6.5);
            func2.printFunction(func2);
            func2.setPointY(5, 1);
            func2.printFunction(func2);
        }
        catch (Exception e)
        {
            System.out.println("что-то пошло не так... " + e.getMessage());
            func2.printFunction(func2);
        }
        func2.printFunction(func2);
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        System.out.println("Создадим функцию func3, используя конструктор с параметрами в виде области определения и значений функции.");
        ArrayTabulatedFunction func3 = new ArrayTabulatedFunction(1, 10, arr);
        System.out.println("-------------------");
        System.out.println("Попробуем удалить точки функции");
        try
        {
            System.out.println("Удалим точку с индексом = 5");
            func3.deletePoint(5);
            func3.printFunction(func3);
            System.out.println("Удалим точку с индексом = 15");
            func3.deletePoint(15);
            func3.printFunction(func3);
        }
        catch (Exception e)
        {
            System.out.println("что-то пошло не так... " + e.getMessage());
            func3.printFunction(func3);
        }
        System.out.println("-------------------");
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        System.out.println("Создадим функцию func4, используя конструктор с параметрами в виде области определения и количества точек.");
        ArrayTabulatedFunction func4 = new ArrayTabulatedFunction(1, 10, 2);
        System.out.println("-------------------");
        System.out.println("Попробуем удалить точки функции");
        System.out.println("Количество точек функции (метод getPointsCount): " + func2.getPointsCount());
        System.out.println("Удалим точку с индексом 3");
        try {
            func4.deletePoint(3);
        }
        catch (Exception e) {
            System.out.println("что-то пошло не так... " + e.getMessage());
            func4.printFunction(func4);
        }
        System.out.println("-------------------");
        System.out.println("Попробуем добавить точки функции");
        try {
            func3.addPoint(new FunctionPoint(5, 5));
        } catch (Exception e) {
            System.out.println("что-то пошло не так... " + e.getMessage());
            func3.printFunction(func3);
        }
        func3.printFunction(func3);
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
    }

    public static void test_class_LinkedListTabulatedFunction_lab3(){
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        System.out.println("Создадим функцию func1, используя конструктор с параметрами в виде области определения и количества точек из этой области определения.");
        LinkedListTabulatedFunction func1 = new LinkedListTabulatedFunction(1., 10., 10);
        func1.printFunction(func1);
        double[] arr = {1., 2., 3., 4., 5., 6., 7., 8., 9., 10.};
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        System.out.println("Создадим функцию func2, используя конструктор с параметрами в виде области определения и значения функции.");
        LinkedListTabulatedFunction func2 = new LinkedListTabulatedFunction(1, 10, arr);
        System.out.println("получим границы области определения:");
        System.out.println("Левая граница области определения: " + func2.getLeftDomainBorder());
        System.out.println("Правая граница области определения: " + func2.getRightDomainBorder());
        func2.printFunction(func2);
        System.out.println("-------------------");
        System.out.println("Количество точек функции getPointsCount(): " + func2.getPointsCount());
        System.out.println("Значение функции в точке (x=5): " + func2.getFunctionValue(5));
        System.out.println("Значение функции в точке (x=5.5): " + func2.getFunctionValue(5.5));
        System.out.println("Получим точку по индексу");
        try
        {
            System.out.println("Получим точку по индексу = 1: " + func2.getPoint(1));
            func2.printFunction(func2);
            System.out.println("Получим точку по индексу = 15: " + func2.getPoint(15));
            func2.printFunction(func2);
        }
        catch (Exception e)
        {
            System.out.println("что-то пошло не так... " + e.getMessage());
            func2.printFunction(func2);
        }
        System.out.println("-------------------");
        System.out.println("Изменим точки по индексу");
        try {
            System.out.println("Замена по индексу = 0");
            func2.setPoint(0, new FunctionPoint(-2, 5));
            func2.printFunction(func2);
            System.out.println("Замена по индексу = 1");
            func2.setPoint(1, new FunctionPoint(-3, 5));
            func2.printFunction(func2);
        }
        catch (Exception e)
        {
            System.out.println("что-то пошло не так... " + e.getMessage());
            func2.printFunction(func2);
        }
        System.out.println("-------------------");
        System.out.println("Получим координаты точки по индексу");
        try
        {
            System.out.println(("Координата X точки с индексом = 1: " + func2.getPointX(1)));
            func2.printFunction(func2);
            System.out.println(("Координата Y точки с индексом = 0: " + func2.getPointY(0)));
            func2.printFunction(func2);
            System.out.println(("Координата X точки с индексом = -1: " + func2.getPointX(-1)));
            func2.printFunction(func2);
            System.out.println(("Координата Y точки с индексом = 15: " + func2.getPointY(15)));
            func2.printFunction(func2);
        }
        catch (Exception e)
        {
            System.out.println("что-то пошло не так... " + e.getMessage());
            func2.printFunction(func2);
        }
        System.out.println("-------------------");
        System.out.println("Заменим координаты точки по индексу");
        try
        {
            System.out.println("Заменим координату X точки по индексу = 5, x = 1");
            func2.setPointX(5, 1);
            System.out.println("Заменим координату X точки по индексу = 6, x = 6.5");
            func2.setPointX(6, 6.5);
            System.out.println("Заменим координату Y точки по индексу = 5, y=1");
            func2.setPointY(5, 1);
        }   catch (Exception e)
        {
            System.out.println("что-то пошло не так... " + e.getMessage());
            func2.printFunction(func2);
        }
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        System.out.println("Создадим функцию func3, используя конструктор с параметрами в виде области определения и значения функции.");
        LinkedListTabulatedFunction func3 = new LinkedListTabulatedFunction(1, 10, arr);
        System.out.println("Попробуем удалить точки функции");
        try
        {
            System.out.println("Удалим точку с индексом = 5");
            func3.deletePoint(5);
            func3.printFunction(func3);
            System.out.println("Удалим точку с индексом = 15");
            func3.deletePoint(15);
            func3.printFunction(func3);
        } catch (Exception e) {
            System.out.println("что-то пошло не так... " + e.getMessage());
            func3.printFunction(func3);
        }
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        System.out.println("Создадим функцию func4, используя конструктор с параметрами в виде области определения и количества точек функции.");
        LinkedListTabulatedFunction func4 = new LinkedListTabulatedFunction(1, 10, 2);
        try
        {
            System.out.println("Удалим точку с индексом = 3");
            func4.deletePoint(3);
            func3.printFunction(func3);
        } catch (Exception e) {
            System.out.println("что-то пошло не так... " + e.getMessage());
            func3.printFunction(func3);
        }
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        try
        {
            System.out.println("Добавим новую точку с координатами (5, 5))");
            func3.addPoint(new FunctionPoint(5, 5));
        } catch (Exception e) {
            System.out.println("что-то пошло не так... " + e.getMessage());
            func3.printFunction(func3);
        }
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
    }

    public static void run_lw_3()
    {
        System.out.println("Демонстрация работы класса ArrayTabulatedFunction:");
        test_class_ArrayTabulatedFunction_lab3();
        System.out.println("Демонстрация работы класса LinkedListTabulatedFunction:");
        test_class_LinkedListTabulatedFunction_lab3();
    }
    
    public static void main(String[] args) {
        run_lw_3();
    }
}
