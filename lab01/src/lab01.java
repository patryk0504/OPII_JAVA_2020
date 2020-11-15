public class lab01 {

    static void draw_line(int x0, int y0, int x1, int y1){
        //liczymy dl. wzgledem OX i OY i dzielimy przez max wartosc dla x i y czyli 100
        double xStep = (x1-x0)/100.;// dl wzgledem oX
        double yStep = (y1-y0)/100.;// dl wzgledem oY
        double X = x0;
        double Y = y0;

        for(int i=0; i<100; i++){
            X += xStep;
            Y += yStep;
            System.out.println(X + " " + Y);
        }
    }

    static void draw_circle(int x0, int y0, int r){
        //korzystamy z wsp biegunowych; krok 0.01
        for(double i=0.; i<2 * Math.PI; i+=0.01){
            double X = x0 + r*Math.cos(i);
            double Y = y0 + r*Math.sin(i);
            System.out.println(X + " " + Y);
        }
    }

    public static void main(String[] args) {
        draw_line(28,65,28,84);
        draw_line(28,84,34,83);
        draw_line(34,83,38,79);
        draw_line(38,79,37,76);
        draw_line(37,76,34,73);
        draw_line(28,72,37,76);
        draw_line(58,25,53,23);
        draw_line(53,23,47,23);
        draw_line(47,23,44,25);
        draw_line(74,65,63,65);
        draw_line(63,65,73,74);
        draw_line(73,74,73,79);
        draw_line(73,79,70,82);
        draw_line(70,82,66,82);
        draw_line(66,82,63,80);
        draw_circle(50,74,9);
        draw_circle(50,29,14);
        draw_circle(55,34,2);
        draw_circle(46,34,2);
    }
}
