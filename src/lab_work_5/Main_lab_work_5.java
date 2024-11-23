package lab_work_5;

import lab_work_5.functions.*;

public class Main_lab_work_5 {

    public static void main(String[] args) {
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        System.out.println("Создадим объект ArrayTabulatedFunction");
        ArrayTabulatedFunction array_function_Jango_Fett=new ArrayTabulatedFunction(-2,2,3);
        System.out.println("Выведем созданный ArrayTabulatedFunction: " + array_function_Jango_Fett);
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        System.out.println("Создадим объект LinkedListTabulatedFunction");
        LinkedListTabulatedFunction link_func_Jango_Fett=new LinkedListTabulatedFunction(-2,2,3);
        System.out.println("Выведем созданный LinkedListTabulatedFunction" + link_func_Jango_Fett);
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        System.out.println("Создадим объект FunctionPoint");
        FunctionPoint fPoint_1=new FunctionPoint(-2,0);
        System.out.println("Выведем созданный FunctionPoint: "+ fPoint_1);
        System.out.println("Выведем hashCode созданного FunctionPoint: "+ fPoint_1.hashCode());
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        System.out.println("Создадим еще один объект FunctionPoint");
        FunctionPoint fPoint_2=new FunctionPoint(0,-2);
        System.out.println("Выведем созданный FunctionPoint: " + fPoint_2);
        System.out.println("Выведем hashCode созданного FunctionPoint: " + fPoint_2.hashCode());
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        System.out.println("Сравним созданные FunctionPoint: fPoint_1.equals(fPoint_2): "+fPoint_1.equals(fPoint_2));
        fPoint_2=new FunctionPoint(-2,0);
        System.out.println("Изменим координаты fPoint_2, на такие же, как и у fPoint_1: " + fPoint_2);
        System.out.println("Сравним текущие FunctionPoint: fPoint_1.equals(fPoint_2): "+ fPoint_1.equals(fPoint_2));
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        System.out.println("Выведем вновь ArrayTabulatedFunction: " + array_function_Jango_Fett);
        System.out.println("Выведем вновь LinkedListTabulatedFunction: " + link_func_Jango_Fett);
        System.out.println("Сравним ArrayTabulatedFunction и LinkedListTabulatedFunction при помощи equals: " + array_function_Jango_Fett.equals(link_func_Jango_Fett));
        System.out.println("Сравним LinkedListTabulatedFunction и ArrayTabulatedFunction при помощи equals: " + link_func_Jango_Fett.equals(array_function_Jango_Fett));
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        System.out.println("Посмотрим hashCode для ArrayTabulatedFunction: " + array_function_Jango_Fett.hashCode());
        System.out.println("Посмотрим hashCode для LinkedListTabulatedFunction: " + link_func_Jango_Fett.hashCode());
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        try {
            array_function_Jango_Fett.setPointX(2, 3);
            System.out.println("Внесли изменение в ArrayTabulatedFunction: " + array_function_Jango_Fett);
        }
        catch (Exception e){

        }
        System.out.println("Сравним ArrayTabulatedFunction и LinkedListTabulatedFunction при помощи equals: " + array_function_Jango_Fett.equals(link_func_Jango_Fett));
        System.out.println("Сравним LinkedListTabulatedFunction и ArrayTabulatedFunction при помощи equals: " + link_func_Jango_Fett.equals(array_function_Jango_Fett));
        System.out.println("Посмотрим hashCode для ArrayTabulatedFunction: " + array_function_Jango_Fett.hashCode());
        System.out.println("Посмотрим hashCode для LinkedListTabulatedFunction: " + link_func_Jango_Fett.hashCode());
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        System.out.println("Посмотрим hashCode для fPoint_1: " + fPoint_1.hashCode());
        fPoint_1.setX(-2.0001);
        System.out.println("Изменили координату точки fPoint_1: " + fPoint_1);
        System.out.println("Посмотрим hashCode для fPoint_1: " + fPoint_1.hashCode());
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        try {
            ArrayTabulatedFunction array_function_Boba_Fett = (ArrayTabulatedFunction) array_function_Jango_Fett.clone();
            System.out.println("Оригинальный ArrayTabulatedFunction: " + array_function_Jango_Fett);
            System.out.println("Клонированный ArrayTabulatedFunction: " + array_function_Boba_Fett);
            System.out.println("Изменили клонированный ArrayTabulatedFunction");
            array_function_Boba_Fett.setPointX(0,-4);
            System.out.println("Оригинальный ArrayTabulatedFunction: " + array_function_Jango_Fett);
            System.out.println("Клонированный ArrayTabulatedFunction: " + array_function_Boba_Fett);
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        System.out.println("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        try {
            LinkedListTabulatedFunction link_func_Boba_Fett = (LinkedListTabulatedFunction) link_func_Jango_Fett.clone();
            System.out.println("Оригинальный LinkedListTabulatedFunction: " + link_func_Jango_Fett);
            System.out.println("Клонированный LinkedListTabulatedFunction: " + link_func_Boba_Fett);
            System.out.println("Изменили клонированный LinkedListTabulatedFunction");
            link_func_Boba_Fett.setPointX(0,-3);
            System.out.println("Оригинальный LinkedListTabulatedFunction: " + link_func_Jango_Fett);
            System.out.println("Клонированный LinkedListTabulatedFunction: " + link_func_Boba_Fett);
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
    }
}
