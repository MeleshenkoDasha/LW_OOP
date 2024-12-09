package lab_work_6.threads;

import lab_work_6.functions.basic.Log;

import java.util.Random;

public class Generator extends Thread {

    // Задание
    private Task task;
    // Семафор
    private Semaphore semaphore;

    // Конктруктор
    public Generator(Task task, Semaphore semaphore){
        this.task=task;
        this.semaphore=semaphore;
    }

    // Метод run
    @Override
    public void run() {
        Random rand = new Random();
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
            try {
                // установили семафор
                semaphore.beginWrite();
                // передаем текущие параметры в задание
                task.updateTask(log, leftDomainBorder, rightDomainBorder, sampleStep);
                // выводим сообщение
                System.out.println("Source " + leftDomainBorder + " " + rightDomainBorder + " " + sampleStep);
                // снимаем семафор
                semaphore.endWrite();
            }catch (InterruptedException e){
                System.out.println("Generator stopped");
                return;
            }
        }
    }
}
