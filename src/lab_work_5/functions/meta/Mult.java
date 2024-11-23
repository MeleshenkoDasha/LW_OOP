package lab_work_5.functions.meta;

import lab_work_5.functions.Function;

/**
 * Класс Mult
 * Объекты данного класса, описывают произведение двух исходных функций
 * */
public class Mult implements Function {

    /**
     * Первая функция
     * */
    private Function first;

    /**
     * Вторая функция
     * */
    private Function second;

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
    public Mult(Function first, Function second) {
        this.first=first;
        this.second=second;
        leftDomainBorder=Math.max(first.getLeftDomainBorder(), second.getLeftDomainBorder());
        rightDomainBorder=Math.min(first.getRightDomainBorder(),second.getRightDomainBorder());
    }

    /**
     *
     * */
    public double getLeftDomainBorder()
    {
        return leftDomainBorder;
    }

    public double getRightDomainBorder()
    {
        return rightDomainBorder;
    }

    public double getFunctionValue(double x)
    {
        return first.getFunctionValue(x)*second.getFunctionValue(x);
    }
}
