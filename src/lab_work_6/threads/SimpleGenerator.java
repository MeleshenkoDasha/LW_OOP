package lab_work_6.threads;

import lab_work_6.functions.basic.Log;
import java.util.Random;


/**
 * Класс SimpleGenerator
 * Должен получать в конструкторе и сохранять в своё поле ссылку на объект типа Task
 * Метод run(), в цикле должны формироваться задачи и заноситься в полученный объект задания, а также выводиться сообщения в консоль.
 * */
public class SimpleGenerator extends Thread {

    // Задание
    private Task task;

    // Конструктор
    public SimpleGenerator(Task task)
    {
        this.task = task;
    }

    // Метод run
    @Override
    public void run() {
        // Экземпляр класса Random
        Random rand = new Random();
        // в цикле обрабатиываем задания
        for (int i = 0; i < task.getTaskCount(); i++) {
            // определим основание логарифма
            double base = rand.nextDouble() * 9 + 1;
            // определим сам логарифм
            Log log = new Log(base);
            // указать в объекте задания левую границу области интегрирования (случайно распределена на отрезке от 0 до 100);
            double leftDomainBorder = rand.nextDouble() * 100;
            // указать в объекте задания правую границу области интегрирования (случайно распределена на отрезке от 100 до 200);
            double rightDomainBorder = rand.nextDouble() * 100 + 100;
            // указать в объекте задания шаг дискретизации (случайно распределён на отрезке от 0 до 1);
            double sampleStep = rand.nextDouble();
            // передаем текущие параметры в задание
            synchronized (task) {
                task.updateTask(log, leftDomainBorder, rightDomainBorder, sampleStep);
            }
            // вывести в консоль сообщение вида "Source <левая граница> <правая граница> <шаг дискретизации>";
            System.out.println("Source " + leftDomainBorder + " " + rightDomainBorder + " " + sampleStep);
        }
    }
}
