package lab_work_6.functions.basic;

/**
 * Класс Cos
 * Объекты, данного класса вычисляют значение Косинуса
 * Данный класс, расширяет ранее описанный общий класс TrigonometricFunction, который реализует интерфейс Function
 * */
public class Cos extends TrigonometricFunction {

    /**
     * Значение функции косинуса в точке
     * */
    public double getFunctionValue(double x) {
        return Math.cos(x);
    }

}