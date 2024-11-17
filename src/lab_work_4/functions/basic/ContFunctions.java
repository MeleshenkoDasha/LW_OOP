package lab_work_4.functions.basic;

import lab_work_4.functions.Function;

/**
 * Класс описывает бесконечно дифференцируемые функции определённые на промежутке (-inf, +inf)
 * Данный класс будет базовым для функций Log (логарифм), Exp (экспонента), Const(константа):
 * Это означает что в классе мы определяем общие параметры функций, и для частного случая будем просто переопределять метод,
 * по которому будем получать значение функции или, например, метод получения области определения
 */
public abstract class ContFunctions implements Function {

    /**
     * Определим левую границу функции
     */
    public double getLeftDomainBorder() {
        return Double.NEGATIVE_INFINITY;
    }

    /**
     * Определим правую границу функции
     */
    public double getRightDomainBorder() {
        return Double.POSITIVE_INFINITY;
    }

    /**
     * Определим значение функции
     */
    public double getFunctionValue(double x) {
        return 0.;
    }
}