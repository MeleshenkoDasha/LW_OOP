package lab_work_6.threads;

import lab_work_6.functions.Functions;

public class SimpleIntegrator extends Thread {

    // задание
    private Task task;

    // конструктор
    public SimpleIntegrator(Task task)
    {
        this.task = task;
    }

    @Override
    public void run() {
        // проверяем что текущее задание существует
        while (task.getFunction() == null) {
            Thread.yield();
        }
        double sum;
        double leftDomainBorder;
        double rightDomainBorder;
        double sampleStep;
        for (int i = 0; i < task.getTaskCount(); i++) {
            synchronized (task) {
                // получили левую границу
                leftDomainBorder=task.getLeftDomainBorder();
                // получили правую границу
                rightDomainBorder=task.getRightDomainBorder();
                // получили шаг дискретизации
                sampleStep=task.getSampleStep();
                // рассчитали интеграл
                sum = Functions.integrate(task.getFunction(), leftDomainBorder, rightDomainBorder, sampleStep);
            }
            // Вывели сообщение
            System.out.println("Result " + leftDomainBorder + " " + rightDomainBorder + " " + sampleStep + " " + sum);
        }
    }
}
