package lab_work_4.functions.meta;

import lab_work_4.functions.Function;

/**
 * Класс Power
 * Объекты данного класса представляет собой функцию, являющеюся степенью другой функции
 * */
public class Power implements Function {

    /**
     * Основание
     * */
    private Function base;

    /**
     * Показатель
     * */
    private Function exponent;

    /**
     * Левая граница области определения
     * */
    private double leftDomainBorder;

    /**
     * Правая граница области определения
     * */
    private double rightDomainBorder;

    /**
     * Конструктор
     * */
    public Power(Function base, Function exponent) {
        this.base=base;
        this.exponent=exponent;
        leftDomainBorder=base.getLeftDomainBorder();
        rightDomainBorder=base.getRightDomainBorder();
    }

    /**
     * Метод получения левой границы области определения
     * */
    public double getLeftDomainBorder()
    {
        return leftDomainBorder;
    }

    /**
     * Метод получения правой границы области определения
     * */
    public double getRightDomainBorder()
    {
        return rightDomainBorder;
    }

    /**
     * Метод получения значения функции
     * */
    public double getFunctionValue(double x)
    {
        return Math.pow(base.getFunctionValue(x),exponent.getFunctionValue(x));
    }
}
