package lab_work_3.functions;

public interface TabulatedFunction {
    int getPointsCount();

    double getLeftDomainBorder();
    double getRightDomainBorder();

    double getFunctionValue(double x);

    FunctionPoint getPoint(int index);
    double getPointX(int index);
    double getPointY(int index);

    void setPoint(int index, FunctionPoint point) throws InappropriateFunctionPointException;
    void setPointX(int index, double x) throws InappropriateFunctionPointException;
    void setPointY(int index, double y);

    void addPoint(FunctionPoint point) throws InappropriateFunctionPointException;
    void deletePoint(int index);
}
