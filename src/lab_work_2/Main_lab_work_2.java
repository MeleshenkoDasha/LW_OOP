package lab_work_2;

import lab_work_2.functions.*;

public class Main_lab_work_2 {

    public static void test_class_FunctionPoint_lab2()
    {
        System.out.println("-------------------");
        System.out.println("Рассмотрим создание точки fPoint_1 с нулевыми координатами (используем конструктор без параметров):");
        FunctionPoint fPoint_1 = new FunctionPoint();
        System.out.println("Рассмотрим точку fPoint_1:\nКоордината точки fPoint_1 по оси X: " + fPoint_1.getX() + "\nКоордината точки fPoint_1 по оси Y: " + fPoint_1.getY());
        System.out.println("-------------------");
        System.out.println("Рассмотрим создание точки fPoint_2 по заданным координатам (используем конструктор с параметрами, которые обозначают координаты точки):");
        FunctionPoint fPoint_2 = new FunctionPoint(-1, -2);
        System.out.println("Рассмотрим создание точки fPoint_2 (Входные данные для создания точки координата по оси X = "+ -1+", координата по оси Y = " + -2 + "):");
        System.out.println("Рассмотрим точку fPoint_2:\nКоордината точки fPoint_2 по оси X: " + fPoint_2.getX() + "\nКоордината точки fPoint_2 по оси Y: " + fPoint_2.getY());
        System.out.println("-------------------");
        System.out.println("Рассмотрим создание точки по существующей точке (используем конструктор с параметром, обозначающим точку с координатами):");
        System.out.println("Создадим точку fPoint_3 с нулевыми координатами:");
        FunctionPoint fPoint_3 = new FunctionPoint();
        System.out.println("Рассмотрим точку fPoint_3:\nКоордината точки fPoint_3 по оси X: " + fPoint_3.getX() + "\nКоордината точки fPoint_3 по оси Y: " + fPoint_3.getY());
        System.out.println("Изменим координаты точки fPoint_3:");
        fPoint_3.setX(5);
        fPoint_3.setY(8);
        System.out.println("Рассмотрим точку fPoint_3:\nКоордината точки fPoint_3 по оси X: " + fPoint_3.getX() + "\nКоордината точки fPoint_3 по оси Y: " + fPoint_3.getY());
        System.out.println("-------------------");
        System.out.println("Создадим точку fPoint_4 используя точку fPoint_3");
        FunctionPoint fPoint_4 = new FunctionPoint(fPoint_3);
        System.out.println("Рассмотрим точку fPoint_4:\nКоордината точки fPoint_4 по оси X: " + fPoint_4.getX() + "\nКоордината точки fPoint_4 по оси Y: " + fPoint_4.getY());
        System.out.println();
    }

    public static void test_class_TabulatedFunction_lab2()
    {
        System.out.println("-------------------");
        System.out.println("Создадим функцию func1, используя конструктор с параметрами в виде области определения и количества точек из этой области определения.");
        TabulatedFunction func1 = new TabulatedFunction(-2, 2, 5);
        System.out.println("Рассмотрим созданную функцию func1:");
        func1.printFunction(func1);
        System.out.println("-------------------");
        System.out.println("Создадим функцию func2, используя конструктор с параметрами в виде области определения и значения функции.");
        double[] values={0,1,-2,3,-4,5,-6,7,-8,9,-10};
        TabulatedFunction func2=new TabulatedFunction(-5,5,values);
        System.out.println("Рассмотрим созданную функцию func2:");
        func2.printFunction(func2);
        System.out.println("-------------------");
        System.out.println("Добавим новую точку, в функцию func2, с координатами (3.5, 15)");
        func2.addPoint(new FunctionPoint(3.5,15));
        System.out.println("Рассмотрим обновленную функцию func2:");
        func2.printFunction(func2);
        System.out.println("-------------------");
        System.out.println("Рассмотрим работу метода getFunctionValue, который возвращает значение функции в точке x.");
        System.out.println("Попытаемся получить значение вне области определения: " + func2.getFunctionValue(-6));
        System.out.println("Попытаемся получить значение из области определения: " + func2.getFunctionValue(-3));
        System.out.println("Попытаемся получить значение из области определения: " + func2.getFunctionValue(-3.5));
        System.out.println("-------------------");
        System.out.println("Рассмотрим работу метода setPoint, который заменяет указанную точку табулированной функции на заданную.");
        System.out.println("Заменим точку с координатами (3.5, 15) на точку с координатами (3.5, 10).");
        func2.setPoint(9, new FunctionPoint(3.5, 10));
        System.out.println("Рассмотрим обновленную функцию func2:");
        func2.printFunction(func2);
        System.out.println("-------------------");
        System.out.println("Рассмотрим работу методов по получению и изменению координат точки.");
        System.out.println("Получим координаты точки с индексом 9: x = " + func2.getPointX(9) + "; y = " + func2.getPointY(9));
        System.out.println("Заменим координаты точки с индексом 9: x = 3.4; y = 9.9");
        func2.setPointX(9, 3.4);
        func2.setPointY(9, 9.9);
        System.out.println("Получим обновленные координаты точки с индексом 9: x = " + func2.getPointX(9) + "; y = " + func2.getPointY(9) + ".");
        System.out.println("-------------------");
        System.out.println("Рассмотрим функцию func2:");
        func2.printFunction(func2);
        System.out.println("Удалим точку с индексом 9");
        func2.deletePoint(9);
        System.out.println("Рассмотрим обновленную функцию func2:");
        func2.printFunction(func2);
        System.out.println();
    }

    public static void run_lw_2()
    {
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        System.out.println("Демонстрация работы класса FunctionPoint: ");
        test_class_FunctionPoint_lab2();
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        System.out.println();
        System.out.println("Демонстрация работы класса ArrayTabulatedFunction: ");
        test_class_TabulatedFunction_lab2();
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");

    }


    public static void main(String[] args){
        run_lw_2();
    }
}
