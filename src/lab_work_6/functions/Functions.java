package lab_work_6.functions;

import lab_work_6.functions.basic.Const;
import lab_work_6.functions.meta.*;

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

    /**
     * Метод возвращающий значение интеграла функции, вычисленное с помощью численного метода
     * */
    public static double integrate(Function f, double leftDomainBorder, double rightDomainBorder, double sampleStep){
        // проверяем корректность задания области определения
        if(Double.compare(leftDomainBorder, f.getLeftDomainBorder()) == -1){
            throw new IllegalArgumentException("Левая граница области определения("+ leftDomainBorder +") должна быть больше, чем левая граница области определения функции("+f.getLeftDomainBorder()+")");
        }
        if(Double.compare(rightDomainBorder, f.getRightDomainBorder()) == 1){
            throw new IllegalArgumentException("Правая граница области определения("+ rightDomainBorder +") должна быть меньше, чем правая граница области определения функции("+f.getRightDomainBorder()+")");
        }
        // определяем шаг приращения
        double current= leftDomainBorder +sampleStep;
        double coefficient=sampleStep/2;
        // определяем итоговую сумму
        double sum=0;
        // производим расчет интеграла
        while(Double.compare(current, rightDomainBorder)==-1){
            sum+=(f.getFunctionValue(leftDomainBorder)+f.getFunctionValue(current))*coefficient;
            leftDomainBorder =current;
            current+=sampleStep;
        }
        // досчитываем при необходимости правую границу
        if(Double.compare(current, rightDomainBorder)<=0){
            sum+=(f.getFunctionValue(current)+f.getFunctionValue(rightDomainBorder))*(rightDomainBorder -current)/2;
        }
        // возвращаем значение интеграла
        return sum;
    }
}

