public class Point extends Shape{
    double x,y;
    Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() { return "["+x+", "+y+"]"; }

    @Override
    public String getName() { return "Point"; }

    @Override
    public double area() { return 0; }

    @Override
    public double volume() { return 0; }
}
