public class lab07
{

    //Tej metody nie wolno zmieniac!!!! (Reszte pliku wolno).
    public static void main(String[] args)
    {
        System.out.printf("2.2 + 2.2 = %f%n", calculate((double v1, double v2) -> v1 + v2, 2.2, 2.2));
        System.out.printf("44 / 2.0 = %f%n", calculate((v1, v2) -> v1 / v2, 44, 2.0));
        System.out.printf("-66 = %f%n", calculate(v -> -v, 66));
        System.out.printf("8 * 8 = %f%n", calculate((double v) -> v * v, 8));

        //Uwaga! Klasa Add MUSI zawierac tylko jedna funkcje!!!!
        Add oblicz=new Add();
        oblicz.add(1,2);
        oblicz.add(1,2,3);
        oblicz.add(1,2,3,4,5);
        oblicz.add(1,2,3,4,5,6);
    }

    static double calculate(Equation_1arg obj, double v1){
        return obj.eq(v1);
    }

    static double calculate(Equation_2arg obj, double v1, double v2){
        return obj.eq(v1,v2);
    }
}

@FunctionalInterface
interface Equation_1arg{
    double eq(double v1);
}

@FunctionalInterface
interface Equation_2arg{
    double eq(double v1, double v2);
}

class Add{
    void add(int ... arg){
        int res = 0;
        for(int i=0; i<arg.length-1; i++){
            res += arg[i];
            System.out.print(arg[i] + "+");
        }
        res += arg[arg.length-1];
        System.out.print(arg[arg.length-1] + "=" + res + "\n");
    }
}

/*
Wyjscie z programu wyglada tak:

2.2 + 2.2 = 4,400000
44 / 2.0 = 22,000000
-66 = -66,000000
8 * 8 = 64,000000
1+2=3
1+2+3=6
1+2+3+4+5=15
1+2+3+4+5+6=21
*/