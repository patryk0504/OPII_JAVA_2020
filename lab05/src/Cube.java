public class Cube extends Square{
    double depth;
    Cube(double depth, double x, double y){
        super(depth,x,y);
        this.depth = depth;
    }

    @Override
    public String toString() {
        return super.toString() + "; depth = " + depth;
    }

    @Override
    public double area() { return 6*super.area(); }

    @Override
    public double volume() { return Math.pow(depth,3); }

    @Override
    public String getName() { return "Cube"; }
}
