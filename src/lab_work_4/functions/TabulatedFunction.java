package lab_work_4.functions;

public interface TabulatedFunction extends Function{

    int getPointsCount();

    FunctionPoint_4 getPoint(int index);

    double getPointX(int index);

    double getPointY(int index);

    void setPoint(int index, FunctionPoint_4 point) throws InappropriateFunctionPointException;

    void setPointX(int index, double x) throws InappropriateFunctionPointException;

    void setPointY(int index, double y);

    void addPoint(FunctionPoint_4 point) throws InappropriateFunctionPointException;

    void deletePoint(int index);
}
