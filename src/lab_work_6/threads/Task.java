package lab_work_6.threads;

import lab_work_6.functions.Function;


/**
 * Класс Task
 * объект данного класса хранит ссылку на объект интегрируемой функции, границы области интегрирования, шаг дискретизации, а также целочисленное поле, хранящее количество выполняемых заданий.
 * Т.е. объект описывает одно задание.
 * */
public class Task {
    // функция
    private Function function;
    // левая граница
    private double leftDomainBorder;
    // правая граница
    private double rightDomainBorder;
    // шаг дискретизации
    private double sampleStep;
    // количество выполняемых заданий
    private int taskCount;

    public Task(int taskCount)
    {
        this.taskCount = taskCount;
    }

    /**
     * Метод обновления задания
     * */
    public void updateTask(Function function, double leftDomainBorder, double rightDomainBorder, double sampleStep){
        this.function=function;
        this.leftDomainBorder=leftDomainBorder;
        this.rightDomainBorder=rightDomainBorder;
        this.sampleStep=sampleStep;
    }

    /**
     * Методы доступа к полям класса
     * */
    public Function getFunction()
    {
        return function;
    }

    public double getLeftDomainBorder()
    {
        return leftDomainBorder;
    }

    public double getRightDomainBorder()
    {
        return rightDomainBorder;
    }

    public double getSampleStep()
    {
        return sampleStep;
    }

    public int getTaskCount()
    {
        return taskCount;
    }
}
