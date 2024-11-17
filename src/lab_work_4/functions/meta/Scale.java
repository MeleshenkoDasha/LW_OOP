package lab_work_4.functions.meta;

import lab_work_4.functions.Function;

/**
 * Класс Scale
 * Объекты данного класса представляют собой функцию, полученную из исходной функций путём масштабирования вдоль осей координат
 * */
public class Scale implements Function {
    /**
     * Базовая функция
     * */
    private Function base;

    /**
     * Коэффициент масштабирования по оси X
     * */
    private double factorX;

    /**
     * Коэффициент масштабирования по оси Y
     * */
    private double factorY;

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
    public Scale(Function base, double factorX, double factorY) {
        this.base = base;
        this.factorX = factorX;
        this.factorY=factorY;
        leftDomainBorder=base.getLeftDomainBorder()*factorX;
        rightDomainBorder=base.getRightDomainBorder()*factorX;
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
        return base.getFunctionValue(x*factorX)*factorY;
    }
}
