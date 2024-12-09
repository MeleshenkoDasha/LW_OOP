package lab_work_6.functions.meta;

import lab_work_6.functions.Function;

/**
 * Класс Sum
 * Объекты данного класса, описывают сумму двух исходных функций
 * */
public class Sum implements Function {

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
    public Sum(Function first, Function second) {
        this.first=first;
        this.second=second;
        leftDomainBorder=Math.max(first.getLeftDomainBorder(), second.getLeftDomainBorder());
        rightDomainBorder=Math.min(first.getRightDomainBorder(),second.getRightDomainBorder());
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
        return first.getFunctionValue(x)+second.getFunctionValue(x);
    }
}
