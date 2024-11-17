package lab_work_3.functions;

/**
 * Класс LinkedListTabulatedFunction описывает объекты списка.
 * Данный список, содержит поле ссылки на объект головы, а также иные вспомогательные поля.
 * */
public class LinkedListTabulatedFunction implements TabulatedFunction {

    /**
     * В качестве атрибутов класса будем использовать 3 элемента:
     * FunctionNode head - ссылка на головной элемент
     * FunctionNode tail - ссылка на хвостовой элемент
     * pointsCount - количество точек функции
     * */
    private FunctionNode head;
    private FunctionNode tail;
    private int pointsCount;

    /**
     * Конструктор, аналогичный конструктору класса ArrayTabulatedFunction(double leftX, double rightX, int pointsCount)
     * double leftX - левая граница области определения;
     * double rightX - правая граница области определения;
     * int pointsCount - количество точек функции
     * */
    public LinkedListTabulatedFunction(double leftX, double rightX, int pointsCount) {
        // Запомним количество точек функции
        this.pointsCount = pointsCount;
        // Проверим, что указанного количества точек достаточно для работы.
        if (pointsCount < 2) {
            // Если нет, то выдаем сообщение об ошибке
            throw new IllegalArgumentException("Количество точек (" + pointsCount + ") должно быть больше 1!");
        }
        // Проверяем, что границы области определения функции указаны верно
        if (Double.compare(leftX, rightX) >= 0) {
            throw new IllegalArgumentException("Правая граница области определения (" + rightX + ") должна быть больше левой (" + leftX + ")!");
        }
        // Инициализируем головной и хвостовой элементы списка
        head = new FunctionNode();
        head.previous = head;
        head.next = head;
        tail = head;
        // Заполним функцию следующим образом
        double step = (rightX - leftX) / (pointsCount - 1);
        for (int i = 0; i < pointsCount - 1; i++) {
            addNodeToTail().point = new FunctionPoint(leftX, 0);
            leftX += step;
        }
        // Добавим конечный элемент
        addNodeToTail().point = new FunctionPoint(rightX, 0);
    }

    /**
     * Конструктор, аналогичный конструктору класса ArrayTabulatedFunction(double leftX, double rightX, double[] values)
     * double leftX - левая граница области определения;
     * double rightX - правая граница области определения;
     * double[] values - значения функции
     * */
    public LinkedListTabulatedFunction(double leftX, double rightX, double[] values) {
        // Запомним количество точек функции
        this.pointsCount = values.length;
        // Проверим, что полученного количества точек достаточно для построения функции
        if (pointsCount < 2) {
            throw new IllegalArgumentException("Количество точек (" + pointsCount + ") должно быть больше 1!");
        }
        // Проверим верно указаны ли границы области определения функции
        if (Double.compare(leftX, rightX) >= 0) {
            throw new IllegalArgumentException("Правая граница области определения (" + rightX + ") должна быть больше левой (" + leftX + ")!");
        }
        // Инициализируем головной и хвостовой элементы списка
        head = new FunctionNode();
        head.previous = head;
        head.next = head;
        tail = head;
        // Заполним функцию следующим образом
        double step = (rightX - leftX) / (pointsCount - 1);
        for (int i = 0; i < pointsCount - 1; i++) {
            addNodeToTail().point = new FunctionPoint(leftX, values[i]);
            leftX += step;
        }
        // Добавим конечный элемент
        addNodeToTail().point = new FunctionPoint(rightX, values[pointsCount - 1]);
    }

    /**
     * addNodeToTail() - метод добавляющий новый элемент в конец списка и возвращающий ссылку на объект этого элемента
     * */
    private FunctionNode addNodeToTail() {
        FunctionNode newNode = new FunctionNode();
        tail.next = newNode;
        newNode.previous = tail;
        tail = tail.next;
        return newNode;
    }

