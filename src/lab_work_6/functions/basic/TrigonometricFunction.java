package lab_work_6.functions.basic;

import lab_work_6.functions.Function;


/**
 * Класс описывает тригонометрические функции определённые на промежутке (-inf, +inf)
 * Данный класс будет базовым для функций sin (синус), cos (косинус), tan (тангенс):
 * Это означает что в классе мы определяем общие параметры функций, и для частного случая будем просто переопределять метод,
 * по которому будем получать значение функции или, например, метод получения области определения
 */
public abstract class TrigonometricFunction implements Function {

    /**
     * Левая граница области определения
     * */
    public double getLeftDomainBorder()
    {
        return Double.NEGATIVE_INFINITY;
    }

    /**
     * Правая граница области определения
     * */
    public double getRightDomainBorder()
    {
        return Double.POSITIVE_INFINITY;
    }

    /**
     * Значение функции
     * */
    public double getFunctionValue(double x) {
        return 0.;
    }
}