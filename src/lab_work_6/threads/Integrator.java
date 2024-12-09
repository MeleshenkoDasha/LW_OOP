package lab_work_6.threads;

import lab_work_6.functions.Functions;

public class Integrator extends Thread {

    // Задание
    private Task task;
    // Семафор
    private Semaphore semaphore;

    // Конктруктор
    public Integrator(Task task, Semaphore semaphore){
        this.task=task;
        this.semaphore=semaphore;
    }

    // Метод run
    @Override
    public void run() {
        // определим переменные для работы
        double sum;
        double leftDomainBorder;
        double rightDomainBorder;
        double sampleStep;
        // в цикле идем по заданиям
        for (int i = 0; i < task.getTaskCount(); i++) {
            try{
                // устанавливаем семафор
                semaphore.beginRead();
                // получаем левую границу
                leftDomainBorder=task.getLeftDomainBorder();
                // получаем правую границу
                rightDomainBorder=task.getRightDomainBorder();
                // получаем шаг дискроетизации
                sampleStep=task.getSampleStep();
                // получаем сумму
                sum = Functions.integrate(task.getFunction(), leftDomainBorder, rightDomainBorder, sampleStep);
                // выводим сообщение
                System.out.println("Result " + leftDomainBorder + " " + rightDomainBorder + " " + sampleStep + " " + sum);
                // снимаем семафор
                semaphore.endRead();
            }catch (InterruptedException e){
                System.out.println("Integrator stopped");
                return;
            }
        }
    }
}
