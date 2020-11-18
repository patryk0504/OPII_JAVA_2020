public class Square extends Point{
    double side;
    Square(double side, double x, double y){
        super(x,y);
        this.side = side;
    }

    @Override
    public String toString() {
        return "Corner = " + super.toString() + "; side = " + side;
    }

    @Override
    public double area() { return side * side; }

    @Override
    public double volume() { return 0; }

    @Override
    public String getName() { return "Square"; }
}
