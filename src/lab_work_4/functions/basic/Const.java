package lab_work_4.functions.basic;

/**
 * Класс Const описывает функцию, которая является константой
 * например: y=C или y = 1
 * */
public class Const extends ContFunctions {

    /**
     * Сама константа
     * */
    private double y;

    /**
     * Конструктор
     * */
    public Const(double y)
    {
        this.y = y;
    }

    /**
     * Определим метод получения значения функции
     * */
    public double getFunctionValue(double x)
    {
        return y;
    }
}
