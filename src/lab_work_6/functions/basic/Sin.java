package lab_work_6.functions.basic;

/**
 * Класс Sin
 * Объекты, данного класса вычисляют значение Синуса
 * Данный класс, расширяет ранее описанный общий класс TrigonometricFunction, который реализует интерфейс Function
 * */
public class Sin extends TrigonometricFunction {

    /**
     * Значение функции синуса в точке
     * */
    public double getFunctionValue(double x)
    {
        return Math.sin(x);
    }
}