    /**
     * getNodeByIndex(int index) метод возвращающий ссылку на объект элемента списка по его номеру.
     * Нумерация значащих элементов (голова списка в данном случае к ним не относится) должна начинаться с 0.
     * */
    private FunctionNode getNodeByIndex(int index) {
        // Проверяем, что индекс указан корректно.
        if(index < 0 || index > pointsCount)
        {
            throw  new FunctionPointIndexOutOfBoundsException("Такого элемента не существует!",index);
        }
        FunctionNode current = head.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    /**
     * addNodeByIndex(int index) метод добавляющий новый элемент в указанную позицию списка и возвращающий ссылку на объект этого элемента.
     * */
    private FunctionNode addNodeByIndex(int index) {
        // Проверяем что индекс указан корректно
        if(index < 0 || index > pointsCount)
        {
            throw  new FunctionPointIndexOutOfBoundsException("Такого элемента не существует!",index);
        }
        // Создаем новый узел
        FunctionNode newNode = new FunctionNode();
        // Получаем элемент на текущем индексе
        FunctionNode destination = getNodeByIndex(index);
        // Производим добавление нового узла
        newNode.next = destination;
        newNode.previous = destination.previous;
        destination.previous.next = newNode;
        destination.previous = newNode;
        return newNode;
    }


    private FunctionNode deleteNodeByIndex(int index) {
        if(index < 0 || index > pointsCount)
        {
            throw  new FunctionPointIndexOutOfBoundsException("Такого элемента не существует!",index);
        }
        FunctionNode destination = getNodeByIndex(index);
        destination.next.previous = destination.previous;
        destination.previous.next = destination.next;
        return destination;
    }

    public int getPointsCount() {
        return pointsCount;
    }

    public double getLeftDomainBorder() {
        return getNodeByIndex(0).point.getX();
    }

    public double getRightDomainBorder() {
        return getNodeByIndex(pointsCount - 1).point.getX();
    }

    public double getFunctionValue(double x) {
        if (Double.compare(x, getLeftDomainBorder()) >= 0 || Double.compare(x, getRightDomainBorder()) <= 0) {
            FunctionNode current = head.next;
            for (int i = 0; i < pointsCount - 1; i++) {
                if (Double.compare(x, current.point.getX()) >= 0 && Double.compare(x, current.next.point.getX()) <= 0) {
                    return FunctionPoint.getValueOnLine(current.point, current.next.point, x);
                }
                current = current.next;
            }
        }
        return Double.NaN;
    }

    public FunctionPoint getPoint(int index) {
        if (index < 0 || index >= pointsCount) {
            throw new FunctionPointIndexOutOfBoundsException("Такого элемента не существует!", index);
        }
        return new FunctionPoint(getNodeByIndex(index).point);
    }

    public double getPointX(int index) {
        if (index < 0 || index >= pointsCount) {
            throw new FunctionPointIndexOutOfBoundsException("Такого элемента не существует!", index);
        }
        return getNodeByIndex(index).point.getX();
    }

    public double getPointY(int index) {
        if (index < 0 || index >= pointsCount) {
            throw new FunctionPointIndexOutOfBoundsException("Такого элемента не существует!", index);
        }
        return getNodeByIndex(index).point.getY();
    }

    public void setPoint(int index, FunctionPoint point) throws InappropriateFunctionPointException {
        if (index < 0 || index >= pointsCount) {
            throw new FunctionPointIndexOutOfBoundsException("Такого элемента не существует!", index);
        }
        FunctionNode destination = getNodeByIndex(index);
        if (index != 0) {
            if (point.getX() <= destination.previous.point.getX()) {
                throw new InappropriateFunctionPointException("Выход за границу области определения слева (" + destination.previous.point.getX() + ")", point.getX());
            }
        }
        if (index != pointsCount) {
            if (Double.compare(point.getX(), destination.next.point.getX()) >= 0) {
                throw new InappropriateFunctionPointException("Выход за границу области определения справа (" + destination.next.point.getX() + ")", point.getX());
            }
        }
        destination.point = point;
    }

    public void setPointX(int index, double x) throws InappropriateFunctionPointException {
        if (index < 0 || index >= pointsCount) {
            throw new FunctionPointIndexOutOfBoundsException("Такого элемента не существует!", index);
        }
        FunctionNode destination = getNodeByIndex(index);
        if (index != 0) {
            if (Double.compare(x, destination.previous.point.getX()) <= 0) {
                throw new InappropriateFunctionPointException("Выход за границу области определения слева (" + destination.previous.point.getX() + ")", x);
            }
        }
        if (index != pointsCount) {
            if (Double.compare(x, destination.next.point.getX()) >= 0) {
                throw new InappropriateFunctionPointException("Выход за границу области определения справа (" + destination.next.point.getX() + ")", x);
            }
        }
        destination.point.setX(x);
    }

    public void setPointY(int index, double y) {
        if(index<0 || index>=pointsCount){
            throw  new FunctionPointIndexOutOfBoundsException("Такого элемента не существует!",index);
        }
        getNodeByIndex(index).point.setY(y);
    }

    public void addPoint(FunctionPoint point) throws InappropriateFunctionPointException {
        if (Double.compare(point.getX(), getLeftDomainBorder()) == -1 ) {
            addNodeByIndex(0).point = point;
            pointsCount++;
            return;
        }
        if (Double.compare(point.getX(), getRightDomainBorder()) == 1) {
            pointsCount++;
            addNodeToTail().point = point;
            return;
        }
        FunctionNode current = head.next;
        for (int i = 0; i < pointsCount; i++) {
            if (Double.compare(point.getX(), current.point.getX()) == 0) {
                throw new InappropriateFunctionPointException("Объявленная точка уже существует!", point.getX());
            }
            if (Double.compare(point.getX(), current.point.getX()) == -1) {
                pointsCount++;
                addNodeByIndex(i).point = point;
                return;
            }
            current=current.next;
        }
    }

    public void deletePoint(int index) {
        if (pointsCount < 3) {
            throw new IllegalStateException("Табулированная функция должна иметь не менее 2 точек!");
        }
        if (index < 0 || index >= pointsCount) {
            throw new FunctionPointIndexOutOfBoundsException("Такого элемента не существует!", index);
        }
        deleteNodeByIndex(index);
        pointsCount--;
    }

    public void printFunction(LinkedListTabulatedFunction func) {
        System.out.println("(  X ; Y  )");
        System.out.println("---------------------------------------------");
        for (int i = 0; i < func.getPointsCount(); i++) {
            System.out.println(func.getPoint(i).toString());
        }
        System.out.println("---------------------------------------------");
    }
}


/**
 * Опишем класс элементов списка FunctionNode
 * Класс содержит информационное поле для хранения данных типа FunctionPoint
 * А также поля для хранения ссылок на предыдущий и следующий элемент.
 * Выберите и обоснуйте место описания класса и его видимость.
 * Также выберите и обоснуйте реализацию инкапсуляции в этом классе
 * */
class FunctionNode{

    /**
     * FunctionNode next - ссылка на следующий элемент
     * FunctionNode previous - ссылка на предыдущий элемент
     * FunctionPoint point - информационное поле для хранения данных типа FunctionPoint
     * */

    public FunctionNode next;
    public FunctionNode previous;
    public FunctionPoint point;


    /**
     * "Пустой конструктор", для инициализации объекта класса
     * */
    public FunctionNode(){
        next=null;
        previous=null;
        point=null;
    }
}
