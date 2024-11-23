package lab_work_5.functions.meta;

import lab_work_5.functions.Function;

/**
 * Класс Composition
 * Объекты данного класса, описывают композицию двух исходных функций
 * */
public class Composition implements Function {

    /**
     * Внутренняя функция
     * */
    private Function inner;

    /**
     * Внешняя функция
     * */
    private Function outer;

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
    public Composition(Function inner, Function outer) {
        this.inner = inner;
        this.outer = outer;
        leftDomainBorder=inner.getLeftDomainBorder();
        rightDomainBorder=inner.getRightDomainBorder();
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
        return outer.getFunctionValue(inner.getFunctionValue(x));
    }
}

