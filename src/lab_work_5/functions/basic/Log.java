package lab_work_5.functions.basic;

/**
 * Класс Log
 * Объекты, данного класса вычисляют значение логарифма по заданному основанию
 * Данный класс, расширяет ранее описанный общий класс ContFunctions, который реализует интерфейс Function
 * */
public class Log extends ContFunctions {

    /**
     * Атрибут base описывает основание логарифма
     * */
    private double base;

    // конструктор
    public Log(double base)
    {
        this.base = base;
    }

    // метод получения основания логарифма
    public double getBase()
    {
        return base;
    }

    // метод изменения основания логарифма
    public void setBase(double base)
    {
        this.base = base;
    }

    /**
     * Переопределим левую границу области определения
     * она должна быть не отрицательной
     * */
    public double getLeftDomainBorder()
    {
        return 0;
    }

    /**
     * Переопределим метод получения значения функции
     * */
    public double getFunctionValue(double x) {
        return Math.log(x)/Math.log(base);
    }
}

