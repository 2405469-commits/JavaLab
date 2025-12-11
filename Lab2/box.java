package Lab2;

public class box {

    double length,breadth,height;
    public box(double l, double b, double h) {
        length=l;
        breadth=b;
        height=h;
    }

    double volume()
    {
        return length*breadth*height;
    }
}

