package lab_work_3.functions;

/**
 * Класс FunctionPointIndexOutOfBoundsException.
 * Объекты данного класса описывают исключение, выбрасываемое при попытке добавления или изменения точки функции несоответствующим образом.
 * Наследует свойства и методы от класса Exception;
 * */
public class InappropriateFunctionPointException extends Exception {

    /**
     * Атрибут координаты точки вводим для удобства
     * */
    private double x;

    /**
     * FunctionPointIndexOutOfBoundsException() - пустой конструктор
     * Правилами хорошего тона не запрещено
     * */
    public InappropriateFunctionPointException()
    {

    }

    /**
     * InappropriateFunctionPointException(String message, double x) - конструктор с параметрами
     * В качестве входных параметров используются:
     * message - текст ошибки;
     * x - координата, на которой получили исключение;
     * */
    public InappropriateFunctionPointException(String message, double x)
    {
        super(message);
        this.x = x;
    }

    //Метод получения координаты
    public double getX()
    {
        return x;
    }

    /**
     * Переопределим метод toString, для работы в нашем классе
     * */
    @Override
    public String toString()
    {
        return super.toString();
    }

    /**
     * Переопределим метод получения сообщения об ошибке
     * */
    @Override
    public String getMessage()
    {
        return super.getMessage()+" для запрашиваемого аргумента ("+x+")";
    }
}
