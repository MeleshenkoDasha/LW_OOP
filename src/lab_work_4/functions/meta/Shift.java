package lab_work_4.functions.meta;

import lab_work_4.functions.Function;

/**
 * Класс Shift
 * Объекты данного класса представляют собой функцию, полученную из исходной функций путём сдвига вдоль осей координат
 * */
public class Shift implements Function {

    /**
     * Базовая функция
     * */
    private Function base;
    /**
     * Сдвиг по оси X
     * */
    private double shiftX;
    /**
     * Сдвиг по оси Y
     * */
    private double shiftY;
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
    public Shift(Function base, double shiftX, double shiftY) {
        this.base = base;
        this.shiftX = shiftX;
        this.shiftY=shiftY;
        leftDomainBorder=base.getLeftDomainBorder()+shiftX;
        rightDomainBorder=base.getRightDomainBorder()+shiftX;
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
        return base.getFunctionValue(x+shiftX)+shiftY;
    }
}
