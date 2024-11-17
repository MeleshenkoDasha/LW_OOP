package lab_work_2.functions;

/**
 * Класс ArrayTabulatedFunction.
 * Объект, данного класса описывает табулированную функцию
 * */
public class TabulatedFunction {

    /**
     * Опишем атрибуты класса ArrayTabulatedFunction
     * FunctionPoint[] points - описывает массив точек FunctionPoint
     * pointsCount - описывает количество точек в массиве
     * */
    private FunctionPoint[] points;
    private int pointsCount;
    /**
     * Опишем конструкторы для работы с классом ArrayTabulatedFunction
     * */

    /**
     * Конструктор ArrayTabulatedFunction(double leftX, double rightX, int pointsCount)
     * Создаёт объект табулированной функции по заданным левой и правой границе области определения.
     * А также количеству точек для табулирования (значения функции в точках при этом следует считать равными 0)
     * */
    public TabulatedFunction(double leftX, double rightX, int pointsCount){
        // определим шаг приращения по оси X
        double step=(rightX-leftX)/(pointsCount-1);
        // создадим массив точек FunctionPoint
        points=new FunctionPoint[pointsCount+100];
        // заполним его на длину pointsCount
        for(int i=0;i<pointsCount-1;i++){
            points[i]=new FunctionPoint(leftX,0);
            leftX+=step;
        }
        // заполним последнее значение
        points[pointsCount-1]=new FunctionPoint(rightX,0);
        // оставшиеся ячейки массива заполним нулевыми значениями
        for(int i=pointsCount;i<points.length;i++){
            points[i]=new FunctionPoint();
        }
        // запомним количество точек в массиве
        this.pointsCount=pointsCount;
    }

    /**
     * Конструктор ArrayTabulatedFunction(double leftX, double rightX, double[] values)
     * Данный конструктор аналогичен предыдущему конструктору.
     * Но вместо количества точек получает значения функции в виде массива.
     * */
    public TabulatedFunction(double leftX, double rightX, double[] values){
        // определим количество точек в массиве
        int pointsCount=values.length;
        // определим шаг приращения по оси X
        double step=(rightX-leftX)/(pointsCount-1);
        // создадим массив точек FunctionPoint
        points=new FunctionPoint[pointsCount+100];
        // заполним его на длину pointsCount
        for(int i=0;i<pointsCount-1;i++){
            points[i]=new FunctionPoint(leftX,values[i]);
            leftX+=step;
        }
        // заполним последнее значение
        points[pointsCount-1]=new FunctionPoint(rightX,values[pointsCount-1]);
        // оставшиеся ячейки массива заполним нулевыми значениями
        for(int i=pointsCount;i<points.length;i++){
            points[i]=new FunctionPoint();
        }
        // запомним количество точек в массиве
        this.pointsCount=pointsCount;
    }

    /**
     * Метод getLeftDomainBorder() возвращает значение левой границы области определения табулированной функции.
     * */
    public double getLeftDomainBorder(){
        return points[0].getX();
    }

    /**
     * Метод getRightDomainBorder() возвращает значение правой границы области определения табулированной функции.
     * */
    public double getRightDomainBorder(){
        return points[pointsCount-1].getX();
    }

    /**
     * Метод getFunctionValue(double x) возвращает значение функции в точке x, если эта точка лежит в области определения функции.
     * В противном случае метод возвратит значение неопределённости (NaN из класса Double)
     * */
    public double getFunctionValue(double x){
        // Проверим, лежит ли искомая точка в области определения функции
        if(Double.compare(x, getLeftDomainBorder()) == -1 || Double.compare(x, getRightDomainBorder()) == 1){
            // Если нет, то функция вернет NaN, потому что она не понимает что от нее хотят
            return Double.NaN;
        }
        // найдем необходимую нам точку
        int i;
        for(i=1;i<points.length;i++){
            if(x<=points[i].getX()){
                break;
            }
        }
        // Рассчитаем необходимые коэффициенты для уравнения прямой
        double x0=points[i-1].getX();
        double y0=points[i-1].getY();
        double dx=points[i].getX()-x0;
        double dy=points[i].getY()-y0;
        // определим тангенс наклона касательной
        double k=dy/dx;
        // рассчитаем искомое значение, функции
        return y0+(x-x0)*k;
    }

