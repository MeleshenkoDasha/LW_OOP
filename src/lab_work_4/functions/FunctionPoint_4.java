package lab_work_4.functions;

import java.io.Serializable;

/**
 * Класс FunctionPoint_4.
 * Объекты данного класса описывают одну точку табулированной функции
 * */
public class FunctionPoint_4 implements Serializable {

    /**
     * Поскольку точка функции описывается двумя координатами:
     * по оси абсцисс (ось X) и по оси ординат (ось Y)
     * то нам потребуется два приватных поля для описания объекта,
     * которые будут интерпретироваться как координаты по осям X и Y
     * */
    // Координата точки функции по оси X
    private double x;

    // Координата точки функции по оси Y
    private double y;

    /**
     * Опишем методы доступа и модификации объектов класса FunctionPoint_4
     * Методами доступа являются методы get. Они позволяют получить значения атрибутов класса FunctionPoint_4, входные параметры отсутствуют
     * Методы set - методы модификации. Они позволяют изменить значения атрибутов класса FunctionPoint_4.
     * На вход set-методы принимают значения, которые необходимо присвоить атрибуту объекта.
     * */

    // Метод получения значения координаты точки функции по оси X
    public double getX()
    {
        return this.x;
    }

    // Метод получения значения координаты точки функции по оси Y
    public double getY()
    {
        return this.y;
    }

    // Метод изменения значения координаты точки функции по оси X
    public void setX(double x)
    {
        this.x = x;
    }

    // Метод изменения значения координаты точки функции по оси Y
    public void setY(double y)
    {
        this.y = y;
    }

    /**
     * Опишем конструкторы класса FunctionPoint_4
     * */

    /**
     *  Конструктор FunctionPoint_4(double x, double y) осуществляет создание и инициализацию объекта типа FunctionPoint_4.
     *  Инициализацию объекта производим входными значениями из конструктора, для установки значения используем ранее описанные set-методы
     * */
    public FunctionPoint_4(double x, double y){
        setX(x);
        setY(y);
    }

    /**
     *  Конструктор FunctionPoint_4(FunctionPoint_4 point) осуществляет создание и инициализацию объекта типа FunctionPoint_4.
     *  Инициализацию объекта производим используя данные входного объекта.
     *  Для этого вначале получаем значения при помощи get-методов, а далее инициализируем наш объект используя set-методы
     * */
    public FunctionPoint_4(FunctionPoint_4 point){
        setX(point.getX());
        setY(point.getY());
    }

    /**
     *  Конструктор FunctionPoint_4() осуществляет создание и инициализацию объекта типа FunctionPoint_4.
     *  Инициализацию объекта производим используя нулевые значения.
     * */
    public FunctionPoint_4(){
        setX(0);
        setY(0);
    }

    /**
     * Расчет значения функции по прямой
     * */
    public static double getValueOnLine(FunctionPoint_4 left, FunctionPoint_4 right, double x){
        if(Double.compare(x, left.getX()) == -1 || Double.compare(x, right.getX()) ==1)
        {
            return Double.NaN;
        }
        double x0=left.getX();
        double y0=left.getY();
        double dx=right.getX()-x0;
        double dy=right.getY()-y0;
        return (dy/dx)*(x-x0)+y0;
    }

    /**
     * Переопределение метода, для вывода объекта в консоль
     * */
    @Override
    public String toString()
    {
        return "( "+x+" ; "+y+" )";
    }

}

