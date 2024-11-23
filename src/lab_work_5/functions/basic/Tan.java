package lab_work_5.functions.basic;

/**
 * Класс Tan
 * Объекты, данного класса вычисляют значение Тангенса
 * Данный класс, расширяет ранее описанный общий класс TrigonometricFunction, который реализует интерфейс Function
 * */
public class Tan extends TrigonometricFunction {

    /**
     * Значение функции тангнеса в точке
     * */
    public double getFunctionValue(double x)
    {
        return Math.tan(x);
    }
}