    /**
     * Метод getPointsCount() возвращает количество точек.
     * */
    public int getPointsCount(){
        return pointsCount;
    }

    /**
     * Метод FunctionPoint getPoint(int index) возвращает ссылку на объект, описывающий точку, имеющую указанный номер.
     * */
    public FunctionPoint getPoint(int index){
        return points[index];
    }

    /**
     * Метод void setPoint(int index, FunctionPoint point) заменяет указанную точку табулированной функции на заданную.
     * Для функции, определяемой точками {(0; 0), (1; 1), (2; 4)}, точку с индексом 1 нельзя заменить точкой (-1; 5).
     * Однако точку с индексом 0 уже можно заменить.
     * */
    public void setPoint(int index, FunctionPoint point){
        // Проверим, что координата x задаваемой точки не лежит вне интервала, определяемого значениями соседних точек табулированной функции.
        // Если координата x задаваемой точки лежит вне интервала, определяемого значениями соседних точек табулированной функции, то в этом случае замену не производим
        if(index==0){
            if(Double.compare(point.getX(), points[index+1].getX()) >= 0){
                return;
            }
        }
        if(index==pointsCount-1){
            if(Double.compare(point.getX(), points[index-1].getX()) <= 0){
                return;
            }
        }
        // Если координата x задаваемой точки лежит в интервале, определяемым значениями соседних точек табулированной функции, то в производим замену
        points[index]=point;
    }

    /**
     * Метод getPointX(int index) возвращает значение абсциссы точки с указанным номером
     * */
    public double getPointX(int index){
        return points[index].getX();
    }

    /**
     * Метод getPointY(int index) возвращает значение ординаты точки с указанным номером.
     * */
    public double getPointY(int index){
        return points[index].getY();
    }

    /**
     * Метод setPointX(int index, double x) изменяет значение абсциссы точки с указанным номером
     */
    public void setPointX(int index, double value){
        points[index].setX(value);
    }

    /**
     * Метод setPointY(int index, double y) изменяет значение ординаты точки с указанным номером
     * */
    public void setPointY(int index, double value){
        points[index].setY(value);
    }

    /**
     * Метод deletePoint(int index) удаляет заданную точку табулированной функции.
     * */
    public void deletePoint(int index){
        System.arraycopy(points,index+1,points,index,pointsCount-index+1);
        pointsCount--;
    }


    /**
     * Метод Expand - производит расширение массива, на всякий случай вынесем в отдельный метод
     * */
    private void Expand(){
        // Созддаим новый массив которы больше текущего
        FunctionPoint[] newPoints=new FunctionPoint[points.length+100];
        // Инициализируем его нулевыми значениями
        for(int i=0;i<100;i++){
            newPoints[points.length+i]=new FunctionPoint();
        }
        //Произведем копирование значений из старого массива в новый
        System.arraycopy(points,0,newPoints,0,points.length);
        /**
         * points - массив, который копируем
         * 0 - индекс в массиве points, начиная с которого берем элементы для копирования
         * newPoints - массив в которой копируем
         * 0 - индекс в массиве newPoints, начиная с которого вставляем элементы
         * points.length - количество элементов которые берем из массива points и вставляем в массив newPoints
         * */
        // переприсвоим старому массиву новое значение
        points=newPoints;
    }

    /**
     * Метод addPoint(FunctionPoint point) добавляет новую точку табулированной функции.
     * */
    public void addPoint(FunctionPoint point){
        // проверим есть ли место для вставки новой точки
        if(pointsCount==points.length){
            // если нет, то произведем расширение массива
            Expand();
        }
        // Определим место для вставки
        int i;
        for(i=0;i<pointsCount;i++){
            if(point.getX()<points[i].getX()){
                break;
            }
        }
        // Передвигаем часть массива, которая следует за добавляемой точкой
        System.arraycopy(points,i,points,i+1,pointsCount-i);
        // Добавляем нашу точку
        points[i]=point;
        // Увеличиваем число точек функции
        pointsCount++;
    }

    public void printFunction(TabulatedFunction func)
    {
        for(int i=0;i<func.getPointsCount();i++)
        {
            System.out.println("(" + func.getPoint(i).getX() + ":" + func.getPoint(i).getY() + ")");
        }
    }
}
