package lab_work_4;/*import lab_work_2.functions.FunctionPoint;
import lab_work_2.functions.TabulatedFunction;

import lab_work_3.functions.FunctionPoint_3;
import lab_work_3.functions.ArrayTabulatedFunction;
import lab_work_3.functions.LinkedListTabulatedFunction;
*/
import lab_work_4.functions.*;
import lab_work_4.functions.basic.*;

import java.io.*;

public class Main_lab_work_4 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Задание 8");

        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-##-#-#-#-#-#-#-#");

        System.out.println("Задание 8.1: Создайте по одному объекту классов Sin и Cos, выведите в консоль значения этих функций на отрезке от 0 до Pi с шагом 0,1.");
        TabulatedFunction tCos, tSin;
        Cos cos;
        Sin sin;
        sin = new Sin();
        System.out.println("Рассмотрим функцию синуса.");
        System.out.println("========================" + "sim" + "=========================");
        for (double x = 0; x <= 2 * Math.PI; x += 0.1) {
            System.out.println("x = " + x + " y =  " + sin.getFunctionValue(x));
        }
        System.out.println("========================" + "sim" + "=========================");
        cos = new Cos();
        System.out.println("Рассмотрим функцию косинуса.");
        System.out.println("========================" + "cos" + "=========================");
        for (double x = 0; x <= 2 * Math.PI; x += 0.1)
        {
            System.out.println("x = " + x + " y =  " + cos.getFunctionValue(x));
        }
        System.out.println("========================" + "cos" + "=========================");
        tSin = TabulatedFunctions.tabulate(sin, 0, 2 * Math.PI, 10);

        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-##-#-#-#-#-#-#-#");

        System.out.println("Задание 8.2: Создайте табулированные аналоги этих функций на отрезке от 0 до Pi с 10 точками");
        System.out.println("Рассмотрим табулированную функцию синуса.");
        System.out.println("========================" + "tabulated_sin" + "=========================");
        for (double x = 0; x <= 2 * Math.PI; x += 0.1)
        {
            System.out.println("x = " + x + " y =  " + tSin.getFunctionValue(x));
        }
        System.out.println("========================" + "tabulated_sin" + "=========================");
        System.out.println("Рассмотрим табулированную функцию косинуса.");
        tCos = TabulatedFunctions.tabulate(cos, 0, 2 * Math.PI, 10);
        System.out.println("========================" + "tabulated_cos" + "=========================");
        for (double x = 0; x <= 2 * Math.PI; x += 0.1) {
            System.out.println("x = " + x + " y =  " + tCos.getFunctionValue(x));
        }
        System.out.println("========================" + "tabulated_cos" + "=========================");

        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-##-#-#-#-#-#-#-#");

        System.out.println("Задание 8.3: Создайте объект функции, являющейся суммой квадратов табулированных аналогов синуса и косинуса");
        Function sum = Functions.sum(Functions.mult(tSin, tSin), Functions.mult(tCos, tCos));
        System.out.println("Рассмотрим сумму квадратов функций");
        System.out.println("========================" + "sum" + "=========================");
        for (double x = 0; x <= 2 * Math.PI; x += 0.1)
            System.out.println("x = " + x + " y =  " + sum.getFunctionValue(x));
        System.out.println("========================" + "sum" + "=========================");

        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-##-#-#-#-#-#-#-#");

        System.out.println("Задание 8.4");
        System.out.println("Задание 8.4.1: Создайте табулированный аналог экспоненты на отрезке от 0 до 10 с 11 точками");
        System.out.println("Рассмотрим функцию экспоненты");
        Exp exp = new Exp();
        System.out.println("========================" + "exp" + "=========================");
        for (int i = 0; i < 11; i++) {
            System.out.println("x = " + i + " y =  " + exp.getFunctionValue(i));
        }
        System.out.println("========================" + "exp" + "=========================");
        System.out.println("Рассмотрим табулированный аналог экспоненты");
        System.out.println("Создали табулированный аналог экспоненты");
        TabulatedFunction tExp = TabulatedFunctions.tabulate(exp, 0, 10, 11);
        System.out.println("========================" + "tabulated_exp до записи в файл" + "=========================");
        for (int x = 0; x < 11; x++)
        {
            System.out.println("x = " + x + " y =  " + tExp.getFunctionValue(x));
        }
        System.out.println("========================" + "tabulated_exp до записи в файл" + "=========================");
        System.out.println("Задание 8.4.2: Выведите функцию в файл");
        System.out.println("Записали табулированный аналог экспоненты в файл 'exp.txt'");
        FileWriter out = new FileWriter("exp.txt");
        TabulatedFunctions.writeTabulatedFunction(tExp, out);
        out.flush();
        out.close();
        System.out.println("Задание 8.4.3: Прочитайте функцию из файла");
        System.out.println("Прочитали табулированный аналог экспоненты из файла 'exp.txt'");
        FileReader in = new FileReader("exp.txt");
        TabulatedFunction tExp1 = TabulatedFunctions.readTabulatedFunction(in);
        in.close();
        System.out.println("Задание 8.4.4: Выведите функцию полученную из файла");
        System.out.println("========================" + "tabulated_exp после чтения из файла" + "=========================");
        for (int x = 0; x < 11; x++)
        {
            System.out.println("x = " + x + " y =  " + tExp1.getFunctionValue(x));
        }
        System.out.println("========================" + "tabulated_exp после чтения из файла" + "=========================");

        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-##-#-#-#-#-#-#-#");








        System.out.println("Задание 8.5");
        System.out.println("Задание 8.5.1: Создайте табулированный аналог логарифма по натуральному основанию на отрезке от 0 до 10 с 11 точками");
        System.out.println("Рассмотрим функцию натурального логарифма");
        Log ln = new Log(Math.E);
        System.out.println("========================" + "log" + "=========================");
        for (int i = 0; i < 11; i++)
        {
            System.out.println("x = " + i + " y =  " + ln.getFunctionValue(i));
        }
        System.out.println("========================" + "log" + "=========================");
        System.out.println("Создали табулированный аналог натурального логарифма");
        TabulatedFunction tLn = TabulatedFunctions.tabulate(ln, 0, 10, 11);
        System.out.println("========================" + "tabulated_log" + "=========================");
        for (int x = 0; x < 11; x++)
        {
            System.out.println("x = " + x + " y =  " + tLn.getFunctionValue(x));
        }
        System.out.println("Задание 8.5.2: Выведите созданную функцию в файл");
        System.out.println("========================" + "tabulated_log" + "=========================");
        System.out.println("Записали табулированный аналог натурального логарифма в файл 'log.txt'");
        OutputStream output = new FileOutputStream("log.txt");
        TabulatedFunctions.outputTabulatedFunction(tLn, output);
        output.flush();
        output.close();
        System.out.println("Задание 8.5.3: Считайте созданную функцию из файла");
        System.out.println("Прочитали табулированный аналог натурального логарифма из файла 'log.txt'");
        InputStream in_ln = new FileInputStream("log.txt");
        TabulatedFunction tLn1 = TabulatedFunctions.inputTabulatedFunction(in_ln);
        in_ln.close();
        System.out.println("Задание 8.5.4: Вывечлите прочитанную функцию из файла");
        System.out.println("========================" + "tabulated_log" + "=========================");
        for (int x = 0; x < 11; x++)
        {
            System.out.println("x = " + x + " y =  " + tLn1.getFunctionValue(x));
        }
        System.out.println("========================" + "tabulated_log" + "=========================");

        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-##-#-#-#-#-#-#-#");

        System.out.println("Задание 9");
        System.out.println("Задание 9.1: Создайте табулированный аналог логарифма по натуральному основанию, взятого от экспоненты на отрезке от 0 до 10 с 11 точками");
        Log ln2 = new Log(Math.E);
        Exp exp2 = new Exp();
        Function f = Functions.composition(ln2, exp2);
        TabulatedFunction tF = TabulatedFunctions.tabulate(f, 0, 10, 11);
        System.out.println("========================" + "tabulated ln(e^x) before serialization" + "=========================");
        for (int x = 0; x < 11; x++)
        {
            System.out.println("x = " + x + " y =  " + tF.getFunctionValue(x));
        }
        System.out.println("========================" + "tabulated ln(e^x) before serialization" + "=========================");
        System.out.println("Задание 9.2: Сериализуйте полученный объект в файл 'ln_exp.txt'");
        FileOutputStream output2 = new FileOutputStream("ln_exp.txt");
        ObjectOutputStream serial = new ObjectOutputStream(output2);
        serial.writeObject(tF);
        serial.close();
        System.out.println("Задание 9.3: Десериализуйте объект из файл 'ln_exp.txt'");
        FileInputStream input2 = new FileInputStream("ln_exp.txt");
        ObjectInputStream deserial = new ObjectInputStream(input2);
        TabulatedFunction tF1 = (TabulatedFunction) deserial.readObject();
        deserial.close();
        System.out.println("Задание 9.4: Выведите десериализованный объект");
        System.out.println("========================" + "tabulated ln(e^x) after deserialization" + "=========================");
        for (int x = 0; x < 11; x++) {
            System.out.println("x = " + x + " y =  " + tF1.getFunctionValue(x));
        }
        System.out.println("========================" + "tabulated ln(e^x) after deserialization" + "=========================");

        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-##-#-#-#-#-#-#-#");
    }
}
