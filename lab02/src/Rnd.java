import java.util.Random;

public class Rnd {
    int N = 0;
    int k = 0;
    double[] tab;
    Random gen = new Random();

    Rnd(int N, int k) {
        this.N = N;
        this.k = k;
        tab = new double[N];
        arrayGenerator();
    }

    void arrayGenerator() {
        for (int i = 0; i < N; i++)
            tab[i] = sumGenerator();
    }

    double sumGenerator() {
        double result = 0.;
        for (int i = 0; i < k; i++)
            result += gen.nextDouble();
        return result;
    }

    void Print() {
        for (int i = 0; i < N; i++)
            System.out.println("[" + i + "]=" + tab[i]);
    }

    double Min() {
        double min = tab[0];
        for (var v : tab) {
            if (v < min)
                min = v;
        }
        return min;
    }

    double Max() {
        double max = tab[0];
        for (var v : tab) {
            if (v > max)
                max = v;
        }
        return max;
    }

    double Average() {
        double suma = 0;
        for (var v : tab)
            suma += v;
        return suma / N;
    }

    void Draw() {
        double dy = Math.abs(this.Max() - this.Min());//rozpietosc przedzialu wartosci
        for (int i = 0; i < N; i++) {
            System.out.print("[" + i + "]:");
            double yAndDy = (tab[i] - this.Min()) / dy;//stosunek wartosci argumentu (y0 = Min()) do rozpietosci przedzialu
            int stars = (int) (yAndDy * 50);// x50 bo max 50gwiazdek
            for (int j = 0; j < stars; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}
