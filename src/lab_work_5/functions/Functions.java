package lab_work_5.functions;

import lab_work_5.functions.basic.Const;
import lab_work_5.functions.meta.*;

/**
 * Класс Functions
 * Данный класс содержит вспомогательные статические методы для работы с функциями
 * */
public class Functions {

    /**
     * Конструктор
     * */
    private Functions() { }

    /**
     * Возвращает объект функции, полученной из исходной сдвигом вдоль осей
     * */
    public static Function shift(Function f, double shiftX, double shiftY)
    {
        return new Shift(f, shiftX, shiftY);
    }

    /**
     * Метод возвращает объект функции, полученной из исходной масштабированием вдоль осей
     * */
    public static Function scale(Function f, double factorX, double factorY)
    {
        return new Scale(f, factorX, factorY);
    }

    /**
     * Метод возвращает объект функции, являющейся заданной степенью исходной
     * */
    public static Function power(Function f, double power)
    {
        return new Power(f, new Const(power));
    }

    /**
     * Метод возвращает объект функции, являющейся суммой двух исходных
     * */
    public static Function sum(Function f1, Function f2)
    {
        return new Sum(f1,f2);
    }

    /**
     * Метод возвращает объект функции, являющейся произведением двух исходных
     * */
    public static Function mult(Function f1, Function f2)
    {
        return new Mult(f1,f2);
    }

    /**
     * Метод возвращает объект функции, являющейся композицией двух исходных
     * */
    public  static Function composition(Function f1, Function f2)
    {
        return new Composition(f1,f2);
    }
}

