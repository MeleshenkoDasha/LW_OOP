package lab_work_3.functions;

/**
 * Класс FunctionPointIndexOutOfBoundsException.
 * Объекты данного класса описывают исключение, получаемое при выходе за границы набора точек при обращении к ним по номеру.
 * Наследует свойства и методы от класса IndexOutOfBoundsException;
 * */
public class FunctionPointIndexOutOfBoundsException extends IndexOutOfBoundsException {

    /**
     * Атрибут index заводим для удобства
     * */
    private int index;

    /**
     * FunctionPointIndexOutOfBoundsException() - пустой конструктор
     * Правилами хорошего тона не запрещено
     * */
    public FunctionPointIndexOutOfBoundsException()
    {

    }

    /**
     * FunctionPointIndexOutOfBoundsException(String message, int index) - конструктор с параметрами
     * В качестве входных параметров используются:
     * message - текст ошибки;
     * index - индекс, на котором получили исключение;
     * */
    public FunctionPointIndexOutOfBoundsException(String message, int index) {
        super(message);
        this.index = index;
    }

    //Метод получения индекса
    public int getIndex() {
        return index;
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
        return super.getMessage()+" для запрашиваемого индекса ("+index+")";
    }
}
