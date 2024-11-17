package lab_work_4.functions;

import java.io.*;


/**
 * Класс TabulatedFunctions
 * Данный класс, содержит вспомогательные статические методы для работы с табулированными функциями
 * */


public class TabulatedFunctions {

    private TabulatedFunctions() {
    }

    /**
     * Метод public static TabulatedFunction tabulate(Function function, double leftX, double rightX, int pointsCount)
     * Получает функцию и возвращает её табулированный аналог на заданном отрезке с заданным количеством точек
     * */
    public static TabulatedFunction tabulate(Function function, double leftX, double rightX, int pointsCount) {
        // Проверка границ области определения
        if (Double.compare(leftX, function.getLeftDomainBorder()) == -1) {
            throw new IllegalArgumentException("Левая граница(" + leftX + ") выходит за границу области определения функции(" + function.getLeftDomainBorder() + ")");
        }
        if (Double.compare(rightX, function.getRightDomainBorder()) == 1) {
            throw new IllegalArgumentException("Правая граница(" + rightX + ") выходит за границу области определения функции(" + function.getRightDomainBorder() + ")");
        }
        // Определили массив точек
        double[] values = new double[pointsCount];
        // Определили шаг приращения функции
        double step = (rightX - leftX) / (pointsCount - 1);
        double currentX=leftX;
        // Заполнили массив функции
        for (int i = 0; i < pointsCount; i++) {
            values[i] = function.getFunctionValue(currentX);
            currentX += step;
        }
        values[pointsCount - 1] = function.getFunctionValue(rightX);
        // вернули функцию
        return new ArrayTabulatedFunction(leftX, rightX, values);
    }

    /**
     * outputTabulatedFunction(TabulatedFunction function, OutputStream out)
     * Метод вывода табулированной функции в байтовый поток
     * Метод в указанный поток выводит значения, по которым потом можно будет восстановить табулированную функцию,
     * а именно количество точек в ней и значения координат точек.
     * */
    public static void outputTabulatedFunction(TabulatedFunction function, OutputStream out) throws IOException {
        // Создали байтовый поток для записи данных
        DataOutputStream dataOut = new DataOutputStream(out);
        // Записали количество точек функции
        dataOut.writeInt(function.getPointsCount());
        // Записали левую границу области определения функции
        dataOut.writeDouble(function.getLeftDomainBorder());
        // Записали правую границу области определения функции
        dataOut.writeDouble(function.getRightDomainBorder());
        // Записали значения функции
        for (int i = 0; i < function.getPointsCount(); i++) {
            dataOut.writeDouble(function.getPointY(i));
        }
    }

    /**
     * inputTabulatedFunction(InputStream in)
     * Метод ввода табулированной функции из байтового потока
     * Метод считывает из указанного потока данные о табулированной функции, создает и настраивает её объект, а так же возвращает его из метода
     * */
    public static TabulatedFunction inputTabulatedFunction(InputStream in) throws IOException {
        // Создали байтовый поток для чтения данных
        DataInputStream dataIn=new DataInputStream(in);
        // Считали количество точек функции
        int pointsCount=dataIn.readInt();
        // Считали количество левую границу области определения
        double leftX=dataIn.readDouble();
        // считали правую границу области определения
        double rightX=dataIn.readDouble();
        // Создали массив для чтения точек функции
        double[] values=new double[pointsCount];
        // считали точки функции
        for(int i=0;i<pointsCount;i++){
            values[i]=dataIn.readDouble();
        }
        // вернули функцию
        return new ArrayTabulatedFunction(leftX,rightX,values);
    }

    /**
     * writeTabulatedFunction(TabulatedFunction function, Writer out)
     * Метод записи табулированной функции в символьный поток
     * Метод в указанный поток выводит значения, по которым потом можно будет восстановить табулированную функцию:
     * а именно количество точек в ней и значения координат точек.
     * */
    public static void writeTabulatedFunction(TabulatedFunction function, Writer out){
        // Создади символьный поток вывода
        PrintWriter printOut=new PrintWriter(out);
        // Записали количество точек функции
        printOut.print(function.getPointsCount()+" ");
        // записали левую границу
        printOut.print(function.getLeftDomainBorder()+" ");
        // записали правую границу
        printOut.print(function.getRightDomainBorder());
        // записали точки функции
        for(int i=0;i<function.getPointsCount();i++){
            printOut.print(" "+function.getPointY(i));
        }
    }

    /**
     * readTabulatedFunction(Reader in)
     * Метод чтения табулированной функции из символьного потока
     * Метод считывает из указанного потока данные о табулированной функции, создает и настраивает её объект, а так же возвращает его из метода.
     * */
    public static TabulatedFunction readTabulatedFunction(Reader in) throws IOException{
        // создадим поток токенов
        StreamTokenizer tokenizer=new StreamTokenizer(in);
        // Анализируем очередной токен из потока токенов
        tokenizer.nextToken();
        // Пытаемся преобразовать токен в число, для получения количества точек функции
        int pointsCount=(int)tokenizer.nval;
        // Анализируем очередной токен из потока токенов
        tokenizer.nextToken();
        // Пытаемся преобразовать токен в число, для получения левой границы области определения
        double leftX=tokenizer.nval;
        // Анализируем очередной токен из потока токенов
        tokenizer.nextToken();
        // Пытаемся преобразовать токен в число, для получения правой границы области определения
        double rightX=tokenizer.nval;
        // создаем массив точек функции
        double[] values=new double[pointsCount];
        // получаем точки функции
        for(int i=0;i<pointsCount;i++){
            // Анализируем очередной токен из потока токенов
            tokenizer.nextToken();
            // Пытаемся преобразовать токен в число, для получения значений функции
            values[i]=tokenizer.nval;
        }
        // Возвращаем функцию
        return new ArrayTabulatedFunction(leftX,rightX,values);
    }
}
