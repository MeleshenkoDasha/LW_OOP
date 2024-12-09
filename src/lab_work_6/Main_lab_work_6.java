package lab_work_6;

import lab_work_6.functions.*;
import lab_work_6.functions.basic.*;
import lab_work_6.threads.*;

import java.util.Random;

public class Main_lab_work_6 {

    /**
     * Метод nonThread()
     * Реализует последовательную (без применения потоков инструкций) версию программы
     * */
    public static void nonThread(){
        Random rand=new Random();
        // Создадим объект заданий с количеством заданий = 100
        Task task=new Task(100);
        // в цикле идем по всем заданиям
        for(int i=0;i<task.getTaskCount();i++){
            // создать и поместить в объект задания объект логарифмической функции, основание которой является случайной величиной, распределённой равномерно на отрезке от 1 до 10
            // в начале определяем потом передаем параметры для задания
            // определим основание логарифма
            double base=rand.nextDouble()*9+1;
            // определим сам логарифм
            Log log=new Log(base);
            // указать в объекте задания левую границу области интегрирования (случайно распределена на отрезке от 0 до 100);
            double leftDomainBorder=rand.nextDouble()*100;
            // указать в объекте задания правую границу области интегрирования (случайно распределена на отрезке от 100 до 200);
            double rightDomainBorder=rand.nextDouble()*100+100;
            // указать в объекте задания шаг дискретизации (случайно распределён на отрезке от 0 до 1);
            double sampleStep=rand.nextDouble();
            // передаем текущие параметры в задание
            task.updateTask(log,leftDomainBorder,rightDomainBorder,sampleStep);
            // вывести в консоль сообщение вида "Source <левая граница> <правая граница> <шаг дискретизации>";
            System.out.println("Source "+task.getLeftDomainBorder()+" "+task.getRightDomainBorder()+" "+task.getSampleStep());
            // вычислить значение интеграла для параметров из объекта задания
            double sum= Functions.integrate(task.getFunction(),task.getLeftDomainBorder(),task.getRightDomainBorder(),task.getSampleStep());
            // вывести в консоль сообщение вида "Result <левая граница> <правая граница> <шаг дискретизации> <результат интегрирования>".
            System.out.println("Result "+task.getLeftDomainBorder()+" "+task.getRightDomainBorder()+" "+task.getSampleStep()+" "+sum);
        }
    }

    /**
     * Метод simpleThreads().
     * Создайте объект задания, укажите количество выполняемых заданий (минимум 100), создайте и запустите два потока вычислений, основанных на описанных классах SimpleGenerator и SimpleIntegrator.
     * */
    public static void simpleThreads(){
        Task task=new Task(100);
        SimpleGenerator generator=new SimpleGenerator(task);
        SimpleIntegrator integrator=new SimpleIntegrator(task);
        generator.start();
        integrator.start();
    }

    public static void complicatedThreads(){
        // определили семафор
        Semaphore semaphore=new Semaphore();
        // определили задание
        Task task=new Task(100);
        // создаем generator
        Generator generator=new Generator(task,semaphore);
        // создаем integrator
        Integrator integrator=new Integrator(task,semaphore);
        // Запустили generator
        generator.start();
        // Запустили integrator
        integrator.start();
        try {
            // установили таймер на 50 мс
            Thread.sleep(50);
        }catch (InterruptedException e) {

        }
        // Запустили generator
        generator.interrupt();
        integrator.interrupt();
        //while(generator.isAlive() || integrator.isAlive()){}
    }

    public static void main(String[] args) {
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        System.out.println("Проверка интегрирования");
        Exp a=new Exp();
        System.out.println(Functions.integrate(a,0,1,0.0005));
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        System.out.println("Запуск nonThread()");
        nonThread();
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        System.out.println("Запуск complicatedThreads()");
        long startTime = System.nanoTime();
        complicatedThreads();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000000;  //divide by 1000000 to get milliseconds.
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        System.out.println("Затрачено "+duration+" мс.");

    }

    
}
